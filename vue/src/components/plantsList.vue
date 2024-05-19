
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
    
  </div>
</template>

<script>
import plantService from "../services/PlantService";

export default {
  name: "plant-list",
  computed: {
    plantArray() {
      return this.$store.state.plantArray
    }
  }
  // data() {
  //   return {
  //     plantArray: [],
  //   };
  // },
  // methods: {},
  // created() {
  //   if(!this.$store.state.plantArray.length){
  //     plantService.getPlants()
  //     .then(response => {
  //       this.$store.commit("INIT_PLANTS", response.data)
  //     })
  //   }
  // },
  }
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

<!-- <template>
  <div>
    <button>hello</button>
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
      <button id="next-plants" @click="getNextPlants">Next</button>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
import plantService from "../services/PlantService";

export default {
  name: "plant-list",
  computed: {
    ...mapState(['plantArray', 'startingVal']),
    allPlants() {
      return this.plantArray;
    }
  },
  created() {
    if (!this.plantArray.length) {
      console.log('Fetching initial plants');
      plantService.getPlants().then(response => {
        this.$store.commit("INIT_PLANTS", response.data);
        console.log('Initial plants:', response.data);
      });
    }
  },
  methods: {
    ...mapMutations(['GET_NEXT_PREVIOUS']),
    getNextPlants() {
      let start = this.startingVal + 30;
      console.log('Fetching next plants from', start);
      plantService.getNewPlants(start).then(response => {
        console.log('Next plants:', response.data);
        this.GET_NEXT_PREVIOUS({ startingVal: start, plantArray: response.data });
      });
    },
    getPreviousPlants() {
      let start = Math.max(this.startingVal - 30, 0);
      console.log('Fetching previous plants from', start);
      plantService.getNewPlants(start).then(response => {
        console.log('Previous plants:', response.data);
        this.GET_NEXT_PREVIOUS({ startingVal: start, plantArray: response.data });
      });
    }
  },
  watch: {
    plantArray(newVal) {
      console.log('Updated plantArray:', newVal);
    },
    startingVal(newVal) {
      console.log('Updated startingVal:', newVal);
    }
  }
};
</script>

<style>
/* Same CSS as before */
</style>

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
</style> -->