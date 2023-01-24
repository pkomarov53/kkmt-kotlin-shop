package classes

open class Product(
    private val name: String,
    private val price: String,
    val vendorCode: String,
    private val availability: String
) {

    private var rate: Int = 0

    override fun toString(): String {
       return "$name, $vendorCode"
    }

    open fun productInfo() = println("Название товара: $name\n" +
            "Цена товара: $price\n" +
            "Артикул товара: $vendorCode\n" +
            "Наличие на складе: $availability")

    fun productRate(userRating: Int) {
        rate = userRating
    }
}