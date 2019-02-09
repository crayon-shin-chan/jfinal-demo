import 'element-ui/lib/theme-chalk/index.css'
import ElementUI from 'element-ui'
import axios from 'axios'
import Vue from 'vue'
import 'vue-axios'

import App from './component/app.vue'
import router from './router'

Vue.use(ElementUI)

Vue.prototype.$http = axios
axios.defaults.baseURL = "http://localhost"

/**入口ts文件，构造Vue实例 */
new Vue({
    el: '#app',
    router,
    render: h => h(App)
 })