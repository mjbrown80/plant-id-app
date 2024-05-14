<template>
  <div>
    <search-list v-if="searchResults.length > 0" :plantArray="searchResults"/>
    <plants-list v-else :plantArray="allPlants"/>
    <div id="button-container">
    <button id="previous-plants" @click="getPreviousPlants" v-if="startingVal !== 0">previous</button>
    <button id="next-plants" @click="getNextPlants">next</button>
    </div>
  </div>
</template>

<script>
import plantsList from '../components/plantsList.vue'
import SearchList from '../components/SearchList.vue'
import PlantService from '../services/PlantService'


export default {
  components: { 
    plantsList,
    SearchList, 
    
  },
  data() {
    return {
      allPlants: [],
      searchResults: []
    }
  },
  computed: {
    startingVal() {
      return this.$store.state.startingVal
    }
  },
  created() {
    this.getAllPlants()
    this.performSearch(this.$route.query.search || '')
  },
  watch: {
    '$route.query.search'(newVal, oldVal) {
      this.performSearch(newVal || '')
    }
  },
  methods: {
    getAllPlants(){
      PlantService.getPlants()
      .then(response => {
        this.allPlants = response.data
      })
    },
    performSearch(query){
      console.log("Search query:", query)
      PlantService.searchPlants(query)
      .then(response => {
        if (Array.isArray(response.data)){
          this.searchResults = response.data
        }else if (response.data instanceof Object){
          this.searchResults = [response.data]
        }else {
          this.searchResults = []
        }
      })
      .catch(error => {
        console.error(error)
       })
    },
    getNextPlants() {
      let start = this.$store.state.startingVal +30
      PlantService.getNewPlants(start)
      .then( response => {
        let values = {
          startingVal: start,
          plantArray: response.data
        }
        this.$store.commit("GET_NEXT_PREVIOUS", values)
        this.plantArray = response.data
      })
    },
    getPreviousPlants() {
      let start = Math.max(this.$store.state.startingVal -30, 0)
      PlantService.getNewPlants(start)
      .then(response => {
        let values = {
          startingVal: start,
          plantArray: response.data
        }
        this.$store.commit("GET_NEXT_PREVIOUS", values)
        this.plantArray = response.data
      })
    }
  },
}
</script>

<style>

</style>