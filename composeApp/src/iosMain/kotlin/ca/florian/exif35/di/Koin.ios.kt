package ca.florian.exif35.di

import ca.florian.exif35.db.Exif35Database
import ca.florian.exif35.db.getDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        getDatabase()
    }
}
