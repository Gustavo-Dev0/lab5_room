package com.dev0.deliveryfood.feature_restaurant.presentation.restaurants

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.feature_food.data.repository.FoodRepositoryImpl
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository
import com.dev0.deliveryfood.feature_food.presentation.foods.FoodsState
import com.dev0.deliveryfood.feature_restaurant.data.repository.RestaurantRepositoryImpl
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant
import com.dev0.deliveryfood.feature_restaurant.domain.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantsViewModel(
    private val repository: RestaurantRepository = RestaurantRepositoryImpl(AppDb.dbRoom.restaurantDao)
): ViewModel() {

    //private val _state = mutableStateOf(RestaurantsState())
    //val state: State<RestaurantsState> = _state
    val getRestaurants: LiveData<List<Restaurant>> = repository.getAll()

    fun deleteRestaurant(restaurant: Restaurant){
        viewModelScope.launch {
            repository.delete(restaurant)
        }
    }

    fun saveRestaurant(restaurant: Restaurant){
        viewModelScope.launch {
            repository.insert(restaurant)
        }
    }
}