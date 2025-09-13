package ca.florian.exif35.ui.elements

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConditionalTitle(
    title: String?
) {
    val (text, color) =
        if (title.isNullOrEmpty())
            Pair("<title>", LocalContentColor.current.copy(alpha = 0.8f))
        else
            Pair(title, LocalContentColor.current)

    Text(
        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
        text = text,
        color = color
    )
}
