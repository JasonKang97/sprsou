export default{
	template:`
		<div>
			<h2>제품 추가</h2>		
			<form @submit.prevent="addProduct">
				코드: <input type="text" v-model="product.code" required><br>
				이름: <input type="text" v-model="product.name" required><br>
				설명: <input type="text" v-model="product.description" required><br>
				가격: <input type="number" v-model="product.price" required><br>
				<button type="submit">추가 확인</button>
			</form>
		</div>
	`,
	data(){
		return{
			product:{
				code:'',
				name:'',
				description:'',
				price:null,
			}
		}
	},
	methods:{
		addProduct(){
			axios.post(`/products`, this.product)
			.then(() => {
				alert('상품 추가 성공')
				this.$router.push('/');
			})
			.catch(error => {
				console.log('추가 오류: ' + error)
			})
		}
	}
}