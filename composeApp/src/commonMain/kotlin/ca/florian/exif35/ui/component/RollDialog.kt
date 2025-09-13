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
import ca.florian.exif35.db.model.roll.Roll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions

@Composable
fun RollDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Roll) -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var isErrorName by remember { mutableStateOf(false) }
    var iso by remember { mutableStateOf("") }
    var isErrorIso by remember { mutableStateOf(false) }
    var exposures by remember { mutableStateOf("") }
    var isErrorExposures by remember { mutableStateOf(false) }

    val onConfirmationClicked = onClick@{
        isErrorName = name.isBlank()
        isErrorIso = iso.isBlank()
        isErrorExposures = exposures.isBlank()
        if (isErrorName || isErrorIso || isErrorExposures) {
            return@onClick
        }

        val roll = Roll(
            name = name,
            iso = iso.toIntOrNull() ?: 0,
            exposures = exposures.toIntOrNull() ?: 0,
            exposuresTaken = 0,
            isActive = true
        )
        onConfirmation(roll)
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
                value = name,
                onValueChange = { name = it },
                label = { Text("Roll Name") },
                isError = isErrorName,
                maxLines = 1,
                singleLine = true,
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = outlineTextColors,
                value = iso,
                onValueChange = { value ->
                    if (value.all { it.isDigit() }) {
                        iso = value
                    }
                },
                label = { Text("ISO") },
                isError = isErrorIso,
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = outlineTextColors,
                value = exposures,
                onValueChange = { value ->
                    if (value.all { it.isDigit() }) {
                        exposures = value
                    }
                },
                label = { Text("Exposures") },
                isError = isErrorExposures,
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(
                onClick = onConfirmationClicked,
            ) {
                Text("Save")
            }
        }
    }
}
