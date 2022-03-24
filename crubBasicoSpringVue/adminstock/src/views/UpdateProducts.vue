<template>
  <div>
    <h1>Update Products</h1>

    <h3>Update product id: {{ numero }}</h3>

    <form action="post/products">
      <div>
        <div class="m-4">
          <!--NOME-->
          <div class="input-group input-group-lg m-2 p-2">
            <div class="input-group-prepend mr-3">
              <span class="input-group-text m-2" id="inputGroup-sizing-lg"
                >Nome</span
              >
            </div>
            <input
              type="text"
              class="form-control"
              aria-label="Large"
              aria-describedby="inputGroup-sizing-sm"
              v-model="product.nome"
            />
          </div>

          <!--Quantidade-->
          <div class="input-group input-group-lg m-2 p-2">
            <div class="input-group-prepend mr-3">
              <span class="input-group-text m-2" id="inputGroup-sizing-lg"
                >Quant.</span
              >
            </div>
            <input
              type="text"
              class="form-control"
              aria-label="Large"
              aria-describedby="inputGroup-sizing-sm"
              v-model="product.amount"
            />
          </div>

          <!--PREÇO-->
          <div class="input-group m-2 p-2">
            <div class="input-group-append">
              <span class="input-group-text m-2">R$</span>
            </div>
            <input
              type="text"
              class="form-control m-2"
              aria-label="Amount (to the nearest dollar)"
              v-model="product.price"
            />
          </div>
        </div>

        <router-link class="btnUpdate" to="/products">
          <button class="btn btn-success m-1">
            Voltar
          </button>
        </router-link>

        <button v-on:click="updateProduct()" class="btn btn-primary">
          Update
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      numero: this.$route.params.id,
      product: {},
    };
  },

  methods: {
      // Primeiro processo a se fazer e pegar o GET com o parametro enviado da pagina de products pela roda this.$route.params.id
    getProducts() {
      axios
        .get(`http://localhost:8081/products/${this.numero}`)
        .then((resp) => {
          this.product = resp.data;
        });
    },
    updateProduct() {
      axios
        .put(`http://localhost:8081/products/${this.numero}`, this.product)
        .then((resp) => {
          this.product = resp.data;
        })
        .then(() => {
          this.$swal({
            title: "Product updated",
            icon: "toast top end",
            showConfirmButton: true,
            allowOutsideClick: false,
            allowEnterKey: true,
            allowEscapeKey: false,
          });
        });
      this.$router.push("/products");
    },
  },

  created() {
    this.getProducts();
  },
};
</script>


<style>
.btnUpdate{
    margin: 1%;
    padding: 1%;
}
</style>