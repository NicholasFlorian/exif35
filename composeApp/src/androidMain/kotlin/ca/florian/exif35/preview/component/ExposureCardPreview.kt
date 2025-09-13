package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.db.model.exposure.Exposure
import ca.florian.exif35.ui.component.ExposureCard
import ca.florian.exif35.ui.style.Exif35Theme
import java.util.Date

@PreviewLightDark
@Composable
fun ExposureCardPreview() {
    Exif35Theme {
        ExposureCard(
            exposure = Exposure(
                rollId = 1L,
                location = "Test Location",
                latitude = 0.0,
                longitude = 0.0,
                title = "An exposure",
                dateCreated = Date().time
            )
        )
    }
}

@PreviewLightDark
@Composable
fun ExposureCardNullTitlePreview() {
    Exif35Theme {
        ExposureCard(
            exposure = Exposure(
                rollId = 1L,
                location = "Test Location",
                latitude = 0.0,
                longitude = 0.0,
                title = null,
                dateCreated = Date().time
            )
        )
    }
}

@PreviewLightDark
@Composable
fun ExposureCardLongTitlePreview() {
    Exif35Theme {
        ExposureCard(
            exposure = Exposure(
                rollId = 1L,
                location = "Test Location",
                latitude = 0.0,
                longitude = 0.0,
                title = "This is a very long exposure title to test overflow",
                dateCreated = Date().time
            )
        )
    }
}