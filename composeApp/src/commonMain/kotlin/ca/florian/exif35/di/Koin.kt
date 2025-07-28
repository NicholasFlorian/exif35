package ca.florian.exif35.di

import ca.florian.exif35.db.Exif35Database
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import androidx.room.RoomDatabase.Builder

import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin() {
    startKoin {
        modules(commonModule, platformModule())
    }
}

val commonModule = module {
    single { get<Builder<Exif35Database>>().build() }
    single { get<Exif35Database>().cameraDao() }
    single { get<Exif35Database>().filmRollDao() }
    single { get<Exif35Database>().shotDao() }
}
