import axios from 'axios'
import qs from 'qs'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
// 创建axios实例

const service = axios.create({
  baseURL: process.env.BASE_API, // api 的 base_url
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
  },
  timeout: 50000 // 请求超时时间
})

// request请求前拦截器
service.interceptors.request.use(
  config => {
    config.data = qs.stringify(config.data)
    NProgress.start()
    return config
  },
  error => {
    console.log(error)
    Promise.reject(error)
  }
)

// response 请求后拦截器
service.interceptors.response.use(
  response => {
    NProgress.done()
    return response.data
  },
  error => {
    console.log('err' + error)
    return Promise.reject(error)
  }
)

export default service
