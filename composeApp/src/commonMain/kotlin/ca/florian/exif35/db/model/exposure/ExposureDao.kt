package ca.florian.exif35.db.model.exposure

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExposureDao {

    @Insert
    suspend fun insert(exposure: Exposure)

    @Query("SELECT * FROM exposures WHERE rollId = :rollId")
    fun getAllForRoll(rollId: Long): Flow<List<Exposure>>
}
