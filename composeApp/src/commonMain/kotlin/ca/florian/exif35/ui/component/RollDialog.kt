package ca.florian.exif35.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ca.florian.exif35.db.model.roll.Roll

@Composable
fun RollDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Roll) -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var iso by remember { mutableStateOf("") }
    var exposures by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = "Add Roll") },
        text = {
            Column {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Roll Name") }
                )
                TextField(
                    value = iso,
                    onValueChange = { iso = it },
                    label = { Text("ISO") }
                )
                TextField(
                    value = exposures,
                    onValueChange = { exposures = it },
                    label = { Text("Exposures") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val roll = Roll(
                        name = name,
                        iso = iso.toIntOrNull() ?: 0,
                        exposures = exposures.toIntOrNull() ?: 0,
                        exposuresTaken = 0,
                        isActive = true
                    )
                    onConfirmation(roll)
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text("Cancel")
            }
        }
    )
}
