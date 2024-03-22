package com.woga.travelplan.ui.plan

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.writePlanScreen() {
    composable(
        route = "",
        arguments = listOf(
        ),
    ) {
        WritePlanScreen()
    }
}

@Composable
internal fun WritePlanScreen(
    viewModel: WritePlanViewModel = hiltViewModel(),
) {

}