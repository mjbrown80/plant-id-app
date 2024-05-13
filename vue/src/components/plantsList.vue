<template>
  <div>
    <ul>
      <li v-for="plant in plantArray" v-bind:key="plant.id">
        
          <router-link
            v-bind:to="{
              name: 'detail',
              params: {
                id: plant.id,
              },
            }"
          >
          <div id="card">
            {{ plant.name }}
            <img
              id="thumbnail"
              v-bind:src="plant.url"
              alt="No Image Available"
            />
            </div>
          </router-link>
      </li>
    </ul>
    <div id="button-container">
    <button id="previous-plants" v-if="$store.state.startingVal != 0">previous</button>
    <button id="next-plants" @click="getNextPlants">next</button>
    </div>
  </div>
</template>

<script>
import plantService from "../services/PlantService";


export default {
  name: "plant-list",
  data() {
    return {
      plantArray: [],
    };
  },
  methods: {
    getNextPlants() {
      let start = this.$store.state.startingVal
      start += 30
      plantService.getNewPlants(start)
      .then( response => {
        this.plantArray = response.data
        let values = {
          startingVal: start
        }
        this.$store.commit("GET_NEXT_PREVIOUS", values)
      })
    }
  },
  created() {
    plantService.getPlants().then((response) => {
      console.log(response);
      this.plantArray = response.data;
    });
  },
};
</script>

<style>
ul > li {
  list-style-type: none;
}
#thumbnail {
  width: 200px;
  height: 200px;
  margin: auto;
  margin-top: 1rem;
  margin-bottom: 3rem;
  display: block;
}
#card {
  width: 300px;
  height: 300px;
  border: black;
  border-style: outset;
  margin: 1rem;
  align-content: center;
  background: linear-gradient(#c8df52, #0a7029);
}
li {
  display: inline-block;
}
#button-container {
  margin-top: 20px;
}
#previous-plants, #next-plants{
  background-color: #0a7029;
  color: ivory;
  margin: 20px;
  padding: 8px 16px;
  border-radius: 10px;
  min-height: 30px;
  min-width: 120px;
}
 #next-plants:hover{
  background-color: #C8DF52;
  color: #0a7029;
  transition: 0.7s;
}
#previous-plants:hover{
  background-color: #C8DF52;
  color: #0a7029;
  transition: 0.7s;
}


</style>