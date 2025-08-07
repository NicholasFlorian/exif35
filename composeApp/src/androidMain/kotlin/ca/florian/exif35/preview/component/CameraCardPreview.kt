package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.ui.component.CameraCard
import ca.florian.exif35.ui.style.Exif35Theme

@PreviewLightDark
@Composable
fun CameraCardPreview() {
    Exif35Theme {
        CameraCard(
            name = "Canon AE-1",
            lastUsed = "2025-08-03",
            shotsLeft = 12,
            film = "Kodak Portra 400",
            lens = "50mm f/1.8"
        )
    }
}
