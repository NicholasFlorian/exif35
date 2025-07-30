package ca.florian.exif35

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ca.florian.exif35.ui.component.CameraForm
import ca.florian.exif35.ui.style.Exif35Theme
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    Exif35Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("Exif35") })
                }
            ) {
                Column(modifier = Modifier.padding(it)) {
                    CameraForm(onSave = {
                        // TODO: Save camera to database
                        println("Camera saved: $it")
                    })
                }
            }
        }
    }
}
