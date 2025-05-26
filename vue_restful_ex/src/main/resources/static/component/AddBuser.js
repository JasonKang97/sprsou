export default{
	template:`
		<div>
			<h2>부서 추가</h2>		
			<form @submit.prevent="addBuser">
				부서번호: <input type="number" v-model="buser.buserno" required><br>
				부서명: <input type="text" v-model="buser.busername" required><br>
				지역: <input type="text" v-model="buser.buserloc" required><br>
				전화: <input type="text" v-model="buser.busertel" required><br>
				<button type="submit">추가 확인</button>
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
		addBuser(){
			axios.post(`/busers`, this.buser)
			.then(() => {
				alert('부서 추가 성공')
				this.$router.push('/');
			})
			.catch(error => {
				console.log('추가 오류: ' + error)
			})
		}
	}
}