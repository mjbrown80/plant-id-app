<template>
  <div id="app">
    <header>
      <h1 id="header-text">Growing a Greener Thumb</h1>
      <p id="header-quote">Improving the world with you knowledge</p>
      <div id="monet-quote">
      <p>"My garden is my most beautiful masterpiece"</p>
      <p>-Claude Monet</p>
      </div>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" class="nav-link" >Home</router-link>
      <router-link v-bind:to="{ name: 'plants' }" class="nav-link">Plants</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="nav-link">Logout</router-link>
      <!-- <input type="text" placeholder="Search.." class="nav-search"> -->
      <search-bar @search="performSearch"/>
    </div>
    </header>
    <router-view />
  </div>
</template>

<script>
import SearchBar from './components/SearchBar.vue'
import PlantService from './services/PlantService';

export default {
  components: {
    SearchBar,
  },
  methods: {
    performSearch(query){
      this.$router.push({ name: 'plants', query: { search: query}})
    }
  }
}
</script>


<style>
*{
  margin: 0px;
  padding: 0px;
}
#app{
  text-align: center;
  
}
header {
  display: flex;
  flex-direction: column;
  background: linear-gradient(45deg, #0A7029,#FEDE00, #DBE8D8);
  height: 17rem;
  justify-content: space-between;
}
body {
  /* background: linear-gradient(240deg, #0A7029 ,#FEDE00,#DBE8D8); */
  background-image: url("./assets/painting1.jpeg");
  background-size: cover;
  min-height: 100vh;
}
#header-text {
  color:#0A7029;
  font-size: 5rem;
}
#header-quote {
  color:#0A7029;
  font-size: 2rem;
}
#nav {
  padding: 14px 16px;
  padding: 1rem;
  background-color: #FEDE00;
  border: #0A7029;
  border-style: outset;
}
#nav a:hover {
  background-color: #0A7029;
  color: ivory;
}
/* #nav a:active {
  background-color: #0A7029;
  color: white;
} */
.nav-link {
  font-size: 30px;
  float: left;
  padding: 14px 16px;
  text-decoration: none;
}
#monet-quote{
  color: #0A7029;
}
input {
  float: right;
  padding: 10px;
  border: none;
  margin-top: 8px;
  margin-right: 16px;
  font-size: 17px;
}
</style>