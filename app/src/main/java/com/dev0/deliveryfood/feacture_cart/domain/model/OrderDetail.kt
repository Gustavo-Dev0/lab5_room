package com.dev0.deliveryfood.feacture_cart.domain.model

import com.dev0.deliveryfood.feature_food.domain.model.Food

data class OrderDetail(
    var id: Int,
    var ordered: Int,
    var restaurant: Int,
    var restaurantName: String,
    var food: Food,
    var quantity: Int,
    var total: Double
)