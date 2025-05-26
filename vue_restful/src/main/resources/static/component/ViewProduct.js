export default{
	template:`
		<div>
			<h2>제품 정보</h2>
			<table>
				<thead>
					<tr>
						<th>코드</th><th>제품명</th><th>설명</th><th>가격</th><th>이미지</th><th>관리</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="product in products" :key="product.code">
					<td>{{product.code}}</td>
					<td>{{product.name}}</td>
					<td>{{product.description}}</td>
					<td>{{product.price}}</td>
					<td>
						<img :src="product.image" alt="product image" style="width:100px">
					</td>
					<td><button @click="editProduct(product.code)">수정</button> / <button @click="deleteProduct(product.code)">삭제</button></td>
					</tr>
				</tbody>
			</table>
		</div>
	`,
	data(){
		return{
			products:[]
		}
	},
	methods:{
		fetchProducts(){
			axios.get('/products')
			.then(response => {
				this.products = response.data;
			})
			.catch(error => {
				console.log('읽기 오류: ' + error)
			})
		},
		editProduct(code){
			this.$router.push(`/edit/${code}`)
		},
		deleteProduct(code){
			if(confirm("정말 삭제하시겠습까?")){
				axios.delete(`/products/${code}`)
				.then(() => {
					this.fetchProducts();		// 삭제 후 목록 보기
				})
				.catch(error => {
					console.log('삭제 오류: ' + error)
				})			
			}
		}
	},
	created(){
		this.fetchProducts();
	}
}