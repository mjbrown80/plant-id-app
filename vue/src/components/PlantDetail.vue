<template>
  <div>
    <h2> </h2>
  </div>
</template>

<script>
import plantService from '../services/PlantService'
export default {
    name: 'plant-detail',
    props: {
        id: Number, String
    },
    data(){
        return{
            plant: {},
        }
    },
    created() {
        plantService.getPlantById(this.id)
        .then(response => {
            console.log(response)
            this.plant = response.data
        })
    }

}
</script>

<style>

</style>