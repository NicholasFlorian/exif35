package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.ui.component.CameraDialog
import ca.florian.exif35.ui.style.Exif35Theme

@PreviewLightDark
@Composable
fun CameraDialogEmptyPreview() {
    Exif35Theme {
        CameraDialog(onDismissRequest = {}, onConfirmation = {})
    }
}

@PreviewLightDark
@Composable
fun CameraDialogFilledPreview() {
    Exif35Theme {
        CameraDialog(
            onDismissRequest = {},
            onConfirmation = {},
            initialBrand = "Nikon",
            initialModel = "F3"
        )
    }
}

@PreviewLightDark
@Composable
fun CameraDialogErrorPreview() {
    Exif35Theme {
        // To simulate an error, we'll pass empty strings and rely on the dialog's internal validation
        CameraDialog(
            onDismissRequest = {},
            onConfirmation = {},
            initialBrand = "",
            initialModel = ""
        )
    }
}
