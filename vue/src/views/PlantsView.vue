<template>
  <div>
    <plant-list :plantArray="plantArray" :startingVal="startingVal" />
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
    };
  },
  created() {
    this.plantArray = this.$store.state.plantArray
    this.startingVal = this.$store.state.startingVal
    
  },
  
};
</script>