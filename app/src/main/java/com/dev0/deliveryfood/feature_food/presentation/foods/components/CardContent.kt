package com.dev0.deliveryfood.feature_food.presentation.foods.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dev0.deliveryfood.feature_food.domain.model.Food

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CardContent(
    food: Food,
    saveFood: (Food) -> Unit,
    onDeleteClick: (Food) -> Unit,
    navController: NavHostController
) {


    val isDialogEditOpen = remember { mutableStateOf(false) }

    Box(){
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {


                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .padding(bottom = 8.dp),
                    painter = rememberImagePainter(data = food.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = food.name,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1
                )

                Text(text = food.restaurantName, style = MaterialTheme.typography.body1)

                Text(
                    text = food.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2,
                )


                Row() {
                    ShowDialogForm(isDialogEditOpen,save =  saveFood, food = food,
                        navController = navController
                    )

                    IconButton(onClick = { isDialogEditOpen.value = true }) {
                        Icon(Icons.Default.Edit, contentDescription = null)
                    }

                    IconButton(onClick = { onDeleteClick(food) }) {
                        Icon(Icons.Default.Delete, contentDescription = null)
                    }
                }
            }

        }
    }

}