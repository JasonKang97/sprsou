export default{
	template:`
		<div>
			<h2>제품 수정</h2>		
			<form @submit.prevent="updateProduct">
				코드: <input type="text" v-model="product.code" disabled><br>
				이름: <input type="text" v-model="product.name" required><br>
				설명: <input type="text" v-model="product.description" required><br>
				가격: <input type="number" v-model="product.price" required><br>
				<button type="submit">수정 확인</button>
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
		fetchProduct(){
			axios.get(`/products/${this.$route.params.code}`)
			.then(response => {
				this.product = response.data;
			})
			.catch(error => {
				console.log('1개 읽기 오류: ' + error)
			})
		},updateProduct(){
			axios.put(`/products/${this.product.code}`, this.product)
			.then(() => {
				alert('상품 수정 성공')
				this.$router.push('/');
			})
			.catch(error => {
				console.log('1개 읽기 오류: ' + error)
			})
		}
	},
	created(){
		this.fetchProduct();
	}
}