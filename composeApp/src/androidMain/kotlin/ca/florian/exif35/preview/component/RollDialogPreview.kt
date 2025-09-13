
package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import ca.florian.exif35.ui.component.RollDialog
import ca.florian.exif35.ui.style.Exif35Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun RollDialogPreview() {
    Exif35Theme {
        RollDialog(
            onDismissRequest = {},
            onConfirmation = {}
        )
    }
}
