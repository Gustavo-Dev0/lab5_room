package com.dev0.deliveryfood.feacture_cart.presentation.cart

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev0.deliveryfood.feacture_cart.domain.model.OrderDetail
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.dev0.deliveryfood.core.presentation.utils.Destinations
import com.dev0.deliveryfood.feacture_cart.presentation.cart.components.ItemOrder
import com.dev0.deliveryfood.feacture_cart.presentation.cart.utils.reSum


@Composable
fun CartScreen(
    navController: NavHostController,
    title:String,
    viewModel: CartViewModel = CartViewModel()
) {
    //viewModel.getOrder()

    val orderDetailList = remember {
        mutableStateListOf<OrderDetail>()
    }

    var void by remember { mutableStateOf(true) }



    val state = viewModel.state.value
    if(orderDetailList.size == 0){
        orderDetailList.addAll(state.order.foods)
    }


    if(state.order.foods.size != 0){
        void = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        //verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Platos elegidos",
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )
        if(void){
            Text(
                modifier = Modifier.padding(top = 300.dp),
                text = "Esto está vacío",
                style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
            )
        }else{
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 12.dp,
                    bottom = 100.dp
                ),

                ) {

                itemsIndexed(orderDetailList) { index, item ->
                    Log.e("CREA", "CARTA"+orderDetailList.size)
                    ItemOrder(item = item){
                        orderDetailList.remove(item)
                        state.order.foods.clear()
                        state.order.foods.addAll(orderDetailList)

                        var totalNew = reSum(orderDetailList)
                        CartViewModel.actualOrder.total = totalNew

                        viewModel.updateOrder(state.order)

                        if(CartViewModel.actualOrder.foods.size == 0){
                            void = true
                        }
                    }
                }
            }
            Text(
                text = "Total a pagar: "+state.order.total,
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Button(
                onClick = {
                    viewModel.makeOrder()
                    orderDetailList.clear()
                    void = true
                    navController.navigate(Destinations.History.route)
                }
            ) {
                Text(text = "Realizar pedido")
            }
        }

    }
}




