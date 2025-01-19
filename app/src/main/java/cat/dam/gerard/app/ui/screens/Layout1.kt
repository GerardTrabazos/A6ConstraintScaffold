package cat.dam.gerard.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Aqua
import cat.dam.gerard.app.ui.theme.Orange
import androidx.constraintlayout.compose.ConstraintLayout
import cat.dam.gerard.app.ui.theme.Yellow


@Composable
fun Layout1() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Aqua)
            .padding(18.dp),
    ) {
        // Crea referències per als elements
        val (text1, text2, button) = createRefs()

        // Crea una barrera per al text més llarg
        val textBarrier = createBottomBarrier(text1, text2)

        // Defineix els Texts
        Text(
            text = "Lorem ipsum dolor sit amet consectetur adipiscing, elit vitae aenean euismod aliquet velit quisque, consequat malesuada ligula nibh senectus. Netus duis facilisis orci cursus mattis nulla blandit curabitur, tincidunt convallis varius urna id velit a condimentum lobortis, risus lacinia porttitor vestibulum sem enim rhoncus.",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(text1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(Yellow)
                .width(150.dp)
        )

        Text(
            text = "Lorem ipsum dolor sit amet consectetur adipiscing, elit vitae aenean euismod aliquet velit quisque, consequat malesuada ligula nibh senectus.",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .background(Orange)
                .width(150.dp)
        )

        // Afegeix un botó
        Button(
            onClick = {},
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(textBarrier, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text("Button")
        }
    }
}



@Composable
@Preview(showBackground = true)
fun PreviewLayout() {
    AppTheme {
        Layout1()
    }
}
