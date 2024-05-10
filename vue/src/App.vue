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
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'plants' }">Plants</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <div>
      
    </div>
    </header>
    <router-view />
  </div>
</template>

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
  padding: 1rem;
  background-color: #FEDE00;
  border: #0A7029;
  border-style: outset;
}
#monet-quote{
  color: #0A7029;
}
</style>