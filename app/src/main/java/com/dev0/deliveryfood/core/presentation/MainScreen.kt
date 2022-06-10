package com.dev0.deliveryfood.core.presentation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.rememberNavController
import com.dev0.deliveryfood.core.presentation.components.BottomNavigationBar
import com.dev0.deliveryfood.core.presentation.components.CartFloatingActionButton
import com.dev0.deliveryfood.core.presentation.components.NavigationHost
import com.dev0.deliveryfood.core.presentation.utils.Destinations.*
import currentRoute

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

    val navigateItems = listOf(
        Restaurants,
        Foods,
        History,
    )

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val floatingButtonState = rememberSaveable { (mutableStateOf(true)) }

    when (currentRoute(navController = navController)) {
        Restaurants.route -> bottomBarState.value = true
        Foods.route -> bottomBarState.value = true
        History.route -> bottomBarState.value = true


        Cart.route -> {
            bottomBarState.value = false
        }
        else -> {
            bottomBarState.value = false
        }

    }

    /*if(currentRoute(navController = navController).toString().contains()){

    }*/



    when (currentRoute(navController = navController)) {
        Cart.route -> {
            floatingButtonState.value = false
        }
        else -> {
            floatingButtonState.value = true
        }

    }


    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavigationBar(navController = navController, items = navigateItems, bottomBarState = bottomBarState) },
        floatingActionButton = {
            if (currentRoute(navController = navController) != Cart.route) {
                CartFloatingActionButton(navController = navController, floatingButtonState = floatingButtonState)
            }
        }
    ) {
        NavigationHost(navController)
    }

}
