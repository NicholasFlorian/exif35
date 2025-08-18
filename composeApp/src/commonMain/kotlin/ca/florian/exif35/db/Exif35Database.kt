package ca.florian.exif35.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ca.florian.exif35.db.model.Camera
import ca.florian.exif35.db.model.CameraDao
import ca.florian.exif35.db.model.FilmRoll
import ca.florian.exif35.db.model.FilmRollDao
import ca.florian.exif35.db.model.Shot
import ca.florian.exif35.db.model.ShotDao

@Database(
    entities = [
        Camera::class,
        FilmRoll::class,
        Shot::class
    ],
    version = 1
)
abstract class Exif35Database : RoomDatabase(), DB {
    abstract fun cameraDao(): CameraDao
    abstract fun filmRollDao(): FilmRollDao
    abstract fun shotDao(): ShotDao
}

interface DB {
    fun clearAllTables(): Unit {}
}
