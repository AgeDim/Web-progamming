import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: "history",
    routes: [
        {
            path: '/',
            alias: '/auth',
            name: 'auth',
            component: () => import('./components/Auth')
        },
        {
            path: '/main',
            name: 'main',
            component: () => import('./components/Main')
        }
    ]
})