<template>
  <div>
    <ul>
        <li v-for="plant in plantArray" v-bind:key="plant.id" >
            <router-link :to="{name: 'plant-detail', params: {id: plant.id}}">
            {{ plant.name }}
            </router-link>
        </li>
    </ul>

  </div>
</template>

<script>
import PlantService from '../services/PlantService';
export default {
    name: "search-list",
    props: {
        plantArray: {
            type: Array,
            required: true
        }
    }

}
</script>

<style>

</style>