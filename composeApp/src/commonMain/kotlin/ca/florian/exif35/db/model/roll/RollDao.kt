package ca.florian.exif35.db.model.roll

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RollDao {
    @Insert
    suspend fun insert(roll: Roll)

    @Update
    suspend fun update(roll: Roll)

    @Transaction
    @Query("SELECT * FROM rolls WHERE id = :rollId")
    fun getRollGlanceById(rollId: Long) : Flow<RollGlance>

    @Query("SELECT * FROM rolls WHERE cameraId = :cameraId ORDER BY dateUpdated DESC")
    fun getRollsForCamera(cameraId: Long): Flow<List<Roll>>

    @Query("""
        UPDATE rolls 
            SET isActive = FALSE 
            WHERE cameraId = :cameraId AND isActive = TRUE
    """)
    suspend fun setAllRollsInactiveForCamera(cameraId: Long)

    suspend fun insertAndSetActive(roll: Roll) {
        setAllRollsInactiveForCamera(roll.cameraId)
        insert(roll)
    }
}
