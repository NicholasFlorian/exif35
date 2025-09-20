package ca.florian.exif35.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ca.florian.exif35.db.model.roll.RollGlance

fun LazyListScope.rollInfo(
    rollGlance: RollGlance,
    onSaveExposureClick: (String) -> Unit
) {
    item {
        RollCard(rollGlance = rollGlance)
    }
    item {
        NextExposureCard(onSaveClick = onSaveExposureClick)
    }
    items(rollGlance.recentExposures ?: emptyList()) { exposure ->
        ExposureCard(exposure = exposure)
    }
}
