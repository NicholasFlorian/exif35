package ca.florian.exif35.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import ca.florian.exif35.ui.util.roundToDecimals

@Composable
fun ConditionalLocation(
    latitude: Double?,
    longitude: Double?,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        if (latitude != null && longitude != null) {

            val latitudeString = latitude.roundToDecimals(2)
            val longitudeString = longitude.roundToDecimals(2)

            Text(
                text = "$latitudeString $longitudeString",
                color = LocalContentColor.current,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        } else {
            Text(
                text = "**:** **:**",
                color = LocalContentColor.current.copy(alpha = 0.8f),
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
