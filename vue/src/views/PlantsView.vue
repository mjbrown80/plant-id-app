<template>
  <div>
  
    <search-list v-if="searchResults.length > 0" :plantArray="searchResults"/>
    <plants-list v-else :plantArray="allPlants"/>
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
    }
  }


}
</script>

<style>

</style>