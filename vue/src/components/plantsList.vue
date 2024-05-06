<template>
  <div>Yes</div>
</template>

<script>
import plantService from '../services/PlantService'

export default {
    name: 'plant-list',
    data() {
        return {
            plantArray : []
        }
    },
    created() {
        plantService.getPlants()
        .then(response => {
            console.log(response)
        })
    }
}
</script>

<style>

</style>