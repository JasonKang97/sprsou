export default{
	template:`
		<div>
			<h2>직원 정보</h2>
			<table border="1">
				<thead>
					<tr>
						<th>사번</th><th>직원명</th><th>직급</th><th>부서</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="jikwon in jikwons" :key="jikwon.jikwonno">
						<td>{{jikwon.jikwonno}}</td>
						<td>{{jikwon.jikwonname}}</td>
						<td>{{jikwon.jikwonjik}}</td>
						<td>{{jikwon.busername}}</td>
					</tr>
					<tr>
						<td colspan="4">부서명별 인원수</td>
					</tr>
					<tr>
						<td colspan="4">총무부: {{count1}}</td>
					</tr>
					<tr>
						<td colspan="4">영업부: {{count2}}</td>
					</tr>
					<tr>
						<td colspan="4">전산부: {{count3}}</td>
					</tr>
					<tr>
						<td colspan="4">관리부: {{count4}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	`,
	data(){
		return{
			jikwons:[],
			count1:0,
			count2:0,
			count3:0,
			count4:0,
		}
	},
	methods:{
		fetchProducts(){
			axios.get('/jikwons')
			.then(response => {
				this.jikwons = response.data;
				
				this.count1 = 0;
				this.count2 = 0;
				this.count3 = 0;
				this.count4 = 0;
				
				for (let jikwon of response.data) {
					switch (jikwon.busername) {
						case '총무부':
							this.count1++;
							break;
						case '영업부':
							this.count2++;
							break;
						case '전산부':
							this.count3++;
							break;
						case '관리부':
							this.count4++;
							break;
					}
				}
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