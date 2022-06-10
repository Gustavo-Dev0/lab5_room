package com.dev0.deliveryfood.feature_restaurant.data.repository

import androidx.lifecycle.LiveData
import com.dev0.deliveryfood.feature_restaurant.data.data_source.RestaurantDao
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant
import com.dev0.deliveryfood.feature_restaurant.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl(
    val dao: RestaurantDao
): RestaurantRepository {
    override suspend fun getById(id: Int): Restaurant {
        return dao.getRestaurantById(id)
    }

    override fun getAll(): LiveData<List<Restaurant>> {
        return dao.getRestaurants()
    }

    override suspend fun insert(restaurant: Restaurant) {
        dao.insertRestaurant(restaurant)
    }

    override suspend fun delete(restaurant: Restaurant) {
        dao.deleteRestaurant(restaurant)
    }
}