package classes

class Clothes(
    name: String,
    price: String,
    vendorCode: String,
    availability: String,
    private val size: String,
    private val gender: String,
    private val fittingBeforeCheckout: String
): Product(name, price, vendorCode, availability) {

    override fun productInfo() {
        super.productInfo()
        println("Размер одежды: $size\n" +
                "Одежда для: $gender\n" +
                "Возможна ли проверка до оплаты: $fittingBeforeCheckout")
    }
}