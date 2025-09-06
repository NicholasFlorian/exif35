package ca.florian.exif35.db.model.camera

import androidx.room.Embedded
import androidx.room.Relation
import ca.florian.exif35.db.model.roll.Roll

data class CameraGlance(
    @Embedded
    val camera: Camera,
    @Relation(
        entity = Roll::class,
        parentColumn = "id",
        entityColumn = "cameraId"
    )
    val lastRollUsed: Roll?,
//    @Relation(
//        entity = Exposure::class,
//        parentColumn = "id",
//        entityColumn = "rollId"
//    )
//    val exposureGlances: List<RollGlance>
)
