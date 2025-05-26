export default {
	template: `
	    <div>
	        <h3>전체자료</h3>
	        <table v-if='buserData.length'>
	            <thead>
	                <tr>
	                    <th>부서번호</th><th>부서명</th><th>위치</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr v-for='data in buserData' :key='data.buserno'>
	                    <td>{{data.buserno}}</td>
	                    <td>{{data.busername}}</td>
	                    <td>{{data.buserloc}}</td>
	                </tr>
	            </tbody>
	        </table>
	        <p v-else>데이터가 없습니다.</p>
	    </div>`,
	data() {
		return {
			buserData: [],
		}
	},
	mounted() {
		axios.get('http://localhost/busers')
			.then(response => {
				this.buserData = response.data;
			})
			.catch(error => {
				console.log('error fetch buser data:' + error)
			})
	}
}