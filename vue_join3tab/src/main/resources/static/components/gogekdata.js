export default {
	template: `
        <div>
            <h3>전체자료</h3>
            <table v-if='gogekData.length'>
                <thead>
                    <tr>
                        <th>고객번호</th><th>고객명</th><th>고객전화</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for='data in gogekData' :key='data.gogekno'>
                        <td>{{data.gogekno}}</td>
                        <td>{{data.gogekname}}</td>
                        <td>{{data.gogektel}}</td>
                    </tr>
                </tbody>
            </table>
            <p v-else>데이터가 없습니다.</p>
        </div>`,
	data() {
		return {
			gogekData: [],
		}
	},
	mounted() {
		axios.get('http://localhost/gogeks')
			.then(response => {
				this.gogekData = response.data;
			})
			.catch(error => {
				console.log('error fetch gogek data:' + error)
			})
	}
}