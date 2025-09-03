package ca.florian.exif35.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.florian.exif35.db.model.GlanceDao
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.db.model.camera.CameraDao
import kotlinx.coroutines.flow.SharingStarted.Companion.Lazily
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val cameraDao: CameraDao,
    private val glanceDao: GlanceDao,
) : ViewModel() {

    val cameraGlances = glanceDao.getAllCameraGlances().stateIn(
        viewModelScope,
        Lazily, emptyList())

    fun addCamera(camera: Camera) {
        viewModelScope.launch {
            cameraDao.insert(camera)
        }
    }

    fun deleteCamera(camera: Camera) {
        viewModelScope.launch {
            cameraDao.delete(camera)
        }
    }

}
