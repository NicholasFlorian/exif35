package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ca.florian.exif35.ui.component.CameraCard

@Preview
@Composable
fun CameraCardPreview() {
    CameraCard(
        name = "Canon AE-1",
        lastUsed = "2025-08-03",
        shotsLeft = 12,
        film = "Kodak Portra 400",
        lens = "50mm f/1.8"
    )
}