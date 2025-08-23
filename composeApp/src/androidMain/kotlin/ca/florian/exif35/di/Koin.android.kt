package ca.florian.exif35.di

import ca.florian.exif35.db.getDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single { getDatabaseBuilder(androidContext()) }
}
