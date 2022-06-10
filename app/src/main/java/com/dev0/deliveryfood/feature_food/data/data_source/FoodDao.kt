package com.dev0.deliveryfood.feature_food.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dev0.deliveryfood.feature_food.domain.model.Food

@Dao
interface FoodDao {
    @Query("SELECT * from Food")
    fun getFoods(): LiveData<List<Food>>

    @Query("SELECT * from Food WHERE restaurant = :id")
    fun getFoodsByRestaurantId(id: Int): LiveData<List<Food>>

    @Query("SELECT * from Food WHERE id = :id")
    fun getFoodById(id: Int): LiveData<Food>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)
}