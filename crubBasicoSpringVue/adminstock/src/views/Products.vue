<template>
  <div>
    <h1>Products</h1>
    <div class="principal">
      <div class="addproduct">

        <div class="d-flex p-2">
          <button
            type="button"
            class="btn btn-success d-flex flex-row m-3 text-dark"
          >
            <router-link class="link" to="/addproducts"
              >Add Product</router-link
            >
          </button>

          <button
            type="button"
            class="btn btn-primary d-flex flex-row m-3 text-white"
            v-on:click="refreshPage()"
          >
            Refresh
          </button>
        </div>

      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">Quantidade</th>
            <th scope="col">Preço</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="dado in products" :key="dado.id">
            <td>{{ dado.id }}</td>
            <td>{{ dado.nome }}</td>
            <td>{{ dado.amount }}</td>
            <td>{{ dinheiro(dado.price) }}</td>
            <td>
              <!--Passando parametros via router do id que vc quer fazer o update-->
              <router-link
                class="link"
                v-bind:to="{ name: 'UpdateProducts', params: { id: dado.id } }"
              >
                <button type="button" class="btn btn-warning">Update</button>
              </router-link>

              <!--Metodo passa como parametro o id que vc deseja deletar-->
              <button
                type="button"
                class="btn btn-danger"
                v-on:click="deletar(dado.id)"
              >
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      products: {},
    };
  },

  methods: {
    dinheiro(valor) {
      return "R$ " + valor.toFixed(2);
    },

    getProducts() {
      axios.get("http://localhost:8081/products").then((resp) => {
        this.products = resp.data;
      });
    },

    //First method created nos in used.
    deleteProducts(id) {
      axios
        .delete(`http://localhost:8081/products/${id}`)
        .then((resp) => {
          this.products = resp.data;
        })
        .then(() => {
          this.$swal({
            title: "Produto Deletado com sucesso",
            icon: "error",
            showConfirmButton: true,
            showCancelButton: true,
            cancelButtonColor: "#ff7674",
            allowOutsideClick: false,
            allowEnterKey: true,
            allowEscapeKey: false,
          }).then(() => {
            this.$router.go();
          });
        });
    },

    deletar(id) {
      this.$swal({
        title: "Are you sure you want to delete?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#36c6d3",
        cancelButtonColor: "#d33",
        confirmButtonText: "Confirm",
        cancelButtonText: "Cancel",
      }).then((result) => {
        if (result.value) {
          this.$swal(
            "Deleted!",
            "Your product has been deleted.",
            "success"
          ).then(() => {
            axios
              .delete(`http://localhost:8081/products/${id}`)
              .then((resp) => {
                this.products = resp.data;
              })
              .then(() => {
                this.$router.go();
              });
          });
          console.log("good");
        } else if (result.dismiss == "cancel") {
          this.$swal("Cancelled", "Product has not been deleted", "error");
          console.log("cancel");
        }
      });
    },

    refreshPage() {
      this.$router.go();
    },
  },

  // Chama a função no momento da criação do vue
  created() {
    this.getProducts();
  },
};
</script>


<style>
.link {
  text-decoration: none;
  color: white;
}
.btn {
  margin-right: 1%;
}
</style>