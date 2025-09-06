package ca.florian.exif35.db.model.roll

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface RollDao {
    @Insert
    suspend fun insert(negative: Roll)

    @Transaction
    @Query("SELECT * FROM rolls WHERE id = :rollId")
    fun getRollGlanceById(rollId: Long) : Flow<RollGlance>

    @Query("SELECT * FROM rolls WHERE id = :rollId")
    fun getRollGlance(rollId: Long): Flow<RollGlance>

    @Query("SELECT * FROM rolls WHERE cameraId = :cameraId AND inUse = TRUE LIMIT 1")
    suspend fun getInUseRollForCamera(cameraId: Long): Roll?
}
