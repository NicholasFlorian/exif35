package ca.florian.exif35.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CameraCard(name: String, lastUsed: String, shotsLeft: Int, film: String, lens: String) {
    Column {
        Text(text = "Name: $name")
        Text(text = "Last Used: $lastUsed")
        Text(text = "Shots Left: $shotsLeft")
        Text(text = "Film: $film")
        Text(text = "Lens: $lens")
    }
}