export default {
	template: `
        <div>
            <h3>전체자료</h3>
            <table v-if='allData.length'>
                <thead>
                    <tr>
                        <th>부서번호</th><th>부서명</th><th>직원명</th><th>고객명</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for='data in allData' :key='data.jikwonno'>
                        <td>{{data.buserno}}</td>
                        <td>{{data.busername}}</td>
                        <td>{{data.jikwonname}}</td>
                        <td>{{data.gogekname}}</td>
                    </tr>
                </tbody>
            </table>
            <p v-else>데이터가 없습니다.</p>
        </div>`,
	data() {
		return {
			allData: [],
		}
	},
	mounted() {
		axios.get('http://localhost/joindata')
			.then(response => {
				this.allData = response.data;
			})
			.catch(error => {
				console.log('error fetch data:' + error)
			})
	}
}