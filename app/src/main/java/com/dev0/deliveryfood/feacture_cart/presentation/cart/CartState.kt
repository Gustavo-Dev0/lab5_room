package com.dev0.deliveryfood.feacture_cart.presentation.cart

import com.dev0.deliveryfood.feacture_cart.domain.model.Order

data class CartState(
    var order: Order = Order()
)