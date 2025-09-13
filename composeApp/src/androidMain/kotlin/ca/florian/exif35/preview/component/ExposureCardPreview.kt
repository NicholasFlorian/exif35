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
                latitude = 45.5017,
                longitude = -73.5673,
                title = "An exposure with all details",
                aperture = "f/8",
                lensSettings = "50mm",
                iso = "400",
                exposureSetting = "1/125s",
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
                latitude = 45.5017,
                longitude = -73.5673,
                title = null,
                aperture = "f/8",
                lensSettings = "50mm",
                iso = "400",
                exposureSetting = "1/125s",
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
                latitude = 45.5017,
                longitude = -73.5673,
                title = "This is a very long exposure title to test overflow and truncation",
                aperture = "f/8",
                lensSettings = "50mm",
                iso = "400",
                exposureSetting = "1/125s",
                dateCreated = Date().time
            )
        )
    }
}

@PreviewLightDark
@Composable
fun ExposureCardNoLocationOrDetailsPreview() {
    Exif35Theme {
        ExposureCard(
            exposure = Exposure(
                rollId = 1L,
                location = "",
                latitude = 0.0,
                longitude = 0.0,
                title = "Exposure with no location or details",
                aperture = null,
                lensSettings = null,
                iso = null,
                exposureSetting = null,
                dateCreated = Date().time
            )
        )
    }
}
