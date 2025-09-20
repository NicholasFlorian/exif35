package ca.florian.exif35.ui.elements

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ca.florian.exif35.ui.util.DateFormatter

@Composable
fun ConditionalDate(
    date: Long?
) {
    val (text, color) =
        if (date == null || date == 0L)
            Pair("__ * __ * __", LocalContentColor.current.copy(alpha = 0.8f))
        else
            Pair(DateFormatter.format(date), LocalContentColor.current)

    Text(text = text, color = color)
}
