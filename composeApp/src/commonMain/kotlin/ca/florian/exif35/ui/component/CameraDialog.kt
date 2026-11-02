package ca.florian.exif35.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ca.florian.exif35.db.model.camera.Camera

@Composable
fun CameraDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Camera) -> Unit,
    initialBrand: String = "",
    initialModel: String = "",
    initialOwner: String = ""
) {
    var model by remember { mutableStateOf(initialModel) }
    var isErrorModel by remember { mutableStateOf(false) }
    var brand by remember { mutableStateOf(initialBrand) }
    var isErrorBrand by remember { mutableStateOf(false) }
    var owner by remember { mutableStateOf(initialOwner) }

    val onConfirmationClicked = onClick@{
        isErrorModel = model.isBlank()
        isErrorBrand = brand.isBlank()
        if (isErrorModel || isErrorBrand) {
            return@onClick
        }

        val camera = Camera(model = model, brand = brand, owner = owner)
        onConfirmation(camera)
    }

    val outlineTextColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        focusedLabelColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedLabelColor = MaterialTheme.colorScheme.outline,
        cursorColor = MaterialTheme.colorScheme.secondary
    )

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(16.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = outlineTextColors,
                value = brand,
                onValueChange = { brand = it },
                label = { Text("Camera Brand") },
                isError = isErrorBrand,
                maxLines = 1,
                singleLine = true,
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = outlineTextColors,
                value = owner,
                onValueChange = { owner = it },
                label = { Text("Owner (Optional)") },
                maxLines = 1,
                singleLine = true,
            )
            Button(
                onClick = onConfirmationClicked,
            ) {
                Text("Save")
            }
        }
    }
}
