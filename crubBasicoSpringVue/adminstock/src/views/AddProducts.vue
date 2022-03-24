<template>
  <div>
    <h1>Add Products</h1>
    <form action="post/products">
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
            v-model="form.nome"
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
            v-model="form.amount"
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
            v-model="form.price"
          />
        </div>
      </div>

      <button
        v-on:click="addProducts()"
        class="btn btn-primary"
      >
        ADD
      </button>
      
    </form>
  </div>
</template>


<script>
import axios from "axios";

export default {
  data() {
    return {
      form: {
        price: this.price,
        nome: this.nome,
        amount: this.amount,
      },
    };
  },

  methods: {
    addProducts() {
      axios
        .post("http://localhost:8081/products", this.form)
        .then((resp) => {
          this.form = resp.data;
        })
        .then(() => {
          this.$swal({
            title: "Product added successfully",
            icon: "success",
            showConfirmButton: true,
            allowOutsideClick: false,
            allowEnterKey: true,
            allowEscapeKey: false,
          });
        });

      this.$router.push("/products");
      this.$router.go();
    },
  },
};
</script>


<style>
</style>