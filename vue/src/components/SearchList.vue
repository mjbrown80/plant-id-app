<template>
  <div>
    <ul>
      <li v-for="plant in plantArray" v-bind:key="plant.id">
        <router-link
          :to="{
            name: 'detail',
            params: {
              id: plant.id,
            },
          }"
        >
        <div id="card">
          {{ plant.name }}
          <img
              id="thumbnail"
              v-bind:src="plant.url"
              alt="No Image Available"
            />
        </div>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  name: "search-list",
  props: {
    plantArray: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style>
</style>