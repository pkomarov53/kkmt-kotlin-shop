package classes

class Food(
    name: String,
    price: String,
    vendorCode: String,
    availability: String,
    private val expDate: String,
    private val calories: String,
    private val ingList: String
): Product(name, price, vendorCode, availability) {

    override fun productInfo() {
        super.productInfo()
        println("Срок годности: до $expDate\n" +
                "Калории: $calories ккал\n" +
                "Список ингридиентов: $ingList")
        }
}