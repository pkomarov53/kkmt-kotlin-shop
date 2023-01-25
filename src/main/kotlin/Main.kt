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
    println("Меню программы:\n" +
            "1 -> Добавить товар в общий список\n" +
            "2 -> Удалить товар из общего списка\n" +
            "3 -> Просмотреть список товаров\n" +
            "4 -> Вывести информацию о конкретном товаре\n" +
            "5 -> Завершить работу программы")
    val a = Clothes("Штаны Найк",
        "15000 рублей",
        "345341",
        "В наличии",
        "М",
        "Для мужчин",
        "Возможна")

    val b = Clothes("Худи Адидас",
        "9500 рублей",
        "783241",
        "Нет в наличии",
        "XL",
        "Для женщин",
        "Невозможна")

    val productList: MutableList <Product> = mutableListOf(a, b)

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
                println("Требуется номер товара: ")
                try {
                    print("Введите номер товара -> ")
                    val number = readln().toInt()
                    productList.removeAt(number - 1)
                }
                catch(ex: Exception) {
                    println("Введите правильный номер")
                }
            }

            3 -> {
               if (productList.isNotEmpty()) {
                   var number: Int = 0
                   productList.forEach {
                       number++
                       println("\t$number. Название - ${it.name} " +
                               "Артикул - ${it.vendorCode} " +
                               "Цена - ${it.price} ")
                   }

               } else {
                   println("В списке отсутствуют товары!")
                   continue
               }
            }

            4 -> {
                try {
                    print("Введите номер товара -> ")
                    val number = readln().toInt()
                    productList[number - 1].productInfo()
                }
                catch(ex: Exception) {
                    println("Введите правильный номер")
                }
            }

            5 -> break
        }
    }
}