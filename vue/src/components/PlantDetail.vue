<template>
  <div>
    <h2> {{ name }}</h2>
  </div>
</template>

<script>
import plantService from '../services/PlantService'
export default {
    name: 'plant-detail',
    props: {
        id: Number, String,
        name: String,
    },
    data(){
        return{
            plant: {},
            image: "",
        }
    },
    created() {
        plantService.getPlantById(this.id)
        .then(response => {
            console.log(response)
            this.plant = response.data
            this.image = response.data.default_image.original_url
        })
    }

}
</script>

<style>

</style>