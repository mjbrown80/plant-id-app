import axios from 'axios'

const http = axios.create( {
    baseURL: 'http://localhost:9000'
})

export default {
    getPlants() {
        return http.get('/plantlist')
    },
    getPlantById(id) {
        return http.get(`/plant/${id}`)
    },
}