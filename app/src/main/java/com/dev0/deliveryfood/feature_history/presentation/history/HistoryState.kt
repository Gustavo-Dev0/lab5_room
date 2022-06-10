package com.dev0.deliveryfood.feature_history.presentation.history

import com.dev0.deliveryfood.feacture_cart.domain.model.Order

data class HistoryState(
    var historyList: ArrayList<Order> = ArrayList()
)