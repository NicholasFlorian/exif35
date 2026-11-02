package ca.florian.exif35.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ca.florian.exif35.ui.elements.CameraTitle
import ca.florian.exif35.ui.component.RollDialog
import ca.florian.exif35.ui.component.RollInfo
import ca.florian.exif35.viewModel.CameraPageViewModel
import exif35.composeapp.generated.resources.Res
import exif35.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraPage(
    navController: NavController,
    cameraId: Long,
    viewModel: CameraPageViewModel = koinViewModel<CameraPageViewModel>()
) {

    LaunchedEffect(
        key1 = cameraId,
        block = {
            viewModel.setCameraId(cameraId)
        }
    )

    val camera by viewModel.cameraState.collectAsState(null)
    val rollGlances by viewModel.rollsState.collectAsState(emptyList())

    var openRollDialog by remember { mutableStateOf(false) }
    if (openRollDialog) {
        RollDialog(
            onDismissRequest = { openRollDialog = false },
            onConfirmation = {
                viewModel.addRoll(it)
                openRollDialog = false
            }
        )
    }

    var expandedRolls by remember { mutableStateOf(emptySet<Long>())}
    fun toggleRollExpanded(rollId: Long) {
        expandedRolls = if (expandedRolls.contains(rollId)) {
            expandedRolls - rollId
        } else {
            expandedRolls + rollId
        }
    }

    fun saveExposure(rollId: Long, title: String) {
        viewModel.addExposure(rollId, title)
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
                },
                actions = {
                    IconButton(onClick = { openRollDialog = true }) {
                        Icon(
                            painter = painterResource(Res.drawable.plus),
                            contentDescription = "Add Roll"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues
        ) {
            items(
                items = rollGlances,
                key = { rollGlance -> rollGlance.getId() }
            ) { rollGlance ->
                val isExpanded = expandedRolls.contains(rollGlance.getId())
                RollInfo(
                    lazyListScope = this@LazyColumn,
                    rollGlance,
                    isExpanded,
                    onToggleExpanded = { toggleRollExpanded(rollGlance.getId()) },
                    onSaveExposure = { title -> saveExposure( rollGlance.getId(), title) },
                )
            }
        }
    }
}
