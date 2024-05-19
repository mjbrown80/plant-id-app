<template>
  <div>
    <search-list v-if="searchResults.length > 0" :plantArray="searchResults"/>
    <plant-list v-else />
  </div>
</template>

<script>
import PlantList from '../components/plantsList.vue';
import SearchList from '../components/SearchList.vue';
import PlantService from '../services/PlantService';


export default {
  components: { 
    PlantList,
    SearchList,
  },
  data() {
    return {
      searchResults: []
    };
  },
  created() {
    this.performSearch(this.$route.query.search || '');
  },
  watch: {
    '$route.query.search'(newVal) {
      this.performSearch(newVal || '');
    }
  },
  methods: {
    performSearch(query) {
      console.log("Search query:", query);
      PlantService.searchPlants(query)
      .then(response => {
        if (Array.isArray(response.data)){
          this.searchResults = response.data;
        } else if (response.data instanceof Object){
          this.searchResults = [response.data];
        } else {
          this.searchResults = [];
        }
      })
      .catch(error => {
        console.error(error);
      });
    }
  }
};
</script>