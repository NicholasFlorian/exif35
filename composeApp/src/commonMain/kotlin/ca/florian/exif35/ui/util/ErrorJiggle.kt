package ca.florian.exif35.ui.util

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.roundToInt

fun Modifier.jiggle(errorFlow: Flow<Unit>) = composed {
    val offsetX = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        errorFlow.collectLatest { 
            offsetX.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = 0.05f,
                    stiffness = 500f,
                ),
                initialVelocity = 2000f
            )
        }
    }

    Modifier
        .offset {
            IntOffset(offsetX.value.roundToInt(), 0)
        }
}

