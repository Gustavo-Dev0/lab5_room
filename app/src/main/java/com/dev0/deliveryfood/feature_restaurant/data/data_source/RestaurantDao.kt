package com.dev0.deliveryfood.feature_restaurant.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

@Dao
interface RestaurantDao {
    @Query("SELECT * from Restaurant")
    fun getRestaurants(): LiveData<List<Restaurant>>

    @Query("SELECT * from Restaurant WHERE id = :id")
    suspend fun getRestaurantById(id: Int): Restaurant

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: Restaurant)

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)
}