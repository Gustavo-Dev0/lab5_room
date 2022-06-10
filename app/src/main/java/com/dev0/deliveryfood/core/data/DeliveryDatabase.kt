package com.dev0.deliveryfood.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev0.deliveryfood.feature_food.data.data_source.FoodDao
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_restaurant.data.data_source.RestaurantDao
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

@Database(
    entities = [Food::class, Restaurant::class],
    version = 1
)
abstract class DeliveryDatabase : RoomDatabase() {
    abstract val foodDao: FoodDao
    abstract val restaurantDao: RestaurantDao
}