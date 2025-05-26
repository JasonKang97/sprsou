export default{
	template:`
		<div>
			<h2>부서 정보</h2>
			<table>
				<thead>
					<tr>
						<th>부서번호</th><th>부서명</th><th>지역</th><th>전화</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="buser in busers" :key="buser.buserno">
						<td>{{buser.buserno}}</td>
						<td>{{buser.busername}}</td>
						<td>{{buser.buserloc}}</td>
						<td>{{buser.busertel}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	`,
	data(){
		return{
			busers:[]
		}
	},
	methods:{
		fetchProducts(){
			axios.get('/busers')
			.then(response => {
				this.busers = response.data;
			})
			.catch(error => {
				console.log('읽기 오류: ' + error)
			})
		}
	},
	created(){
		this.fetchProducts();
	}
}