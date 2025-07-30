package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import ca.florian.exif35.ui.component.CameraForm
import ca.florian.exif35.ui.style.Exif35Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CameraFormPreview() {
    Exif35Theme {
        CameraForm(onSave = {})
    }
}
