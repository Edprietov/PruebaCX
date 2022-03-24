import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TableResults from '../components/TableResults.vue'
import CreateForm from '../components/CreateContactForm.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/consultar',
    name: 'consult',
    component: TableResults
  },
  {
    path: '/crear',
    name: 'create',
    component: CreateForm
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
