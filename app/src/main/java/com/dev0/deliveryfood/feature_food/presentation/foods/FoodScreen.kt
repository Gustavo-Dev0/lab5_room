package com.dev0.deliveryfood.feature_food.presentation.foods

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dev0.deliveryfood.core.presentation.utils.Destinations
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.presentation.foods.components.ItemFood
import com.dev0.deliveryfood.feature_food.presentation.foods.components.ShowDialogForm


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun FoodScreen(
    navController: NavHostController,
    restaurantId: Int,
    viewModel: FoodsViewModel = FoodsViewModel()
) {
    val isDialogOpen = remember { mutableStateOf(false)}

    val foods: List<Food> = if(restaurantId == 0){
        viewModel.getFoods.observeAsState(listOf()).value
    }else{
        viewModel.getFoodsByRestaurantId(restaurantId).observeAsState(listOf()).value
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        //TEst
        //Text(text = restaurantId)
        //
        TextField(
            value = "Buscar comidas",
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
        )
        /*Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Platos",
            style = TextStyle(color = Color.Black, fontSize = 36.sp, fontWeight = FontWeight.Black)
        )*/
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp))
        Row() {

            ShowDialogForm(isDialogOpen,save =  viewModel::saveFood, navController = navController)


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
                    text = "Añadir Comida"
                )
            }
        }



        LazyVerticalGrid(
            cells = GridCells.Adaptive(128.dp),
            contentPadding = PaddingValues(
                top = 12.dp,
                bottom = 100.dp
            )
        ){
            items(foods.size) { index ->
                ItemFood(item = foods[index], saveFood = viewModel::saveFood, viewModel::deleteFood, navController) {
                    navController.navigate(Destinations.FoodDetail.createRoute(foods[index].id))
                }
            }
        }
    }
}



