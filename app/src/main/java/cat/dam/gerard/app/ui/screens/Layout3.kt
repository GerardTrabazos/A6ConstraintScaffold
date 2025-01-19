package cat.dam.gerard.app.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.dam.gerard.app.ui.theme.AppTheme
import cat.dam.gerard.app.ui.theme.Black
import cat.dam.gerard.app.ui.theme.Maroon
import cat.dam.gerard.app.ui.theme.Orange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Layout3() {
    // Crea una instància de SnackbarHostState per gestionar les Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    // Crea un CoroutineScope per a utilitzar en la gestió d'events asincrònics com ara SnackBar
    val coroutineScope = rememberCoroutineScope()
    // Obté el context de l'aplicació per utilitzar en els Toast
    val context = LocalContext.current.applicationContext
    // Utilitza el Scaffold per estructurar la UI de la pantalla amb subfuncions
    Scaffold(
        // Color del fons del contenidor principal si no queda tapat per barres o contingut
        // Color del text del contingut
        contentColor = Black,
        // Contingut de la TopAppBar
        topBar = { TopAppBarContent(context) },
        // Contingut del FloatingActionButton
        floatingActionButton = { FabContent(snackbarHostState, coroutineScope) },
        // Contingut principal de la pantalla amb ajustaments de padding
        content = { innerPadding -> ScaffoldContent(innerPadding, context) },
        // Contingut de la BottomAppBar
        bottomBar = { BottomAppBarContent(context) },
        // SnackbarHost per mostrar Snackbar a la pantalla
        snackbarHost = { SnackbarHostContent(snackbarHostState) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(context: Context) {
    TopAppBar(
        modifier = Modifier.clickable {
            Toast.makeText(context, "TopAppBar clicked", Toast.LENGTH_SHORT).show()
        },
        title = { Text(text = "TopAppBar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Maroon,
            titleContentColor = White
        )
    )
}

@Composable
fun BottomAppBarContent(context: Context) {
    BottomAppBar(
        modifier = Modifier.clickable {
            Toast.makeText(context, "BottomAppBar clicked", Toast.LENGTH_SHORT).show()
        },
        containerColor = Maroon,
        contentColor = White
    ) {
        Text(text = "BottomAppBar")
    }
}

@Composable
fun ScaffoldContent(innerPadding: PaddingValues, context: Context) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Orange)
            .clickable { Toast.makeText(context, "Content clicked", Toast.LENGTH_SHORT).show() }
    ) { Text(text = "My name is Gerard and i am a developer. I am lerning Jetpack Compose" ,
        modifier = Modifier
            .padding(16.dp),
        color = Maroon ) }
}

@Composable
fun FabContent(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                snackbarHostState.currentSnackbarData?.dismiss()
                snackbarHostState.showSnackbar(
                    message = "You clicked on FAB. This is a Snackbar",
                    actionLabel = "Dismiss",
                    duration = SnackbarDuration.Short
                )
            }
        },
        containerColor = Maroon,
        contentColor = White,
        shape = RoundedCornerShape(16.dp) // Defineix les cantonades arrodonides
    ) {
        Text("+")
    }
}


@Composable
fun SnackbarHostContent(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { snackbarData ->
            Snackbar(
                snackbarData = snackbarData,
                modifier = Modifier.padding(8.dp),
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                actionColor = MaterialTheme.colorScheme.onTertiaryContainer,
                shape = MaterialTheme.shapes.small,
            )
        }
    )
}

@Preview
@Composable
fun ShowLayout3Preview() {
    AppTheme {
        Layout3()
    }
}