import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: '',
    username: '',
    permissions: null
  },
  getters: {
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token
    },
    SET_USERNAME(state, username) {
      state.username = username
    },
    SET_PERMISSIONS(state, permissions) {
      state.permissions = permissions
    }
  },
  actions: {
    SET_TOKEN(context, token) {
      context.commit('SET_TOKEN' ,token)
    },
    SET_USERNAME(context, username) {
      context.commit('SET_USERNAME', username)
    },
    SET_PERMISSIONS(context, permissions) {
      context.commit('SET_PERMISSIONS', permissions)
    }
  },
  modules: {
  }
})
