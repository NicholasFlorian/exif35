package ca.florian.exif35

import androidx.compose.runtime.Composable
import ca.florian.exif35.ui.page.CameraListPage
import ca.florian.exif35.ui.style.Exif35Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed class Screen {
    data object Splash : Screen()
    data object CameraList : Screen()
}

@Composable
@Preview
fun App() {
    Exif35Theme {
        CameraListPage()
    }
}
