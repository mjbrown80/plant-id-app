import axios from 'axios'

const http = axios.create( {
    baseURL: 'http://localhost:9000'
})

export default {
    getPlants() {
        return http.get('/plantlist')
    },
    getPlantById(id) {
        return http.get(`/plants/${id}`)
    },
    searchPlants(query) {
        return http.get(`/plant?query=${query}`)
    }   ,
    getNewPlants(startVal){
        return http.get(`/plantlist/${startVal}`)
    }
}