<template>
  <div class="conteudo">
    <ul>
      <router-link to="/">
        <li>Home</li>
      </router-link>
      <router-link to="/about">
        <li>About</li>
      </router-link>
      <router-link to="/categories">
        <li>Categories</li>
      </router-link>
      <router-link to="/products">
        <li>Products</li>
      </router-link>
    </ul>
  </div>
</template>
<script>
export default {};
</script>

<style lang ="scss" scoped>
@media (max-width: 490px) {
  .conteudo {
      font-size: 80%;
  }
}

.conteudo {
  ul {
    display: flex;
    list-style: nome;
    justify-content: space-around;
    align-items: center;
    li {
      margin-left: 1%;
      list-style-type: none;
      width: 100px;
      text-decoration-line: none;
    }
  }
  li{
    font-family: Arial, Helvetica, sans-serif;

  }
}
</style>