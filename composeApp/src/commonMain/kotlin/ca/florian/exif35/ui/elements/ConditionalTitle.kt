package ca.florian.exif35.ui.elements

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ConditionalTitle(
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = LocalContentColor.current,
    title: String? = null,
) {
    val (text, color) =
        if (title.isNullOrEmpty())
            Pair("<title>", color.copy(alpha = 0.8f))
        else
            Pair(title, color)

    Text(
        modifier = modifier,
        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
        text = text,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
