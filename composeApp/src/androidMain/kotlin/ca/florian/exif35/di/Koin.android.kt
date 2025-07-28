package ca.florian.exif35.di

import ca.florian.exif35.db.Exif35Database
import androidx.room.RoomDatabase.Builder
import ca.florian.exif35.db.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<Builder<Exif35Database>> { getDatabaseBuilder(get()) }
}
