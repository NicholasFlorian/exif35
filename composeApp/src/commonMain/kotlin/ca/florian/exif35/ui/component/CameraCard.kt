package ca.florian.exif35.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ca.florian.exif35.db.model.Camera

@Composable
fun CameraCard(
    onClickListener: (Camera) -> Unit = {},
    onLongClickListener: (Camera) -> Unit = {},
    brand: String,
    model: String,
    lastUsed: String = "****-**-**",
    shotsTaken: Int = 0,
    rollSize: Int = 0,
    film: String = "*",
    lens: String = "*",
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
            .combinedClickable(
                onClick =  { onClickListener },
                onLongClick = onLongClickListener
            )
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onSurfaceVariant
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                CameraTitle(
                    brand = brand,
                    model = model,
                )
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = lastUsed, color = LocalContentColor.current.copy(alpha = 0.7f))
                    Text(text = "$shotsTaken / $rollSize")
                }
            }
            Text(text = film)
            Text(text = lens)
        }
    }
}

@Composable
fun CameraTitle(
    brand: String,
    model: String,
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 1.dp),
            text = brand,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1
        )
        Text(
            text = model,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.inversePrimary,
            maxLines = 1
        )
    }
}
