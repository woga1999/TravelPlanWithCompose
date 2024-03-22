package com.woga.travelplan.ui

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope

@Stable
class TravelPlanState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope
) {
}