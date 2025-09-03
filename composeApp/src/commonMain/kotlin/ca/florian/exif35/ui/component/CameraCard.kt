package ca.florian.exif35.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.db.model.camera.CameraGlance

@Composable
fun CameraCard(
    onNavigateToCamera: (Long) -> Unit = {},
    onDeleteCamera: (Camera) -> Unit = {},
    cameraGlance: CameraGlance
) {
    val camera = cameraGlance.camera
    val lastRollUsed = cameraGlance.lastRollUsed.?roll

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .combinedClickable(
                onClick = { onNavigateToCamera(camera.id) },
                onLongClick = { onDeleteCamera(camera) }
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
                    CameraTitle(
                        modifier = Modifier.weight(1f, fill = false),
                        camera = camera
                    )
                    Column(
                        modifier = Modifier.padding(start = 8.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            maxLines = 1,
                            color = LocalContentColor.current.copy(alpha = 0.7f),
                            text = "*",
                        )
                        Text(text = "${cameraInformation.shotsTaken} / ${cameraInformation.negative?.numberOfShots ?: 0}")
                    }
                }
                Text(
                    maxLines = 1,
                    overflow = Ellipsis,
                    text = cameraInformation.lastLensUsed ?: "*",
                )
                Text(
                    maxLines = 1,
                    overflow = Ellipsis,
                    text = cameraInformation.negative?.name ?: "*",
                )
            }
        }
    }
}
