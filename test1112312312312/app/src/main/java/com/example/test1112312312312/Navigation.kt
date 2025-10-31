package com.example.test1112312312312

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.test1112312312312.ui.menu.AnimationMenuScreen
import com.example.test1112312312312.ui.demo.*

@Composable
fun AnimationNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "menu") {
        composable("menu") { AnimationMenuScreen(onSelect = { navController.navigate(it) }) }
        composable("Scale Button") { ScaleButtonDemo(onBack = { navController.popBackStack() }) }
        composable("Animated Visibility") { AnimatedVisibilityDemo(onBack = { navController.popBackStack() }) }
        composable("Content Size") { AnimateContentSizeDemo(onBack = { navController.popBackStack() }) }
        composable("Color Change") { ColorChangeDemo(onBack = { navController.popBackStack() }) }
        composable("Infinite Loading") { InfiniteLoadingDemo(onBack = { navController.popBackStack() }) }
    }
}
