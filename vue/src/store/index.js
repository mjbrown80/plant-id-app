import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      startingVal: 0,
      plantArray: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      GET_NEXT_PREVIOUS(state, values){
        state.startingVal = values.startingVal
        state.plantArray = values.plantArray
        console.log('GET_NEXT_PREVIOUS mutation called. New startingVal', values.startingVal, 'New plantArray:' , values.plantArray)
      },
      INIT_PLANTS(state, plants){
        state.plantArray = plants
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        state.plantArray = []
        state.startingVal = 0
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
