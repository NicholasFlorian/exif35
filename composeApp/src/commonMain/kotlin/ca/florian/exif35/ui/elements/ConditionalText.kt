package ca.florian.exif35.ui.elements

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ConditionalText(
    text: String?,
    modifier: Modifier = Modifier
) {
    val (displayText, color) =
        if (text.isNullOrEmpty())
            Pair("<text>", LocalContentColor.current.copy(alpha = 0.8f))
        else
            Pair(text, LocalContentColor.current)

    Text(
        modifier = modifier,
        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
        text = displayText,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
