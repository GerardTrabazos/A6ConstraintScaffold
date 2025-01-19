import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Orange
import cat.dam.gerard.app.ui.theme.White


@Composable
fun Layout4() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        ChainTextBlock(
            title = "Packed",
            chainStyle = ChainStyle.Packed,
            texts = listOf("Packed A", "Packed B", "Packed C")
        )

        ChainTextBlock(
            title = "Spread",
            chainStyle = ChainStyle.Spread,
            texts = listOf("Spread A", "Spread B", "Spread C")
        )

        ChainTextBlock(
            title = "SpreadInside",
            chainStyle = ChainStyle.SpreadInside,
            texts = listOf("SpreadInside A", "SpreadInside B", "SpreadInside C")
        )
    }
}

@Composable
fun ChainTextBlock(title: String, chainStyle: ChainStyle, texts: List<String>) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(vertical = 8.dp)
    ) {
        val (chainTitle, text1, text2, text3) = createRefs()


        createHorizontalChain(
            text1, text2, text3,
            chainStyle = chainStyle
        )


        Text(
            text = title,
            modifier = Modifier
                .constrainAs(chainTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(bottom = 4.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = texts[0],
            modifier = Modifier
                .constrainAs(text1) {
                    top.linkTo(chainTitle.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .background(Orange)
                .padding(8.dp),
            color = Color.White
        )
        Text(
            text = texts[1],
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(chainTitle.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .background(Orange)
                .padding(8.dp),
            color = White
        )
        Text(
            text = texts[2],
            modifier = Modifier
                .constrainAs(text3) {
                    top.linkTo(chainTitle.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .background(Orange)
                .padding(8.dp),
            color = White
        )
    }
}

@Preview
@Composable
fun Layout4Preview() {
    AppTheme {
        Layout4()
    }
}