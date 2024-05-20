<template>
  <div>
    <plant-list :plantArray="plantArray" :startingVal="startingVal" />
  </div>
</template>

<script>
import PlantList from '../components/plantsList.vue'
// import SearchList from '../components/SearchList.vue'
import PlantService from '../services/PlantService'


export default {
  components: { 
    PlantList,
    // SearchList,
  },
  data() {
    return {
      plantArray: [],
      startingVal: 0,
      // searchResults: []
    };
  },
  created() {
    this.plantArray = this.$store.state.plantArrray
    this.startingVal = this.$store.state.startingVal
    // this.performSearch(this.$route.query.search || '')
  },
  // methods: {
  //   performSearch(query) {
  //     console.log("Search query:", query);
  //     PlantService.searchPlants(query)
  //     .then(response => {
  //       if (Array.isArray(response.data)){
  //         this.searchResults = response.data;
  //       } else if (response.data instanceof Object){
  //         this.searchResults = [response.data];
  //       } else {
  //         this.searchResults = [];
  //       }
  //     })
  //     .catch(error => {
  //       console.error(error);
  //     });
  //   }
  // }
};
</script>