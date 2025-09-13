package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.db.model.roll.Roll
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
            roll = Roll(
                name = "Kodak Portra 400",
                iso = 400,
                exposures = 36,
                exposuresTaken = 12
            )
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
            roll = Roll(
                name = "Kodak Portra 400,000,000,000,000,000,000,000,000,000,000,000,000",
                iso = 400,
                exposures = 36,
                exposuresTaken = 12
            )
        )
    }
}
