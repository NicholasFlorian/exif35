package ca.florian.exif35.di

import ca.florian.exif35.db.Exif35Database
import ca.florian.exif35.viewmodel.CameraListViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule())
    }
}

fun appModule() = listOf(
    platformModule(),
    daoModule(),
    viewModelModule()
)

expect fun platformModule(): Module

fun daoModule() = module {
    single { get<Exif35Database>().cameraDao() }
    single { get<Exif35Database>().filmRollDao() }
    single { get<Exif35Database>().shotDao() }
}

fun viewModelModule() = module {
    single { CameraListViewModel(get()) }
}
