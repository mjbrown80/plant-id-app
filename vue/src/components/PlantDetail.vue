<template>
    <div id="detail-container">
  <div id="detail-card">
    <h2> {{ plant.common_name }}</h2>
    <p>Alternate name: {{ plant.other_name }}</p>
    <p>Scientific Name: {{ plant.scientific_name }}</p>
    <img id="detail-image" :src="image" alt="No Image Available">
    <h3>Details/Care</h3>
    <p>{{ plant.cycle }}</p>
    <p>Sunlight required: {{ plant.sunlight }}</p>
    <p>Water Needed: {{ plant.watering }}</p>
    <p></p>
  </div>
  </div>
  <router-link to="/plants">
        <button id="detail-back-btn">Back to Plants</button>
    </router-link>
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
#detail-card{
    width: 500px;
    margin: 2rem;
    border: black;
    border-style: outset;
    background:linear-gradient( #C8DF52,#0A7029);
}
#detail-container {
    display: flex;
    justify-content: center;
}
#detail-back-btn {
    background: #C8DF52;
    height: 2rem;
    padding: 0 1rem;
    font-size: large;   
    
}
</style>