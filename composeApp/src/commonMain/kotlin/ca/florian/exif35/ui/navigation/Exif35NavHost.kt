package ca.florian.exif35.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ca.florian.exif35.ui.page.HomePage
import ca.florian.exif35.ui.page.CameraPage

@Composable
fun Exif35NavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController = navController)
        }
        composable<CameraRoute> { backStackEntry ->
            val cameraRoute = backStackEntry.toRoute<CameraRoute>()
            CameraPage(
                navController = navController,
                cameraId = cameraRoute.cameraId
            )
        }
    }
}
