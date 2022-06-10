package com.dev0.deliveryfood.feature_restaurant.presentation.restaurants

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dev0.deliveryfood.feature_food.presentation.foods.components.ShowDialogForm
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant
import com.dev0.deliveryfood.feature_restaurant.presentation.restaurants.components.ItemRestaurant
import com.dev0.deliveryfood.feature_restaurant.presentation.restaurants.components.ShowDialogRestaurantForm


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantScreen(
    navController: NavHostController,
    navToFoods: (Int?) -> Unit,
    viewModel: RestaurantsViewModel = RestaurantsViewModel()
) {
    val restaurants = viewModel.getRestaurants.observeAsState(listOf()).value
    val isDialogOpen = remember { mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TextField(
            value = "Buscar restaurantes",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Filled.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {

            },
            singleLine = true,
            shape = RectangleShape,
            //colors = TextFieldDefaults.textFieldColors()
        )
        /*Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Restaurantes",
            style = TextStyle(color = Color.Black, fontSize = 36.sp, fontWeight = FontWeight.Black)
        )*/
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))

        Row() {

            ShowDialogRestaurantForm(isDialogOpen,save =  viewModel::saveRestaurant, navController = navController)


            Button(
                onClick = {
                    isDialogOpen.value = true
                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Añadir Restaurante"
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(
                top = 12.dp,
                bottom = 100.dp
            ),

        ) {

            items(restaurants.size) { index ->
                ItemRestaurant(
                    item = restaurants[index],
                    viewModel::deleteRestaurant,
                    viewModel::saveRestaurant,
                    navController
                ){
                    Log.e("ID", ""+restaurants[index].id!!)
                    navToFoods(restaurants[index].id)
                }
            }
        }

    }
}
