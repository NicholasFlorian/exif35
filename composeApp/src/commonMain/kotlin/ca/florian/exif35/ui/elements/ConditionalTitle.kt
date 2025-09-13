package ca.florian.exif35.ui.elements

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ConditionalTitle(
    title: String?,
    modifier: Modifier = Modifier,
) {
    val (text, color) =
        if (title.isNullOrEmpty())
            Pair("<title>", LocalContentColor.current.copy(alpha = 0.8f))
        else
            Pair(title, LocalContentColor.current)

    Text(
        modifier = modifier,
        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
        text = text,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
