package com.dev0.deliveryfood.feacture_cart.presentation.cart.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.dev0.deliveryfood.feacture_cart.domain.model.OrderDetail

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CardContent(
    orderdetail: OrderDetail,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = orderdetail.food.name,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(
            text = "p: "+orderdetail.food.price.toString(),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "c: "+orderdetail.quantity.toString(),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "t: "+orderdetail.total.toString(),
            style = MaterialTheme.typography.body1
        )
        Button(
            onClick = onClick
        ) {
            Text(text = "X")
        }
    }

}