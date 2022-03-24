<template>
  <div class="home">
    <h1>SKILLS</h1>

    <div class="cards">
      <div class="card bg-light mb-3 m-2" style="width: 18rem; height: 12rem">
        <div class="card-header">Javascript</div>
        <div class="card-body">
          <h5 class="card-title">1 - Vue.JS</h5>
          <h5 class="card-title">2 - Protractor</h5>
          <h5 class="card-title">3 - Cypress</h5>
          <h5 class="card-title">4 - Node</h5>
        </div>
      </div>

      <div class="card bg-light mb-3 m-2" style="width: 18rem; height: 12rem">
        <div class="card-header">Ruby</div>
        <div class="card-body">
          <h5 class="card-title">1 - Automation Tests</h5>
          <h5 class="card-title">2 - Selenium WebDriver</h5>
        </div>
      </div>

      <div class="card bg-light mb-3 m-2" style="width: 18rem; height: 12rem">
        <div class="card-header">C#</div>
        <div class="card-body">
          <h5 class="card-title">1 - Asp.net MVC</h5>
          <h5 class="card-title">2 - CRUD</h5>
        </div>
      </div>

      <div class="card bg-light mb-3 m-2" style="width: 18rem; height: 12rem">
        <div class="card-header">Java</div>
        <div class="card-body">
          <h5 class="card-title">1 - SpringBoot</h5>
        </div>
      </div>

      <div class="card bg-light mb-3 m-2" style="width: 18rem; height: 12rem">
        <div class="card-header">PHP</div>
        <div class="card-body">
          <h5 class="card-title">1 - CRUD</h5>
          <h5 class="card-title">2 - Web Backend OO</h5>
        </div>
      </div>

      <div class="card bg-light mb-3 m-2" style="width: 18rem; height: 12rem">
        <div class="card-header">Python</div>
        <div class="card-body">
          <h5 class="card-title">1 - Kafka Microservice</h5>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  components: {},
};
</script>

<style scoped>
.cards {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}
.card-title {
  text-align: left;
}
</style>