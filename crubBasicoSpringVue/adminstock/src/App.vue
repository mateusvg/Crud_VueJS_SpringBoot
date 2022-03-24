<template>
  <div id="app">
    <div id="nav">
      <Menu />
      <hr>
    </div>
    <router-view />
  </div>
</template>

<script>
import Menu from "./components/menu.vue";
export default {
  components: {
    Menu,
  },
};
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  text-decoration-line: none;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #19ec8d;
      text-decoration-line: none;
    }
  }
}
</style>
