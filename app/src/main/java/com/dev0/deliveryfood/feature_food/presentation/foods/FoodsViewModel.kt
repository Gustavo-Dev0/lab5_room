package com.dev0.deliveryfood.feature_food.presentation.foods

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.feature_food.data.repository.FoodRepositoryImpl
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository
import com.dev0.deliveryfood.feature_food.presentation.foods.FoodsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodsViewModel(
    private val repository: FoodRepository = FoodRepositoryImpl(AppDb.dbRoom.foodDao)
): ViewModel() {

    private val _state = mutableStateOf(FoodsState())
    val state: State<FoodsState> = _state

    val getFoods: LiveData<List<Food>> = repository.getAll()

    companion object {
        var idFilterRestaurant: Int = 0
    }


    fun getFoodsByRestaurantId(idR: Int): LiveData<List<Food>>{
        return repository.getAllByRestaurantId(idR)
    }

    fun saveFood(food: Food){
        viewModelScope.launch {
            repository.insert(food)
        }
    }
    fun deleteFood(food: Food) {
        viewModelScope.launch {
            repository.delete(food)
        }
    }

}