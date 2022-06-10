package com.dev0.deliveryfood.feacture_cart.domain.model

data class Order (
    val id: Int = 0,
    val date: String = "Hoy",
    val user : Int = 1,
    val userName : String = "Pablo",
    val status : Int = 0,
    var total : Double = 0.0,
    var foods: ArrayList<OrderDetail> = ArrayList()
)