import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('@/view/home/index'),
      children:[
        {
          path: '/user/index',
          name: 'User',
          component: () => import('@/view/user/index'),
        },
        {
          path: '/new/rel/index',
          name: 'newrel',
          component: () => import('../view/new/rel/index'),
        },
        {
          path: '/new/rel/articeldetails',
          name: 'articeldetails',
          component: () => import('../view/new/rel/articeldetails'),
        },
        {
          path: '/leave/index',
          name: 'leave',
          component: () => import('../view/leave/index'),
        },
        {
          path: '/album/index',
          name: 'album',
          component: () => import('../view/album/index'),
        },
        {
          path: '/Article/category/view',
          name: 'Article',
          component: () => import('../view/Article/category/view'),
        },
        {
          path: '/Article/category/about',
          name: 'category',
          component: () => import('../view/Article/category/about'),
        }
      ]
    },
    {
      path: '/login/login_in',
      name: 'login',
      component: () => import('../view/login/login_in'),
    },
    {
      path: '/login/registered',
      name: 'registered',
      component: () => import('../view/login/registered'),
    }
  ]
})
