package com.dev0.deliveryfood.feature_restaurant.presentation.restaurants.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.room.PrimaryKey
import com.dev0.deliveryfood.core.presentation.utils.Destinations
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant
import com.dev0.deliveryfood.ui.theme.Purple500

@Composable
fun ShowDialogRestaurantForm(
    isDialogOpen: MutableState<Boolean>,
    restaurant: Restaurant = Restaurant(),
    save: (Restaurant)->Unit,
    navController: NavHostController
) {

    val name = remember { mutableStateOf(restaurant.name) }
    val description = remember { mutableStateOf(restaurant.description) }
    val district = remember { mutableStateOf(restaurant.district) }
    val qualification = remember { mutableStateOf(restaurant.qualification) }
    val imageUrl = remember { mutableStateOf(restaurant.image) }

    val scrollState = rememberScrollState()

    val focusRequester = remember {
        FocusRequester
    }

    if(isDialogOpen.value) {
        Dialog(
            onDismissRequest = {  },
        ) {
            Surface(
                modifier = Modifier
                    .width(400.dp)
                    .height(600.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .verticalScroll(state = scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Nuevo restaurante",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.padding(10.dp))


                    OutlinedTextField(
                        value = name.value,
                        onValueChange = { name.value = it },
                        label = { Text(text = "Nombre") },
                        placeholder = { Text(text = "Nombre") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = description.value,
                        onValueChange = { description.value = it },
                        label = { Text(text = "Descripcion") },
                        placeholder = { Text(text = "Descripcion") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = ""+district.value,
                        onValueChange = { district.value = it},
                        label = { Text(text = "Distrito") },
                        placeholder = { Text(text = "Distrito") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                    )

                    OutlinedTextField(
                        value = qualification.value,
                        onValueChange = { qualification.value = it },
                        label = { Text(text = "Calificacion") },
                        placeholder = { Text(text = "Calificacion") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = imageUrl.value,
                        onValueChange = { imageUrl.value = it },
                        label = { Text(text = "Url de imagen") },
                        placeholder = { Text(text = "Url de imagen") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    Button(
                        onClick = {
                            restaurant.name = name.value
                            restaurant.description = description.value
                            restaurant.district = district.value
                            restaurant.qualification = qualification.value
                            restaurant.image = imageUrl.value
                            save(restaurant)
                            isDialogOpen.value = false
                            navController.navigate(Destinations.Restaurants.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text(
                            text = "Guardar",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Button(
                        onClick = {
                            isDialogOpen.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text(
                            text = "Cancelar",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}