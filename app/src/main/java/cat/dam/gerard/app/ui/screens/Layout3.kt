package cat.dam.gerard.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Aqua
import cat.dam.gerard.app.ui.theme.Purple
import cat.dam.gerard.app.ui.theme.Yellow

@Preview(showBackground = true)
@Composable
fun Layout3() {

    Column (modifier =  Modifier.fillMaxSize(),

        ) {
        Row (modifier = Modifier
            .padding(5.dp)
        ){
            Text(text = "Gerard", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
            )
        }

        Row (modifier = Modifier
            .background(Yellow)
            .fillMaxWidth()
            .height(450.dp)
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard ", modifier = Modifier
                .background(Color.Red)
                .padding(8.dp)
                .width(100.dp)
            )

            Text(text = "Gerard", modifier = Modifier
                .background(Color.Green)
                .padding(8.dp)
                .width(100.dp)

            )

            Text(text = "Gerard", modifier = Modifier
                .background(Color.Blue)
                .padding(8.dp)
                .width(100.dp)
            )
        }

        Row (modifier = Modifier
            .background(Purple)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Gerard ", modifier = Modifier
                .background(Aqua)
                .padding(8.dp)
                .width(100.dp)
                .wrapContentSize(Alignment.Center)
            )

            Text(text = "Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard ", modifier = Modifier
                .background(Color.Yellow)
                .padding(8.dp)
                .width(100.dp)
                .wrapContentSize(Alignment.Center)
            )

            Column (modifier = Modifier
                .background(Red)
                .padding(8.dp)
                .width(100.dp)
                .wrapContentSize(Alignment.Center),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Gerard Gerard Gerard Gerard Gerard Gerard Gerard Gerard ", modifier = Modifier
                    .background(White)
                    .padding(8.dp)
                    .width(100.dp)
                )
                Text(text = "Gerard", modifier = Modifier
                    .background(Aqua)
                    .padding(8.dp)
                    .width(100.dp)
                    .wrapContentSize(Alignment.Center)
                )
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewLayout3() {
    AppTheme {
        Layout3()
    }
}
