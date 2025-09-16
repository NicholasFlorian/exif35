package ca.florian.exif35.di

import ca.florian.exif35.db.Exif35Database
import ca.florian.exif35.db.getExif35Database
import ca.florian.exif35.viewModel.CameraPageViewModel
import ca.florian.exif35.viewModel.HomePageViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule(),
            appModule()
        )
    }
}

fun appModule() = module {
    single { getExif35Database(get()) }
    single { get<Exif35Database>().cameraDao() }
    single { get<Exif35Database>().rollDao() }
    single { get<Exif35Database>().exposureDao() }

    single { HomePageViewModel(get()) }
    factory { CameraPageViewModel(get(), get(), get()) }
}

expect fun platformModule(): Module
