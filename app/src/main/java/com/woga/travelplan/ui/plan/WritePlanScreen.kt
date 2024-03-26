package com.woga.travelplan.ui.plan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var selectedDate by remember { mutableIntStateOf(1) }
    var selectedCity by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // 상단 영역: 날짜와 도시 선택
        TopSection(selectedDate = selectedDate, selectedCity = selectedCity,
            onDateSelected = { date -> selectedDate = date },
            onCitySelected = { city -> selectedCity = city })

        // 하단 영역: 선택된 날짜에 따른 여행 일정 리스트
        ScheduleList(selectedDate = selectedDate)
    }
}

@Composable
fun TopSection(
    selectedDate: Int,
    selectedCity: String,
    onDateSelected: (Int) -> Unit,
    onCitySelected: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // 날짜 선택
        DatePicker(selectedDate = selectedDate, onDateSelected = onDateSelected)

        Spacer(modifier = Modifier.height(16.dp))

        // 도시 선택
        CityPicker(selectedCity = selectedCity, onCitySelected = onCitySelected)
    }
}

@Composable
fun DatePicker(selectedDate: Int, onDateSelected: (Int) -> Unit) {
    // 날짜 선택 UI
    Button(onClick = { /* 날짜 선택 다이얼로그 표시 */ }) {
        Text("Day $selectedDate")
    }
}

@Composable
fun CityPicker(selectedCity: String, onCitySelected: (String) -> Unit) {
    // 도시 선택 UI
    Button(onClick = { /* 도시 선택 다이얼로그 표시 */ }) {
        Text("Selected City: $selectedCity")
    }
}

@Composable
fun ScheduleList(selectedDate: Int) {
    // 선택된 날짜에 따라 해당 날짜의 여행 일정을 표시하는 리스트
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(5) { index ->
            Text(text = "Day $selectedDate - Schedule Item $index", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTripPlannerScreen() {
    WritePlanScreen()
}