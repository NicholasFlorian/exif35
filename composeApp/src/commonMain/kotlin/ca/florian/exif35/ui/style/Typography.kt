package ca.florian.exif35.ui.style

import exif35.composeapp.generated.resources.Lekton_Regular
import exif35.composeapp.generated.resources.Lekton_Italic
import exif35.composeapp.generated.resources.Lekton_Bold
import exif35.composeapp.generated.resources.Newsreader_VariableFont_opsz_wght
import exif35.composeapp.generated.resources.Res

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font

@Composable
fun lektonFamily() = FontFamily(
    Font(Res.font.Lekton_Regular, FontWeight.Normal, FontStyle.Normal),
    Font(Res.font.Lekton_Italic, FontWeight.Normal, FontStyle.Italic),
    Font(Res.font.Lekton_Bold, FontWeight.Bold, FontStyle.Normal),
)

@Composable
fun newsreaderFamily() = FontFamily(
    // Normal style
    Font(Res.font.Newsreader_VariableFont_opsz_wght, FontWeight.Light, FontStyle.Normal),
    Font(Res.font.Newsreader_VariableFont_opsz_wght, FontWeight.Normal, FontStyle.Normal),
    Font(Res.font.Newsreader_VariableFont_opsz_wght, FontWeight.Medium, FontStyle.Normal),
    Font(Res.font.Newsreader_VariableFont_opsz_wght, FontWeight.SemiBold, FontStyle.Normal),
    Font(Res.font.Newsreader_VariableFont_opsz_wght, FontWeight.Bold, FontStyle.Normal),
    Font(Res.font.Newsreader_VariableFont_opsz_wght, FontWeight.ExtraBold, FontStyle.Normal),
)

@Composable
fun Exif35Typeography() = androidx.compose.material3.Typography().run {
    copy(
        displayLarge = displayLarge.copy(fontFamily = newsreaderFamily()),
        displayMedium = displayMedium.copy(fontFamily = newsreaderFamily()),
        displaySmall = displaySmall.copy(fontFamily = newsreaderFamily()),
        headlineLarge = headlineLarge.copy(fontFamily = newsreaderFamily()),
        headlineMedium = headlineMedium.copy(fontFamily = newsreaderFamily()),
        headlineSmall = headlineSmall.copy(fontFamily = newsreaderFamily()),
        titleLarge = titleLarge.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W700),
        titleMedium = titleMedium.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W700),
        titleSmall = titleSmall.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W700),
        bodyLarge = bodyLarge.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W600),
        bodyMedium = bodyMedium.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W600),
        bodySmall = bodySmall.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W600),
        labelLarge = labelLarge.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W600),
        labelMedium = labelMedium.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W600),
        labelSmall = labelSmall.copy(fontFamily = lektonFamily(), fontWeight = FontWeight.W600)
    )
}
