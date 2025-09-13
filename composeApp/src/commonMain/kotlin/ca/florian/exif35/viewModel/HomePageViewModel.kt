package ca.florian.exif35.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.db.model.camera.CameraDao
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val cameraDao: CameraDao,
) : ViewModel() {

    val cameraGlances = cameraDao.getAllCameraGlances()

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
