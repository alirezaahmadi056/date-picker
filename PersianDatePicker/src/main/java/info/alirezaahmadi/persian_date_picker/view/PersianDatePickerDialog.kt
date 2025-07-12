package info.alirezaahmadi.persian_date_picker.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import info.alirezaahmadi.persian_date_picker.controller.OnDatePickerEvents
import info.alirezaahmadi.persian_date_picker.model.PersianDatePickerDefault
import info.alirezaahmadi.persian_date_picker.model.PersianDatePickerModel
import info.alirezaahmadi.persian_date_picker.model.PersianDatePickerThemeModel
import info.alirezaahmadi.persian_date_picker.utils.DatePickerGenerator
import info.alirezaahmadi.persian_date_picker.view.item.DayItem
import ir.barbossa.composescrollpicker.rememberPickerState
import ir.huri.jcal.JalaliCalendar

@Composable
fun PersianDatePickerDialog(
    onDismissRequest: () -> Unit,
    theme: PersianDatePickerThemeModel = PersianDatePickerDefault,
    controller: OnDatePickerEvents
) {
    val jalaliCalendar = remember {
        JalaliCalendar()
    }
    val year = remember {
        mutableIntStateOf(jalaliCalendar.year)
    }
    val month = remember {
        mutableStateOf(jalaliCalendar.monthString)
    }
    val currentMonth = remember {
        mutableIntStateOf(jalaliCalendar.month)
    }
    val currentYear = remember {
        mutableIntStateOf(jalaliCalendar.year)
    }
    val numberOfMonth = remember {
        mutableIntStateOf(jalaliCalendar.month)
    }
    val stringBuilder = buildAnnotatedString {
        append(year.intValue.toString())
        append(month.value)
    }
    val daysList =
        DatePickerGenerator.instance.generateListForPersianDatePicker(
            year.intValue,
            numberOfMonth.intValue
        )

    val selectedDay = remember { mutableIntStateOf(jalaliCalendar.day) }
    val showYearAndMonthPicker = remember { mutableStateOf(false) }
    val yearPickerState = rememberPickerState()
    val monthPickerState = rememberPickerState()
    Dialog(onDismissRequest = onDismissRequest) {
        if (!showYearAndMonthPicker.value) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .heightIn(200.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(theme.backgroundColor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                        .padding(10.dp)
                        .verticalScroll(
                            rememberScrollState()
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                if (numberOfMonth.intValue != 12) {
                                    numberOfMonth.intValue += 1
                                    jalaliCalendar.month = numberOfMonth.intValue
                                    month.value = jalaliCalendar.monthString
                                } else {
                                    year.intValue += 1
                                    numberOfMonth.intValue = 1
                                    jalaliCalendar.month = numberOfMonth.intValue
                                    jalaliCalendar.year = year.intValue
                                    month.value = jalaliCalendar.monthString
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(theme.forwardIcon),
                                contentDescription = "forward icon"
                            )

                        }
                        Text(
                            modifier = Modifier.clickable {
                                showYearAndMonthPicker.value = true
                            },
                            text = stringBuilder,
                            color = theme.textColor,
                            fontFamily = FontFamily(Font(theme.fontFamily))
                        )
                        IconButton(
                            onClick = {
                                if (numberOfMonth.intValue != 1) {
                                    numberOfMonth.intValue -= 1
                                    jalaliCalendar.month = numberOfMonth.intValue
                                    month.value = jalaliCalendar.monthString
                                } else {
                                    year.intValue -= 1
                                    numberOfMonth.intValue = 12
                                    jalaliCalendar.month = numberOfMonth.intValue
                                    jalaliCalendar.year = year.intValue
                                    month.value = jalaliCalendar.monthString
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(theme.backwardIcon),
                                contentDescription = "backward icon"
                            )
                        }
                    }
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                                .heightIn(max = LocalConfiguration.current.screenHeightDp.dp),
                            columns = GridCells.Fixed(7),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            items(PersianDatePickerModel.daysName.size) { index ->
                                Text(
                                    text = PersianDatePickerModel.daysName[index],
                                    fontFamily = FontFamily(Font(theme.fontFamily)),
                                    textAlign = TextAlign.Center
                                )
                            }
                            items(daysList.size) { index ->
                                DayItem(
                                    theme = theme,
                                    text = daysList[index].dayNumber.toString(),
                                    isSelected = daysList[index].isSelectedDay(selectedDay.intValue) && daysList[index].dayInMonth,
                                    isHoliday = daysList[index].isHoliday,
                                    dayInMonth = daysList[index].dayInMonth
                                ) {
                                    if (daysList[index].dayInMonth) {
                                        selectedDay.intValue = daysList[index].dayNumber
                                        controller.onDateChange(
                                            year.intValue,
                                            numberOfMonth.intValue,
                                            selectedDay.intValue
                                        )
                                    }
                                }
                            }
                        }
                    }
                    if (theme.showButtons) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row {
                                Button(
                                    onClick = {
                                        controller.onConfirmButtonClick(
                                            year.intValue,
                                            numberOfMonth.intValue,
                                            selectedDay.intValue
                                        )
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = theme.colorOfTheConfirmationButtonContainer),
                                    contentPadding = PaddingValues(2.dp),
                                    shape = RoundedCornerShape(5.dp)
                                ) {
                                    Text(
                                        text = "انتخاب",
                                        color = theme.colorOfTheConfirmationButtonText,
                                        fontFamily = FontFamily(Font(theme.fontFamily)),
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                                Button(
                                    onClick = {
                                        controller.onClose()
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = theme.colorOfTheCloseButtonContainer),
                                    contentPadding = PaddingValues(2.dp),
                                    shape = RoundedCornerShape(5.dp)
                                ) {
                                    Text(
                                        text = "انصراف",
                                        color = theme.colorOfTheCloseButtonText,
                                        fontFamily = FontFamily(Font(theme.fontFamily)),
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                            Button(
                                onClick = {
                                    jalaliCalendar.month = currentMonth.intValue
                                    jalaliCalendar.year = currentYear.intValue
                                    year.intValue = jalaliCalendar.year
                                    numberOfMonth.intValue = jalaliCalendar.month
                                    month.value = jalaliCalendar.monthString
                                    selectedDay.intValue = jalaliCalendar.day
                                    controller.onGoToday()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = theme.colorOfTheGoTodayButtonContainer),
                                contentPadding = PaddingValues(2.dp),
                                shape = RoundedCornerShape(5.dp)
                            ) {
                                Text(
                                    text = "امروز",
                                    color = theme.colorOfTheGoTodayButtonText,
                                    fontFamily = FontFamily(Font(theme.fontFamily)),
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }
                    }
                }
            }
        } else {
            PersianYearAndMonthPickerView(
                yearPickerState = yearPickerState,
                monthPickerState = monthPickerState,
                closeIcon = theme.closeIcon,
                dividerColor = theme.colorOfTheSelectedDayContainer,
                colorOfTheConfirmationContainer = theme.colorOfTheSelectedDayContainer,
                colorOfTheConfirmationText = theme.colorOfTheSelectedDayText,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(theme.fontFamily)),
                    color = theme.textColor,
                    fontWeight = FontWeight.Black
                ),
                backgroundColor = theme.backgroundColor,
                starterYear = jalaliCalendar.year - 1200,
                starterMonth = jalaliCalendar.month - 1,
                onCloseClick = {
                    showYearAndMonthPicker.value = false
                },
                onConfirmation = {
                    year.intValue = yearPickerState.selectedItem.value.toInt()
                    month.value = monthPickerState.selectedItem.value
                    numberOfMonth.intValue =
                        PersianDatePickerModel.month.indexOf(monthPickerState.selectedItem.value) + 1
                    jalaliCalendar.year = year.intValue
                    jalaliCalendar.month = numberOfMonth.intValue
                    selectedDay.intValue = jalaliCalendar.day
                    showYearAndMonthPicker.value = false

                })
        }
    }
}
