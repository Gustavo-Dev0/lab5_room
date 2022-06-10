package com.dev0.deliveryfood.core.presentation.components

import FoodDetailScreen
import HistoryScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dev0.deliveryfood.core.presentation.utils.Destinations
import com.dev0.deliveryfood.feacture_cart.presentation.cart.CartScreen
import com.dev0.deliveryfood.feature_food.presentation.foods.FoodScreen
import com.dev0.deliveryfood.feature_restaurant.presentation.restaurants.RestaurantScreen

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Destinations.Restaurants.route) {
        composable( Destinations.Restaurants.route ) {
            RestaurantScreen(
                navController,
                navToFoods = { restaurantId ->
                    navController.navigate(Destinations.Foods.createRoute(restaurantId))
                }
            )
        }
        composable( Destinations.Foods.route,
            arguments = listOf(navArgument("restaurantId") { defaultValue = "0" })
            ) { backStackEntry ->
            val res = backStackEntry.arguments?.getString("restaurantId")
            requireNotNull(res)
            FoodScreen(navController, res.toInt())
        }
        composable(
            Destinations.FoodDetail.route,
            arguments = listOf(navArgument("foodId"){
            type = NavType.IntType
        })) {
            FoodDetailScreen( navController, it.arguments?.getInt("foodId") )
        }
        composable( Destinations.History.route ) {
            HistoryScreen( title = "Historial de pedidos" )
        }
        composable( Destinations.Cart.route ) {
            CartScreen( navController, title = "Aqui se paga" )
        }
    }
}