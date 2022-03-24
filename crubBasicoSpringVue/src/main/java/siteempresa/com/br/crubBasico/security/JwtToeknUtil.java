package siteempresa.com.br.crubBasico.security;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToeknUtil implements Serializable {

	private static final long serialVersionUID= 234234523523L;
	
	public static final long JWT_TOKEN_VALIDITY = 5*60*60;
	
	@Value("${jwt.secret}")
	private String secretKey;
	private String chave;
	
	public String getHashSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[]= algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b: messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
	String senhahex = hexString.toString();
	return senhahex;
	}
	
	
	//retieve username for jwt token
	public String getUsernameFromToken(String Token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	
	//retrive expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	
	//for retrieving any information from token we will need the secrete key
	@SuppressWarnings("deprecation")
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//generete token for user
	public String genereteToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenereteToken(claims, userDetails.getUsername());
	}
	
	
	
	private String doGenereteToken(Map<String, Object> claims, String subject) {
		try {
			chave= getHashSenha(secretKey);
		}catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY *1000))
			.signWith(SignatureAlgorithm.HS256, chave).compact();
	}
	
	
	//validate token
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String Username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}
	
}
