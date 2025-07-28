package ca.florian.exif35.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase.Builder
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(context: Context): Builder<Exif35Database> {
    val dbFile = context.getDatabasePath("exif_35.db")
    return Room.databaseBuilder<Exif35Database>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}
