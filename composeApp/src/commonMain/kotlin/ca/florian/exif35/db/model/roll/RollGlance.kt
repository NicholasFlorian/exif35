package ca.florian.exif35.db.model.roll

import androidx.room.Embedded
import androidx.room.Relation
import ca.florian.exif35.db.model.exposure.Exposure

data class RollGlance(
    @Embedded
    val roll: Roll,
    @Relation(
        entity = Exposure::class,
        parentColumn = "id",
        entityColumn = "filmRollId",
    )
    @Embedded
    val recentExposures: List<Exposure>?
)
