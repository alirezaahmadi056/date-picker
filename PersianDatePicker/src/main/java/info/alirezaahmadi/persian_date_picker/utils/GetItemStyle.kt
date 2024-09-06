package info.alirezaahmadi.persian_date_picker.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import info.alirezaahmadi.persian_date_picker.model.PersianDatePickerThemeModel
import info.alirezaahmadi.persian_date_picker.model.PersianRangeDatePickerThemeModel

fun getTextColorDay(
    theme: PersianDatePickerThemeModel,
    isSelected: Boolean,
    isHoliday: Boolean,
    dayInMonth: Boolean
): Color {
    return when {
        isSelected -> theme.colorOfTheSelectedDayText
        isHoliday -> theme.holidayTextColor
        dayInMonth -> theme.daysExistsInMonthTextColor
        else -> theme.daysNotExistsInMonthTextColor
    }
}

fun getContainerColorDay(
    theme: PersianDatePickerThemeModel,
    isSelected: Boolean,
    isHoliday: Boolean,
    dayInMonth: Boolean
): Color {
    return when {
        isSelected -> theme.colorOfTheSelectedDayContainer
        isHoliday -> theme.holidayContainerColor
        dayInMonth -> theme.daysExistsInMonthContainerColor
        else -> theme.daysNotExistsInMonthContainerColor
    }
}

fun getContainerColorRangeDay(
    theme: PersianRangeDatePickerThemeModel,
    theStarterOrEnder: Boolean,
    theBetween: Boolean,
    isHoliday: Boolean,
    dayInMonth: Boolean
): Color {
    return when {
        theStarterOrEnder -> theme.colorOfTheSelectedDayContainer
        theBetween -> theme.colorOfBetweenSelectedDayContainer
        isHoliday -> theme.holidayContainerColor
        dayInMonth -> theme.daysExistsInMonthContainerColor
        else -> theme.daysNotExistsInMonthContainerColor
    }
}

fun getTextColorRangeDay(
    theme: PersianRangeDatePickerThemeModel,
    theStarterOrEnder: Boolean,
    theBetween: Boolean,
    isHoliday: Boolean,
    dayInMonth: Boolean
): Color {
    return when {
        theStarterOrEnder -> theme.colorOfTheSelectedDayText
        theBetween -> theme.colorOfBetweenSelectedDayText
        isHoliday -> theme.holidayTextColor
        dayInMonth -> theme.daysExistsInMonthTextColor
        else -> theme.daysNotExistsInMonthTextColor
    }
}

fun getItemShape(theStarter: Boolean, theEnder: Boolean, theBetween: Boolean): Shape {
    return when {
        theStarter -> RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp)
        theEnder -> RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
        theBetween -> RoundedCornerShape(0)
        else -> RoundedCornerShape(100)
    }
}
