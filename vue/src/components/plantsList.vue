<template>
  <div>
    <ul>
      <li v-for="plant in allPlants" :key="plant.id">
        <router-link :to="{ name: 'detail', params: { id: plant.id } }">
          <div id="card">
            {{ plant.name }}
            <img id="thumbnail" :src="plant.url" alt="No Image Available" />
          </div>
        </router-link>
      </li>
    </ul>
    <div id="button-container">
      <button id="previous-plants" @click="getPreviousPlants" :disabled="startingVal === 0">Previous</button>
      <button id="next-plants" @click="getNextPlants" :disabled="allPlants.length < 30">Next</button>
    </div>
  </div>
</template>

<script>
import plantService from "../services/PlantService";

export default {
  name: "plant-list",
  data() {
    return {
      // allPlants: [],
      // startingVal: 0,
    }
  },
  created() {
    if(!this.$store.state.plantArray.length) {
      console.log('Fetching intial plants')
      plantService.getPlants()
      .then( response => {
        this.$store.commit("INIT_PLANTS", response.data)
        console.log('Inital plants:', response.data)
      })
    }
    // this.allPlants = this.$store.state.plantArray
    // this.startingVal = this.$store.state.startingVal
  },
  computed: {
    allPlants() {
      return this.$store.getters.allPlants
    },
    startingVal() {
      return this.$store.getters.startingVal
    }
  },
  methods: {
    getNextPlants() {
      let start = this.startingVal + 30;
      console.log('Fetching next plants from', start)
      plantService.getNewPlants(start)
      .then(response => {
        console.log('Next plants:', response.data)
        this.$store.commit("GET_NEXT_PREVIOUS", {startingVal: start, plantArray: response.data})
      });
    },
    getPreviousPlants() {
      let start = Math.max(this.startingVal - 30, 0)
      console.log('Fetching previous plants from', start)
      plantService.getNewPlants(start).then(response => {
        console.log('Previous plants:', response.data)
        this.$store.commit("GET_NEXT_PREVIOUS", { startingVal: start, plantArray: response.data })
      });
    }
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
#previous-plants, #next-plants {
  background-color: #0a7029;
  color: ivory;
  margin: 20px;
  padding: 8px 16px;
  border-radius: 10px;
  min-height: 30px;
  min-width: 120px;
}
#next-plants:hover {
  background-color: #C8DF52;
  color: #0a7029;
  transition: 0.7s;
}
#previous-plants:hover {
  background-color: #C8DF52;
  color: #0a7029;
  transition: 0.7s;
}
</style>