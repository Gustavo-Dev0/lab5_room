package com.dev0.deliveryfood.feature_food.domain.repository

import androidx.lifecycle.LiveData
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

interface FoodRepository {
    fun getById(id: Int): LiveData<Food>
    //suspend fun getRestaurantById(id: Int): Restaurant
    fun getAll(): LiveData<List<Food>>
    suspend fun insert(food: Food)
    suspend fun delete(food: Food)
    fun getAllByRestaurantId(idR: Int): LiveData<List<Food>>
}