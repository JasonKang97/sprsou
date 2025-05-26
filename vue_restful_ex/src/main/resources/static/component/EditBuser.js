export default{
	template:`
		<div>
			<h2>부서 수정</h2>		
			부서번호: <input type="number" v-model="buser.buserno" required><button @click="fetchBuser">확인</button>
			<hr>
			<form @submit.prevent="updateBuser">
				부서명: <input type="text" v-model="buser.busername" required><br>
				지역: <input type="text" v-model="buser.buserloc" required><br>
				전화: <input type="text" v-model="buser.busertel" required><br>
				<button type="submit">수정 확인</button>
			</form>
		</div>
	`,
	data(){
		return{
			buser:{
				buserno:null,
				busername:'',
				buserloc:'',
				busertel:'',
			}
		}
	},
	methods:{
		fetchBuser(){
			axios.get(`/busers/${this.buser.buserno}`)
			.then(response => {
				this.buser = response.data;
			})
			.catch(error => {
				alert("존재하지 않는 부서번호입니다.")
				console.log('1개 읽기 오류: ' + error)
			})
		},updateBuser(){
			axios.put(`/busers/${this.buser.buserno}`, this.buser)
			.then(() => {
				alert('부서 수정 성공')
				this.$router.push('/');
			})
			.catch(error => {
				alert("부서번호를 확인해 주세요")
				console.log('수정 오류: ' + error)
			})
		}
	}
}