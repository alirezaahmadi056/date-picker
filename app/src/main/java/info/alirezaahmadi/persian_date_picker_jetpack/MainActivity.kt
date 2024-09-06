package info.alirezaahmadi.persian_date_picker_jetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.alirezaahmadi.persian_date_picker.controller.OnDatePickerEvents
import info.alirezaahmadi.persian_date_picker.controller.OnRangeDatePickerEvents
import info.alirezaahmadi.persian_date_picker.view.PersianDatePickerDialog
import info.alirezaahmadi.persian_date_picker.view.PersianRangeDatePickerDialog
import info.alirezaahmadi.persian_date_picker_jetpack.ui.theme.PersianDatePickerJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val showRangeDatePicker = remember {
                mutableStateOf(false)
            }
            val showDatePicker = remember {
                mutableStateOf(false)
            }
            PersianDatePickerJetpackTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(50.dp),
                        text = "Produced by lrn.ir",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black
                    )
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            showDatePicker.value = true
                        }) {
                            Text(text = "open date picker")
                        }
                        Button(onClick = {
                            showRangeDatePicker.value = true
                        }) {
                            Text(text = "open range date picker")
                        }
                    }
                    if (showDatePicker.value) {
                        PersianDatePickerDialog(
                            onDismissRequest = { showDatePicker.value = false },
                            controller = object : OnDatePickerEvents {
                                override fun onConfirmButtonClick(year: Int, month: Int, day: Int) {
                                    Log.i("jjjj", "onConfirmButtonClick: ${day}")
                                }

                                override fun onClose() {
                                    showDatePicker.value = false
                                }

                                override fun onGoToday() {
                                    super.onGoToday()
                                }

                                override fun onDateChange(year: Int, month: Int, day: Int) {
                                    super.onDateChange(year, month, day)
                                }
                            }
                        )
                    }
                    if (showRangeDatePicker.value) {
                        PersianRangeDatePickerDialog(onDismissRequest = {
                            showRangeDatePicker.value = false
                        }, controller = object : OnRangeDatePickerEvents{
                            override fun onConfirmButtonClick(
                                year: Int,
                                month: Int,
                                day: List<Int>
                            ) {
                                for(days in day){
                                    Log.i("jjj", "onConfirmButtonClick: ${days}")
                                }
                            }
                        })
                    }
                }
            }
        }
    }


}
