package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.ui.component.CameraCard
import ca.florian.exif35.ui.style.Exif35Theme

@PreviewLightDark
@Composable
fun CameraCardPreview() {
    Exif35Theme {
        CameraCard(
            brand = "Canon",
            model = "AE-1",
            lastUsed = "2025-08-03",
            shotsTaken = 12,
            film = "Kodak Portra 400",
            lens = "50mm f/1.8"
        )
    }
}
