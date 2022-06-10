package com.dev0.deliveryfood.feacture_cart.presentation.cart

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.dev0.deliveryfood.feacture_cart.domain.model.Order
import com.dev0.deliveryfood.feacture_cart.domain.model.OrderDetail
import com.dev0.deliveryfood.feacture_cart.domain.repository.OrderRepository
import com.dev0.deliveryfood.feature_food.domain.model.Food

class CartViewModel {
    private val repository = OrderRepository()
    private val _state = mutableStateOf(CartState())
    val state: State<CartState> = _state

    init {
        getOrder()
    }

    companion object {
        var actualOrder: Order = Order()
    }

    fun updateOrder(orderModified: Order){
        actualOrder = orderModified.copy()
    }

    fun getOrder() {

        _state.value = state.value.copy(
            order = actualOrder
        )
    }

    fun makeOrder() {
        repository.add(actualOrder)
        actualOrder.foods.clear()
        actualOrder.total = 0.0
    }

}