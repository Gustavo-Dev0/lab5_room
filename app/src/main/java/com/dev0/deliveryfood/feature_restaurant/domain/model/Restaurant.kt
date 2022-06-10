package com.dev0.deliveryfood.feature_restaurant.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant (
    var name: String = "",
    var description: String = "",
    var district : String = "",
    var image : String = "",
    var qualification : String = "",
    @PrimaryKey val id: Int? = null
)