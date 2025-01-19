package cat.dam.gerard.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Aqua
import androidx.constraintlayout.compose.ConstraintLayout

import cat.dam.gerard.app.ui.theme.Lime // Asegúrate de que este color esté definido en tu tema

@Composable
fun Layout2() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Crea línies guia verticals basades en percentatges
        val verticalGuide1 = createGuidelineFromStart(0.3f) // 30% des de l'esquerra
        val verticalGuide2 = createGuidelineFromStart(0.55f) // 55% des de l'esquerra (30% + 25%)
        val verticalGuide3 = createGuidelineFromStart(1f) // 100% per completar

        val horizontalGuide = createGuidelineFromTop(0.5f) // 50% de l'alçada

        // Crea referències per als elements
        val (box1, box2, box3, box4, box5, box6) = createRefs()

        // Layout 1 - Blau (30%-50%)
        Box(
            modifier = Modifier
                .background(Aqua) // Blau
                .constrainAs(box1) {
                    start.linkTo(parent.start)
                    end.linkTo(verticalGuide1)
                    top.linkTo(parent.top)
                    bottom.linkTo(horizontalGuide)
                }
        )

        // Layout 2 - Verd (25%-50%)
        Box(
            modifier = Modifier
                .background(Color.Green)
                .constrainAs(box2) {
                    start.linkTo(verticalGuide1)
                    end.linkTo(verticalGuide2)
                    top.linkTo(parent.top)
                    bottom.linkTo(horizontalGuide)
                }
        )

        // Layout 3 - Verd Fosforito (45%-50%)
        Box(
            modifier = Modifier
                .background(Lime) // Verd Fosforito
                .constrainAs(box3) {
                    start.linkTo(verticalGuide2)
                    end.linkTo(verticalGuide3)
                    top.linkTo(parent.top)
                    bottom.linkTo(horizontalGuide)
                }
        )

        // Layout 4 - Groc (20%-50%)
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .constrainAs(box4) {
                    start.linkTo(parent.start)
                    end.linkTo(verticalGuide1)
                    top.linkTo(horizontalGuide)
                    bottom.linkTo(parent.bottom)
                }
        )

        // Layout 5 - Vermell (10%-50%)
        Box(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(box5) {
                    start.linkTo(verticalGuide1)
                    end.linkTo(verticalGuide2)
                    top.linkTo(horizontalGuide)
                    bottom.linkTo(parent.bottom)
                }
        )

        // Layout 6 - Lila (70%-50%)
        Box(
            modifier = Modifier
                .background(Color.Magenta)
                .constrainAs(box6) {
                    start.linkTo(verticalGuide2)
                    end.linkTo(verticalGuide3)
                    top.linkTo(horizontalGuide)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLayout2() {
    AppTheme {
        Layout2()
    }
}
