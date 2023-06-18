import { createStore } from 'vuex'  // 全局module
import ModuleUser from './user'

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user:ModuleUser,
  }
})
