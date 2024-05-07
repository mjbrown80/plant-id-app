<template>
  <div>
    <h2> {{ plant.common_name }}</h2>
    <p>Alternate name: {{ plant.other_name }}</p>
    <p>Scientific Name: {{ plant.scientific_name }}</p>
    <img id="detail-image" :src="image" alt="">
    <h3>Details/Care</h3>
    <p>{{ plant.cycle }}</p>
    <p>Sunlight required: {{ plant.sunlight }}</p>
    <p>Water Needed: {{ plant.watering }}</p>
    <p></p>
  </div>
</template>

<script>
import plantService from '../services/PlantService'
export default {
    name: 'plant-detail',
    props: {
        id: [Number, String],
        // name: String,
        // cycle: String
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
#detail-image{
    width: 400px;
}
</style>