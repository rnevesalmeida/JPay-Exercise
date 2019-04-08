import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Configurations from '@/components/Configurations'

Vue.use(Router)

let router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/configurations',
      name: 'Configurations',
      component: Configurations
    }
  ]
})

export default router
