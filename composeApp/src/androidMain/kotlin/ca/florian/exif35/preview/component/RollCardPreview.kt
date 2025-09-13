
package ca.florian.exif35.preview.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import ca.florian.exif35.db.model.exposure.Exposure
import ca.florian.exif35.db.model.roll.Roll
import ca.florian.exif35.db.model.roll.RollGlance
import ca.florian.exif35.ui.component.RollCard
import ca.florian.exif35.ui.style.Exif35Theme

@PreviewLightDark
@Composable
fun RollCardPreview() {
    Exif35Theme {
        RollCard(
            rollGlance = RollGlance(
                roll = Roll(
                    name = "Kodak Portra 400",
                    iso = 400,
                    exposures = 36,
                    exposuresTaken = 12,
                    isActive = true
                ),
                recentExposures = listOf(
                    Exposure(
                        rollId = 0,
                        location = "",
                        latitude = 0.0,
                        longitude = 0.0
                    )
                )
            )
        )
    }
}

@PreviewLightDark
@Composable
fun InactiveRollCardPreview() {
    Exif35Theme {
        RollCard(
            rollGlance = RollGlance(
                roll = Roll(
                    name = "Kodak Gold 200",
                    iso = 200,
                    exposures = 24,
                    exposuresTaken = 24,
                    isActive = false
                ),
                recentExposures = emptyList()
            )
        )
    }
}
