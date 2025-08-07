package ca.florian.exif35.ui.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import exif35.composeapp.generated.resources.Res
import exif35.composeapp.generated.resources.exif35_title_dark
import exif35.composeapp.generated.resources.exif35_title_light
import org.jetbrains.compose.resources.painterResource

@Composable
fun Exif35Title() {
    Icon(
        painter = painterResource(
            if (isSystemInDarkTheme())
                Res.drawable.exif35_title_dark
            else
                Res.drawable.exif35_title_light),
        contentDescription = "exif35 logo",
        tint = Color.Unspecified
    )
}
