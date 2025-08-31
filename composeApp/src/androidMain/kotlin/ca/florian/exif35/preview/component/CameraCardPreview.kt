package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.db.model.Camera
import ca.florian.exif35.ui.component.CameraCard
import ca.florian.exif35.ui.style.Exif35Theme

@PreviewLightDark
@Composable
fun CameraCardPreview() {
    Exif35Theme {
        CameraCard(
            camera = Camera(
                brand = "Nikon",
                model = "F3"
            ),
            lastUsed = "2025-08-03",
            shotsTaken = 12,
            rollSize = 36,
            film = "Kodak Portra 400",
            lens = "50mm f/1.8"
        )
    }
}

@PreviewLightDark
@Composable
fun NewCameraCardPreview() {
    Exif35Theme {
        CameraCard(
            camera = Camera(
                brand = "Canon",
                model = "AE-1",
            ),
        )
    }
}

@PreviewLightDark
@Composable
fun OverFlowCameraCardPreview() {
    Exif35Theme {
        CameraCard(
            camera = Camera(
                brand = "CanonAndOnAndOnAndOnAndOn",
                model = "AE-1-2-3-4-5-7",
            ),
            lastUsed = "2025-08-03",
            shotsTaken = 12,
            film = "Kodak Portra 400,000,000,000,000,000,000,000,000,000,000,000,000",
            lens = "50mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm f/1.8"
        )
    }
}
