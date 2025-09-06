package ca.florian.exif35.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.db.model.camera.CameraDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class CameraPageViewModel(
    private val cameraDao: CameraDao,
) : ViewModel() {

    private val _cameraId = MutableStateFlow<Long?>(null)

    val cameraState: Flow<Camera?> = _cameraId.flatMapLatest { id ->
        if (id == null) {
            MutableStateFlow(null)
        } else {
            cameraDao.getCameraById(id)
        }
    }

    fun setCameraId(id: Long) {
        _cameraId.value = id
    }

    fun update(camera: Camera) = viewModelScope.launch {
        cameraDao.update(camera)
    }

    fun delete(camera: Camera) = viewModelScope.launch {
        cameraDao.delete(camera)
    }
}
