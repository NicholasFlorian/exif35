package ca.florian.exif35.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.florian.exif35.ui.page.CameraListPage

@Composable
fun Exif35NavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cameraList") {
        composable("cameraList") {
            CameraListPage()
        }
    }
}
