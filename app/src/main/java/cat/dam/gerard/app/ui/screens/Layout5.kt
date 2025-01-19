package cat.dam.gerard.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cat.dam.gerard.constraintscafold.R


@Composable
fun Layout5() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (red, orange, yellow, fuchsia, blue, purple, green) = createRefs()


        Text(
            text = stringResource(id = R.string.red),
            color = Color.Black,
            modifier = Modifier
                .background(Color.Red)
                .padding(8.dp)
                .constrainAs(red) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Text(
            text = stringResource(id = R.string.orange),
            color = Color.Black,
            modifier = Modifier
                .background(Color(0xFFFFA500)) // Color taronja
                .padding(8.dp)
                .constrainAs(orange) {
                    top.linkTo(red.bottom)
                    start.linkTo(red.end)
                }
        )

        Text(
            text = stringResource(id = R.string.yellow),
            color = Color.Black,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(8.dp)
                .constrainAs(yellow) {
                    top.linkTo(orange.bottom)
                    start.linkTo(orange.end)
                }
        )

        Text(
            text = stringResource(id = R.string.fuchsia),
            color = Color.White,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(8.dp)
                .constrainAs(fuchsia) {
                    top.linkTo(yellow.bottom)
                    start.linkTo(yellow.end)
                }
        )

        Text(
            text = stringResource(id = R.string.blue),
            color = Color.White,
            modifier = Modifier
                .background(Color.Blue)
                .padding(8.dp)
                .constrainAs(blue) {
                    top.linkTo(fuchsia.bottom)
                    start.linkTo(fuchsia.end)
                }
        )

        Text(
            text = stringResource(id = R.string.purple),
            color = Color.White,
            modifier = Modifier
                .background(Color(0xFF800080)) // Color lila
                .padding(8.dp)
                .constrainAs(purple) {
                    bottom.linkTo(blue.bottom, margin = -32.dp) // Sota del blau
                    start.linkTo(blue.start, margin = -66.dp)
                }
        )

        Text(
            text = stringResource(id = R.string.green),
            color = Color.Black,
            modifier = Modifier
                .background(Color.Green)
                .padding(8.dp)
                .constrainAs(green) {
                    bottom.linkTo(purple.bottom, margin = -32.dp) // Sota del blau
                    start.linkTo(purple.start, margin = -61.dp)
                }
        )
    }
}

@Preview
@Composable
fun PreviewStaggeredColors() {
    Layout5()
}