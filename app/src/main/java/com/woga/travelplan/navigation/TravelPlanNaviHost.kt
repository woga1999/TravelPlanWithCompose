package com.woga.travelplan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.woga.travelplan.ui.TravelPlanState
import com.woga.travelplan.ui.plan.writePlanScreen

@Composable
fun TravelPlanNaviHost(
    appState: TravelPlanState
) {
    val navController = appState.navController

    NavHost(navController = navController, startDestination = "") {
        writePlanScreen()
    }
}