import Vue from 'vue'
import App from './App.vue'
import router from './router.js'
import 'semantic-ui-css/semantic.css';
import 'semantic-ui-css/semantic.js';

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
