package com.dev0.deliveryfood.feature_food.data.repository

import androidx.lifecycle.LiveData
import com.dev0.deliveryfood.feature_food.data.data_source.FoodDao
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository

class FoodRepositoryImpl(
    private  val dao: FoodDao
): FoodRepository{
    override fun getById(id: Int): LiveData<Food> {
        return dao.getFoodById(id)
    }

    override fun getAll(): LiveData<List<Food>> = dao.getFoods()

    override suspend fun insert(food: Food) {
        dao.insertFood(food)
    }

    override suspend fun delete(food: Food) {
        dao.deleteFood(food)
    }

    override fun getAllByRestaurantId(id: Int): LiveData<List<Food>> {
        return dao.getFoodsByRestaurantId(id)
    }
}