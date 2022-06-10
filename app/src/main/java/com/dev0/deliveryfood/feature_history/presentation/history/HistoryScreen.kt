
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
import com.dev0.deliveryfood.feacture_cart.domain.model.Order
import com.dev0.deliveryfood.feature_history.presentation.history.HistoryViewModel
import com.dev0.deliveryfood.feature_history.presentation.history.components.ItemHistory

@Composable
fun HistoryScreen(
    title:String,
    viewModel: HistoryViewModel = HistoryViewModel()
) {

    val orderList = remember {
        mutableStateListOf<Order>()
    }

    var void by remember { mutableStateOf(true) }


    val state = viewModel.state.value
    orderList.addAll(state.historyList)

    if(orderList.size > 0){
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
            text = "Historial de pedidos",
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

                itemsIndexed(orderList) { index, item ->
                    ItemHistory(item = item)
                }
            }
        }

    }
}





