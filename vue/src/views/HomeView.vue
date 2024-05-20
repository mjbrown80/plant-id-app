<template>
  <div class="home">
   <plant-list :plantArray="plantArray" :startingVal="startingVal" ></plant-list>
  </div>
</template>

<script>

import PlantList from '../components/plantsList.vue'
import PlantService from '../services/PlantService'
export default {
  components: { 
    PlantList,
  },
  data() {
    return {
      plantArray: [],
      startingVal: 0,
    }
  },
  created() {
    this.plantArray = this.$store.state.plantArrray
    this.startingVal = this.$store.state.startingVal
  },
};
</script>
