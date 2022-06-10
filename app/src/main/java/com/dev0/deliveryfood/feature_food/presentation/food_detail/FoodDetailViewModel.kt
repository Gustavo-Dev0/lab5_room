package com.dev0.deliveryfood.feature_food.presentation.food_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.feacture_cart.domain.model.OrderDetail
import com.dev0.deliveryfood.feacture_cart.presentation.cart.CartViewModel
import com.dev0.deliveryfood.feature_food.data.repository.FoodRepositoryImpl
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.domain.repository.FoodRepository
import com.dev0.deliveryfood.feature_food.presentation.foods.FoodsState
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant
import kotlinx.coroutines.launch

class FoodDetailViewModel(
    private val repository: FoodRepository = FoodRepositoryImpl(AppDb.dbRoom.foodDao)
): ViewModel() {
    private val _state = mutableStateOf(FoodDetailState())
    val state: State<FoodDetailState> = _state


    fun getFoodById(id: Int): LiveData<Food> {
        return repository.getById(id)
    }

    fun deleteFood(id: Int) {
        Log.e("SE llamo", "Eliminado")
    }

    fun editFood(id: Int) {
        Log.e("SE llamo", "Editando")
    }

    fun addToOrder(cant: Int) {
        Log.e("SE llamo", "Si")
        var newOrderDetail = OrderDetail(
            quantity = cant,
            total = cant*state.value.food.price,
            food = state.value.food,
            ordered = 0/*state.value.food.id*/,
            restaurantName = state.value.restaurant,
            restaurant = state.value.food.restaurant,
            id = 1
        )

        CartViewModel.actualOrder.total+=(cant*state.value.food.price)
        CartViewModel.actualOrder.foods.add(newOrderDetail)
    }
}