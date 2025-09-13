package ca.florian.exif35.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ca.florian.exif35.db.model.exposure.Exposure
import ca.florian.exif35.ui.elements.ConditionalDate
import ca.florian.exif35.ui.elements.ConditionalLocation
import ca.florian.exif35.ui.elements.ConditionalText
import ca.florian.exif35.ui.elements.ConditionalTitle

@Composable
fun ExposureCard(
    exposure: Exposure
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(16.dp)
        ) {
            CompositionLocalProvider(
                LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    ConditionalTitle(exposure.title, modifier = Modifier.weight(1f, fill = false))
                    ConditionalDate(exposure.dateCreated)
                }
                ConditionalLocation(exposure.latitude, exposure.longitude)
                ConditionalText(exposure.aperture)
                ConditionalText(exposure.lensSettings)
                ConditionalText(exposure.iso)
                ConditionalText(exposure.exposureSetting)
            }
        }
    }
}
