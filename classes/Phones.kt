package classes

class Phones(
    name: String,
    price: String,
    vendorCode: String,
    availability: String,
    private val manDate: String,
    private val cameraFeatures: String,
    private val processorFeatures: String,
    private val displayFeatures: String
): Product(name, price, vendorCode, availability) {

    override fun productInfo() {
        super.productInfo()
        println("Дата производства: $manDate\n" +
                "Характеристики камеры: $cameraFeatures\n" +
                "Характеристики процессора: $processorFeatures\n" +
                "Характеристики дисплея: $displayFeatures")
    }

}