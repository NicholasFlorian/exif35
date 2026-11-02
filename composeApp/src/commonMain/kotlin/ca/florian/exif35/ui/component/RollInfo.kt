package ca.florian.exif35.ui.component

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ca.florian.exif35.db.model.roll.RollGlance

@Composable
fun RollInfo(
    lazyListScope: LazyListScope,
    rollGlance: RollGlance,
    isExpanded: Boolean,
    onToggleExpanded: () -> Unit,
    onSaveExposure: (String) -> Unit,
) {
    lazyListScope.item {
        RollCard(
            rollGlance,
            isExpanded,
            onToggleExpanded,
        )
    }
    lazyListScope.item {
        AddNextExposureCard(onSaveClick = onSaveExposure)
    }
    if(isExpanded) {
        lazyListScope.items(
            items = rollGlance.recentExposures ?: emptyList(),
            key = { exposure -> exposure.id }
        ) { exposure ->
            ExposureCard(exposure = exposure)
        }
    }
}
