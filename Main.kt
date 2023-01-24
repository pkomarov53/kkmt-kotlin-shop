import classes.*

fun inputHelper(productType: String) {
    when (productType)
    {
        "одежда" -> println("Введите через ENTER: " +
                            "название, " +
                            "цена, " +
                            "артикул, " +
                            "наличие в магазине, " +
                            "размер, " +
                            "для какого пола " +
                            "и возможна ли примерка перед оплатой.")

        "еда" -> println("Введите через ENTER: " +
                         "название, " +
                         "цена, " +
                         "артикул, " +
                         "наличие в магазине, " +
                         "срок годности, " +
                         "кол-во калорий " +
                         "и списко ингридиентов.")

        "телефон" -> println("Введите через ENTER: " +
                             "название, " +
                             "цена, " +
                             "артикул, " +
                             "наличие в магазине, " +
                             "дату производства, " +
                             "хар-ки камеры, " +
                             "хар-ки процессора " +
                             "и хар-ки дисплея телефона")
    }

}

fun main() {
    val productList: MutableList <Product> = mutableListOf()

    println("Меню программы:\n" +
            "1 -> Добавить товар в общий список\n" +
            "2 -> Удалить товар из общего списка\n" +
            "3 -> Просмотреть список товаров\n" +
            "4 -> Вывести информацию о конкретном товаре\n" +
            "5 -> Завершить работу программы")

    while (true) {
        print("Введите действие ->  ")
        when(readln().toInt()) {
            1 -> {
                println("Товар какой категории вы хотите добавить: \n" +
                        "Одежда, еда или телефон")

                when (val userInput = readln().lowercase()) {
                    "одежда" -> {
                        inputHelper(userInput)
                        productList.add(Clothes(readln(), readln(),
                            readln(), readln(),
                            readln(), readln(),
                            readln()))
                        println("Товар успешно добавлен в базу данных")
                    }

                    "еда" -> {
                        inputHelper(userInput)
                        productList.add(Food(readln(), readln(),
                            readln(), readln(),
                            readln(), readln(),
                            readln()))
                        println("Товар успешно добавлен в базу данных")
                    }

                    "телефон" -> {
                        inputHelper(userInput)
                        productList.add(Phones(readln(), readln(), readln(),
                            readln(), readln(), readln(),
                            readln(), readln()))
                        println("Товар успешно добавлен в базу данных")
                    }

                    else -> {
                        println("Такой категории нет.")
                        continue
                    }
                }
            }

            2 -> {
                    print("Введите артикул товара -> ")
                    val iterator = productList.iterator()
                    while (iterator.hasNext()) {
                        val item = iterator.next()
                        if (item.vendorCode == readlnOrNull().toString()) iterator.remove()
                        else {
                            println("Такого товара нет")
                        }
                    }
            }

            3 -> {
               if (productList.isNotEmpty()) {
                   println(productList)

               } else {
                   println("В списке отсутствуют товары!")
                   continue
               }
            }

            4 -> {
                print("\nВведите артикул товара -> ")
                for (item in productList)
                    if (item.vendorCode == readln()) {
                        println(item.productInfo())
                        break
                    } else {
                        println("Такого товара нет")
                        break
                    }
            }

            5 -> break
        }
    }
}