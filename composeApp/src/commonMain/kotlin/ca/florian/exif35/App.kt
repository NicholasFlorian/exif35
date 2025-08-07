package ca.florian.exif35

import androidx.compose.runtime.Composable
import ca.florian.exif35.ui.navigation.Exif35NavHost
import ca.florian.exif35.ui.style.Exif35Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Exif35Theme {
        Exif35NavHost()
    }
}
