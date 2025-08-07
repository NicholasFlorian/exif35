package ca.florian.exif35.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ca.florian.exif35.ui.component.CameraCard
import ca.florian.exif35.ui.component.Exif35Title
import exif35.composeapp.generated.resources.Res
import exif35.composeapp.generated.resources.film_stack
import exif35.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraListPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Exif35Title() },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(Res.drawable.plus),
                            contentDescription = "Add Camera"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(Res.drawable.film_stack),
                            contentDescription = "Search"
                        )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize(),
        ) {
            items(10) {
                CameraCard(
                    name = "Canon AE-1",
                    lastUsed = "2025-08-03",
                    shotsLeft = 12,
                    film = "Kodak Portra 400",
                    lens = "50mm f/1.8"
                )
            }
        }
    }
}
