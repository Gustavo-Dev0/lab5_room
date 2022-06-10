package com.dev0.deliveryfood.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.dev0.deliveryfood.core.presentation.utils.Destinations

@Composable
fun CartFloatingActionButton(
    navController: NavHostController,
    floatingButtonState: MutableState<Boolean>
) {

    AnimatedVisibility(
        visible = floatingButtonState.value,

        ){
        FloatingActionButton(
            onClick = {
                navController.navigate(Destinations.Cart.route)
            },
        ) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
        }
    }

}