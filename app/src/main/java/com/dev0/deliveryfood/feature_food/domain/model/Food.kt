package com.dev0.deliveryfood.feature_food.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food (
    var name: String = "",
    var description: String = "",
    var restaurant : Int = 0,
    var restaurantName : String = "",
    var qualification : String = "",
    var image : String = "",
    var price : Double = 0.0,
    @PrimaryKey val id: Int? = null
)