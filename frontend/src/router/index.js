import { createRouter, createWebHistory } from 'vue-router'

//mport TableResults from '../components/TableResults.vue'
import CreateForm from '../components/CreateContactForm.vue'
import FilterTable from '../components/FilterTable.vue'
import TestPrueba from '../components/TestPrueba.vue'


const routes = [
  {
    path: '/',
    name: 'home',
    component: TestPrueba
  },
  {
    path: '/consultarf',
    name: 'consultf',
    component: FilterTable
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
