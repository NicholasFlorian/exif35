package ca.florian.exif35.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.ui.elements.CameraTitle
import ca.florian.exif35.ui.elements.ConditionalDate
import ca.florian.exif35.ui.elements.ConditionalTitle
import ca.florian.exif35.ui.elements.Exif35Title
import ca.florian.exif35.ui.style.Exif35Theme
import java.util.Date

@PreviewLightDark
@Composable
fun CameraTitlePreview() {
    Exif35Theme {
        CameraTitle(
            camera = Camera(
                brand = "Nikon",
                model = "F3"
            )
        )
    }
}

@PreviewLightDark
@Composable
fun CameraTitleLongPreview() {
    Exif35Theme {
        CameraTitle(
            camera = Camera(
                brand = "ThisIsAVeryLongBrandName",
                model = "This Is A Very Long Model Name"
            )
        )
    }
}

@PreviewLightDark
@Composable
fun ConditionalDatePreview() {
    Exif35Theme {
        ConditionalDate(Date().time)
    }
}

@PreviewLightDark
@Composable
fun ConditionalDateNullPreview() {
    Exif35Theme {
        ConditionalDate(null)
    }
}

@PreviewLightDark
@Composable
fun ConditionalTitlePreview() {
    Exif35Theme {
        ConditionalTitle(title = "A Title")
    }
}

@PreviewLightDark
@Composable
fun ConditionalTitleNullPreview() {
    Exif35Theme {
        ConditionalTitle(title = null)
    }
}

@PreviewLightDark
@Composable
fun Exif35TitlePreview() {
    Exif35Theme {
        Exif35Title()
    }
}
