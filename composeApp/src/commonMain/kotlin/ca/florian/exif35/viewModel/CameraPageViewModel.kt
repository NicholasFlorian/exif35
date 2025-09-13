package ca.florian.exif35.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.db.model.camera.CameraDao
import ca.florian.exif35.db.model.roll.Roll
import ca.florian.exif35.db.model.roll.RollDao
import ca.florian.exif35.db.model.roll.RollGlance
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class CameraPageViewModel(
    private val cameraDao: CameraDao,
    private val rollDao: RollDao
) : ViewModel() {

    private val _cameraId = MutableStateFlow<Long?>(null)

    val cameraState: Flow<Camera?> = _cameraId.flatMapLatest { id ->
        if (id == null) {
            MutableStateFlow(null)
        } else {
            cameraDao.getCameraById(id)
        }
    }

    val rollsState: Flow<List<RollGlance>> = _cameraId.flatMapLatest { id ->
        if (id == null) {
            MutableStateFlow(emptyList())
        } else {
            rollDao.getRollGlancesForCamera(id)
        }
    }

    fun setCameraId(id: Long) {
        _cameraId.value = id
    }

    fun addRoll(roll: Roll) = viewModelScope.launch {
        _cameraId.value?.let {
            rollDao.insertAndSetActive(roll.copy(cameraId = it, isActive = true))
        }
    }

    fun setActiveRoll(roll: Roll) = viewModelScope.launch {
        _cameraId.value?.let {
            rollDao.setAllRollsInactiveForCamera(it)
            rollDao.update(roll.copy(isActive = true))
        }
    }

    fun update(camera: Camera) = viewModelScope.launch {
        cameraDao.update(camera)
    }

    fun delete(camera: Camera) = viewModelScope.launch {
        cameraDao.delete(camera)
    }
}
