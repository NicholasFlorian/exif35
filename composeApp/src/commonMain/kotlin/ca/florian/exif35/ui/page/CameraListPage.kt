package ca.florian.exif35.ui.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ca.florian.exif35.ui.component.CameraCard

@Composable
fun CameraListPage() {
    LazyColumn {
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
