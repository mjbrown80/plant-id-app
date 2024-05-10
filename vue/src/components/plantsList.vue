<template>
  <div>
    <ul >
        <li v-for="plant in plantArray" v-bind:key="plant.id">
           <router-link
            v-bind:to="{
                name: 'detail',
                params: {
                    id: plant.id,
                },
            }">
            <div id="card" >
            {{ plant.name }}
            <img id="thumbnail" v-bind:src="plant.url" alt="No Image Available">
            
            </div>
            </router-link>
        </li>
    </ul>
  </div>
</template>

<script>
import plantService from '../services/PlantService'

export default {
    name: 'plant-list',
    data() {
        return {
            plantArray : [],
        }
    },
    created() {
        plantService.getPlants()
        .then(response => {
            console.log(response)
            this.plantArray = response.data;
        })
    }
}
</script>

<style>
ul > li {
 list-style-type: none;
}
#thumbnail {
    width: 200px;
    height: 200px;
    margin: auto;
    margin-top: 1rem;
    margin-bottom: 3rem;
    display: block;
}
#card {
    width: 300px;
    border: black;
    border-style: outset;
    margin: 2rem;
    align-content: center;
    background:linear-gradient( #C8DF52,#0A7029);
}
li {
    display: inline-block;
}
</style>