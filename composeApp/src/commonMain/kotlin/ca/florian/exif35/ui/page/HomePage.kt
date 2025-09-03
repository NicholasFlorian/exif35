package ca.florian.exif35.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ca.florian.exif35.db.model.camera.Camera
import ca.florian.exif35.ui.component.CameraCard
import ca.florian.exif35.ui.component.CameraDialog
import ca.florian.exif35.ui.component.Exif35Title
import ca.florian.exif35.ui.navigation.CameraRoute
import ca.florian.exif35.viewmodel.HomePageViewModel
import exif35.composeapp.generated.resources.Res
import exif35.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navController: NavController,
    homePageViewModel: HomePageViewModel = koinViewModel<HomePageViewModel>()
) {

    val cameraGlances = homePageViewModel.cameraGlances.collectAsStateWithLifecycle()

    val openCameraDialog = remember { mutableStateOf(false) }
    when {
        openCameraDialog.value -> {
            CameraDialog(
                onDismissRequest = { openCameraDialog.value = false },
                onConfirmation = { camera: Camera ->
                    homePageViewModel.addCamera(camera)
                    openCameraDialog.value = false
                }
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Exif35Title() },
                actions = {
                    IconButton(onClick = { openCameraDialog.value = true }) {
                        Icon(
                            painter = painterResource(Res.drawable.plus),
                            contentDescription = "Add Camera"
                        )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize(),
        ) {
            items(cameraGlances.value.size) { index ->
                val camera = cameraGlances.value[index]
                CameraCard(
                    onNavigateToCamera = { cameraId ->
                        navController.navigate(route = CameraRoute(cameraId))
                    },
                    onDeleteCamera = { camera ->
                        homePageViewModel.deleteCamera(camera)
                    },
                    cameraGlance = cameraInfo,
                )
            }
        }
    }
}

