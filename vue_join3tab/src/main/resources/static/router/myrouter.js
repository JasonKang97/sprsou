// Vue Router 설정

import AllData from '../components/alldata.js';
import BuserData from '../components/buserdata.js';
import JikwonData from '../components/jikwondata.js';
import GogekData from '../components/gogekdata.js';

const {createApp} = Vue;
const {createRouter, createWebHistory} = VueRouter;

const routes = [
	{ path: '/', component: AllData },
	{ path: '/busers', component: BuserData },
	{ path: '/jikwons', component: JikwonData },
	{ path: '/gogeks', component: GogekData },
];

const router = VueRouter.createRouter({
	history: VueRouter.createWebHistory(),
	routes
});

// Vue 앱 생성
const app = Vue.createApp({});
app.use(router);
app.mount('#app');