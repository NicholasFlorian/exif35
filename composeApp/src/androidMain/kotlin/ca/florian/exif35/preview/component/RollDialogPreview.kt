package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.ui.component.RollDialog
import ca.florian.exif35.ui.style.Exif35Theme

@PreviewLightDark
@Composable
fun RollDialogEmptyPreview() {
    Exif35Theme {
        RollDialog(
            onDismissRequest = {},
            onConfirmation = {}
        )
    }
}

@PreviewLightDark
@Composable
fun RollDialogFilledPreview() {
    Exif35Theme {
        RollDialog(
            onDismissRequest = {},
            onConfirmation = {},
            initialName = "Kodak Portra 400",
            initialIso = "400",
            initialExposures = "36"
        )
    }
}

@PreviewLightDark
@Composable
fun RollDialogErrorPreview() {
    Exif35Theme {
        // To simulate an error, we'll pass empty strings and rely on the dialog's internal validation
        RollDialog(
            onDismissRequest = {},
            onConfirmation = {},
            initialName = "",
            initialIso = "",
            initialExposures = ""
        )
    }
}