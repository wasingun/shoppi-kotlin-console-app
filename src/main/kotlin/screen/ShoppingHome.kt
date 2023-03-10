package screen

class ShoppingHome {
    fun start() {
        showWelcomeMessage()
        showCategories2()
    }

    private fun showWelcomeMessage() {
        println("안녕하세요. shoppi에 오신것을 환영합니다!")
        println("쇼핑을 계속 하시려면 이름을 입력해주세요:")

        val name = readLine()
        println(
            """
            감사합니다. 반갑습니다 $name 님
             원하시는 카테고리를 입력해주세요.
        """.trimIndent()
        )
    }
    private fun showCategories2() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }
}

