package ca.florian.exif35.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.florian.exif35.db.model.Camera
import ca.florian.exif35.db.model.CameraDao
import kotlinx.coroutines.flow.SharingStarted.Companion.Lazily
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CameraListViewModel(
    private val cameraDao: CameraDao
) : ViewModel() {

    val cameras = cameraDao.getAll().stateIn(
        viewModelScope,
        started = Lazily,
        initialValue = emptyList()
    )

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
