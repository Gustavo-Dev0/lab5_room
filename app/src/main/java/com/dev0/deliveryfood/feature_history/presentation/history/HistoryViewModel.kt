package com.dev0.deliveryfood.feature_history.presentation.history

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.dev0.deliveryfood.feacture_cart.domain.model.Order
import com.dev0.deliveryfood.feacture_cart.domain.repository.OrderRepository
import com.dev0.deliveryfood.feacture_cart.presentation.cart.CartState
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

class HistoryViewModel {

    private val repository = OrderRepository()
    private val _state = mutableStateOf(HistoryState())
    val state: State<HistoryState> = _state

    init {
        getHistory()
    }


    private fun getHistory() {

        var history: ArrayList<Order> = repository.getAll()

        /*val fo = Restaurant(
            id = 1,
            name = "Zig Zag R",
            description = "Salud y seguridad: Se requiere el uso de mascarilla · Se requiere una revisión de temperatura · El personal usa mascarillas · El personal se somete a revisiones de temperatura · Desinfección de superficies obligatoria por parte del personal después de cada visita",
            qualification = "1.5",
            image = "https://lh5.googleusercontent.com/p/AF1QipPR94bXCyckfJ0w3McZFfO9bthp04g-etcJJe2Q=w72-h72-n-k-no",
            district = "Arequipa - Cercado"
        )*/
        /*var order = Order(
            total = 100.0
        )
        history.add(order)*/

        _state.value = state.value.copy(
            historyList = history
        )
    }
}