package com.dev0.deliveryfood.feature_restaurant.domain.repository

import androidx.lifecycle.LiveData
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

interface RestaurantRepository {
    suspend fun getById(id: Int): Restaurant
    fun getAll(): LiveData<List<Restaurant>>
    suspend fun insert(restaurant: Restaurant)
    suspend fun delete(restaurant: Restaurant)
}