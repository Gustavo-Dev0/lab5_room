import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dev0.deliveryfood.feature_food.domain.model.Food
import com.dev0.deliveryfood.feature_food.presentation.food_detail.FoodDetailViewModel
import com.dev0.deliveryfood.feature_food.presentation.food_detail.components.FoodCardDetail

@Composable
fun FoodDetailScreen(
    navController: NavHostController,
    foodId: Int?,
    viewModel: FoodDetailViewModel = FoodDetailViewModel()
) {

    if (foodId != null) {
        viewModel.getFoodById(id = foodId)
    }
    val food: Food = viewModel.getFoodById(foodId!!).observeAsState(Food()).value

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        FoodCardDetail(food, viewModel::editFood, viewModel::deleteFood){ cant ->
            viewModel.addToOrder(cant)
        }
    }
}
