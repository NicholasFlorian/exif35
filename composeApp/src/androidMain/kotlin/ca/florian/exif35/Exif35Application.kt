package ca.florian.exif35

import android.app.Application
import ca.florian.exif35.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class Exif35Application: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@Exif35Application)
        }
    }
}
