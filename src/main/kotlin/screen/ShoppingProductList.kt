package screen

import data.Product

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션",  "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "간식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식")
    )

    private val categories: Map<String, List<Product>> = products.groupBy {product ->
        product.categoryLable
    }
    fun showProducts(selectedCategory: String){
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println("""
                ***======================***
                선택하신 [$selectedCategory] 카테고리로 이동합니다.
            """.trimIndent())
            val productSize = categoryProducts.size
            for (index in 0 until  productSize) {
                println("${index}. ${categoryProducts[index].name}")
            }
        } else {
           showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String){
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전 입니다.")
    }

// 파라미터 : 함수가 먹는 입
// 아큐먼트 : 함수가 먹는 값


}