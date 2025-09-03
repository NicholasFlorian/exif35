package ca.florian.exif35.ui.page

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.ui.component.CameraTitle
import ca.florian.exif35.viewmodel.HomePageViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraPage(
    navController: NavController,
    cameraId: Long,
    viewModel: HomePageViewModel = koinViewModel<HomePageViewModel>()
) {
    var camera by remember { mutableStateOf<Camera?>(null) }

    LaunchedEffect(cameraId) {
        camera = viewModel.getCameraById(cameraId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    camera?.let {
                        CameraTitle(camera = it)
                    } ?: Text("Camera not found")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text("Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        // Content of the camera overview page can be added here
    }
}
