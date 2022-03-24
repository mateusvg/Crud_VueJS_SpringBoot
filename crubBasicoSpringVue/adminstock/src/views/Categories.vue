<template>
  <div>
    <div class="categories">

      <h1>
          Categories
      </h1>
      <div class="list">

              <table class="table">
        <thead>
          <tr>
       
            <th scope="col">ID</th>
            <th scope="col">Nome</th>

          </tr>
        </thead>
        <tbody>
          <tr v-for="qualquernome in categories" :key="qualquernome.id">
         
            <td>{{qualquernome.id}}</td>
            <td>{{qualquernome.name}}</td>

          </tr>
 

        </tbody>
      </table>

      </div>

    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
data(){
  return{
    categories:{}
  }
},

methods: {
  getCategories(){
    axios.get('http://localhost:8081/categories').then(respostaDaResuisicao =>{
      this.categories = respostaDaResuisicao.data
    })
  }
},

created(){
  this.getCategories()
}

}
</script>

<style>

</style>