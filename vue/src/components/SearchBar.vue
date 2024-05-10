<template>
  <div>
    <input type="text" v-model="searchQuery" @input="search" placeholder="Search..." class="nav-search" >
  </div>
</template>

<script>
export default {
    data() {
        return{
            searchQuery: ''
        }
    },
    methods: {
        search(){
            this.$emit('search', this.searchQuery)
        }
    }

}
</script>

<style>
.nav-search{
    padding: 10px;
    border: none;
    font-size: 17px;
}

</style>