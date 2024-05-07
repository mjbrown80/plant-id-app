<template>
  <div id="app">
    <header>
      <h1 id="header-text">Growing a Greener Thumb</h1>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'plants' }">Plants</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    </header>
    <router-view />
  </div>
</template>

<style>
#app{
  text-align: center;
  margin: 0px;
  padding: 0px;
}
header {
  display: flex;
  flex-direction: column;
  background: linear-gradient(45deg, #0A7029,#FEDE00);
  height: 17rem;
  justify-content: space-between;
  padding: 0px, 20px;
}
body {
  background: linear-gradient(45deg, #0A7029,#DBE8D8 ) ;
}
#header-text {
  color: ivory;
  font-size: 5rem;
}
#nav {
  padding: 1rem;
  background-color: #FEDE00;
  border: #0A7029;
  border-style: outset;
  
}
</style>