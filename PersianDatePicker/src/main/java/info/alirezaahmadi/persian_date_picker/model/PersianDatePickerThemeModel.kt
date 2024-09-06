package info.alirezaahmadi.persian_date_picker.model



import androidx.compose.ui.graphics.Color
import info.alirezaahmadi.persian_date_picker.R

data class PersianDatePickerThemeModel(
    val textColor: Color,
    val forwardIcon: Int,
    val backwardIcon: Int,
    val daysNotExistsInMonthContainerColor: Color,
    val daysNotExistsInMonthTextColor: Color,
    val daysExistsInMonthTextColor: Color,
    val daysExistsInMonthContainerColor: Color,
    val backgroundColor: Color,
    val holidayContainerColor: Color,
    val holidayTextColor: Color,
    val colorOfTheConfirmationButtonContainer: Color,
    val colorOfTheConfirmationButtonText: Color,
    val colorOfTheCloseButtonContainer: Color,
    val colorOfTheCloseButtonText: Color,
    val colorOfTheGoTodayButtonContainer: Color,
    val colorOfTheGoTodayButtonText: Color,
    val colorOfTheSelectedDayContainer: Color,
    val colorOfTheSelectedDayText:Color,
    val fontFamily: Int,
    val showButtons:Boolean,
    val closeIcon: Int
)

val PersianDatePickerDefault = PersianDatePickerThemeModel(
    textColor = Color.Black,
    backwardIcon = R.drawable.ic_backward,
    forwardIcon = R.drawable.ic_forward,
    daysNotExistsInMonthContainerColor = Color.White,
    daysNotExistsInMonthTextColor = Color(0xFFCCCCCC),
    daysExistsInMonthContainerColor = Color(0xFFF8F8FA),
    daysExistsInMonthTextColor = Color.Black,
    backgroundColor = Color.White,
    holidayContainerColor = Color(0xFFFFE2DC),
    holidayTextColor = Color(0xFFC20000),
    colorOfTheConfirmationButtonContainer = Color(0xFF2F80ED),
    colorOfTheConfirmationButtonText = Color.White,
    colorOfTheCloseButtonContainer = Color.White,
    colorOfTheCloseButtonText = Color(0xFFC20000),
    colorOfTheGoTodayButtonContainer = Color.White,
    colorOfTheGoTodayButtonText = Color(0xFF2F80ED),
    colorOfTheSelectedDayContainer = Color(0xFF2F80ED),
    fontFamily = R.font.font,
    colorOfTheSelectedDayText = Color.White,
    showButtons = true,
    closeIcon = R.drawable.ic_close
)

