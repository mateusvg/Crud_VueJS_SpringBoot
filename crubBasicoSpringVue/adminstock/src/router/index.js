import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'


Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/About.vue')
    },
    {
        path: '/addproducts',
        name: 'AddProducts',
        component: () =>
            import ('../views/AddProducts.vue')
    },

    {
        path: '/products',
        name: 'Products',
        component: () =>
            import ('../views/Products.vue')
    },
    {
        path: '/categories',
        name: 'Categories',
        component: () =>
            import ('../views/Categories.vue')
    },
    {
        //pega o parametro do id que vc quer enviar para a pagina
        path: '/updateproducts/:id',
        name: 'UpdateProducts',
        component: () =>
            import ('../views/UpdateProducts.vue')
    }
]

const router = new VueRouter({
    routes
})

export default router