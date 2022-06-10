package com.dev0.deliveryfood.feature_history.presentation.history.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.dev0.deliveryfood.feacture_cart.domain.model.Order

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CardContent(
    order: Order
) {

    Row(
        modifier = Modifier
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = order.userName,
            style = MaterialTheme.typography.h5
        )

        Text(
            text = order.date,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )

        Text(
            text = "S/. " +order.total,
            style = MaterialTheme.typography.h5
        )

        Icon(
            if (order.status == 1){
                Icons.Filled.Check}else{
                Icons.Default.Error},
            modifier = Modifier.padding(8.dp).size(64.dp),
            contentDescription = ""
        )
    }

}