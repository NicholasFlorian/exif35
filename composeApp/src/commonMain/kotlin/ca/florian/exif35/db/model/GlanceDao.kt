package ca.florian.exif35.db.model

import androidx.room.Dao
import androidx.room.Query
import ca.florian.exif35.db.model.camera.CameraGlance
import kotlinx.coroutines.flow.Flow

@Dao
interface GlanceDao {

    @Query(""" 
        SELECT * FROM cameras 
            INNER JOIN ( 
                SELECT * FROM rolls 
                    INNER JOIN exposures ON rolls.id = exposures.rollId 
                    WHERE rolls.inUse = TRUE
                    GROUP BY rolls.cameraId
                    ORDER BY exposures.id DESC LIMIT 5
            ) AS rollGlance
    """)
    suspend fun getAllCameraGlances() : Flow<List<CameraGlance>>
}
