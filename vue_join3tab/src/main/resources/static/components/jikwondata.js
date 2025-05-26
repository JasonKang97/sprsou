export default {
	template: `
	    <div>
	        <h3>전체자료</h3>
	        <table v-if='jikwonData.length'>
	            <thead>
	                <tr>
	                    <th>직원번호</th><th>직원명</th><th>직급</th><th>연봉</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr v-for='data in jikwonData' :key='data.jikwonno'>
	                    <td>{{data.jikwonno}}</td>
	                    <td>{{data.jikwonname}}</td>
	                    <td>{{data.jikwonjik}}</td>
	                    <td>{{data.jikwonpay}}</td>
	                </tr>
	            </tbody>
	        </table>
	        <p v-else>데이터가 없습니다.</p>
	    </div>`,
	data() {
		return {
			jikwonData: [],
		}
	},
	mounted() {
		axios.get('http://localhost/jikwons')
			.then(response => {
				this.jikwonData = response.data;
			})
			.catch(error => {
				console.log('error fetch jikwon data:' + error)
			})
	}
}