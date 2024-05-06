<template>
  <div>
    <ul id="card">
        <li v-for="plant in plantArray" v-bind:key="plant.id">
            <router-link
            v-bind:to="{
                name: 'detail',
                params: {
                    id: plant.id,
                    name: plant.name,
                    url: plant.url
                },
            }">
            {{ plant.name }}
            <img id="thumbnail" v-bind:src="plant.url" alt="./assets.no-image.png">
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
    margin: 5rem;
    margin-top: 1rem;
}
#card {
    display: flex;
}
</style>