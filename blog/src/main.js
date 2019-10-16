// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import '../static/css/reset.css'
import echarts from 'echarts'
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
import axios from 'axios'
Vue.prototype.$axios = axios
import ElementUI from 'element-ui'
import moment from 'moment'//导入文件 

import LightTimeline from 'vue-light-timeline';
 
Vue.use(LightTimeline)
Vue.prototype.$moment = moment;//赋值使用
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
