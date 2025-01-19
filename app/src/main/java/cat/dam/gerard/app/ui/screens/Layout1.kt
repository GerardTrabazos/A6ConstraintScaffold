package cat.dam.gerard.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cat.dam.gerard.app.ui.theme.AppTheme

@Preview(showBackground = true)
@Composable
fun Layout1() {
    Column (modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth(),
    ) {
        Text(text = "Gerard", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .fillMaxSize()
            .weight(1f)
            .wrapContentSize(Alignment.Center),
        )
        Text(text = "Gerard", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .fillMaxSize()
            .weight(1f)
            .wrapContentSize(Alignment.Center)
        )
        Text(text = "Gerard", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .fillMaxSize()
            .weight(1f)
            .wrapContentSize(Alignment.Center)
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewLayout() {
    AppTheme {
        Layout1()
    }
}
