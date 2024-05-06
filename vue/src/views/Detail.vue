<template>
  <plant-detail v-bind:id="$route.params.id"></plant-detail>
</template>

<script>
import PlantDetail from '../components/PlantDetail.vue'
export default {
  name:'detail',
  components: { 
    PlantDetail 
  },

}
</script>

<style>

</style>