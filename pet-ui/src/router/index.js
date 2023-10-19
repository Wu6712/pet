import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index'
  },
  {
    path: '/index',
    name: 'Index',
    component: () => import('@/views/index'),
    redirect: '/adopt',
    children: [
      {
        path: '/log',
        component: () => import('@/views/log/index')
      },
      {
        path: '/my',
        component: () => import('@/views/my/index')
      },
      {
        path: '/adopt',
        component: () => import('@/views/adopt/index')
      },
      {
        path: '/foster',
        component: () => import('@/views/foster/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index')
  },
  {
    path: '/change',
    component: () => import('@/views/changePasswd/index')
  },
  {
    path: '/report',
    component: () => import('@/views/report/index')
  },
  {
    path: '/message',
    component: () => import('@/views/message/index')
  },
  {
    path: '/register',
    component: () => import('@/views/register/index')
  },
  {
    path: '/manage',
    component: () => import('@/views/manage/index')
  },
  {
    path: '/adoptmanage',
    component: () => import('@/views/adoptmanage/index')
  },
  {
    path: '/fostermanage',
    component: () => import('@/views/fostermanage/index')
  },
  {
    path: '/credit',
    component: () => import('@/views/credit/index')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
