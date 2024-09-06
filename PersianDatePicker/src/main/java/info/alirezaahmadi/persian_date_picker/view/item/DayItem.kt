package info.alirezaahmadi.persian_date_picker.view.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import info.alirezaahmadi.persian_date_picker.model.PersianDatePickerThemeModel
import info.alirezaahmadi.persian_date_picker.utils.getContainerColorDay
import info.alirezaahmadi.persian_date_picker.utils.getTextColorDay

@Composable
fun DayItem(
    theme:PersianDatePickerThemeModel,
    text: String,
    isSelected: Boolean,
    isHoliday: Boolean,
    dayInMonth: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(30.dp),
        colors = CardDefaults.cardColors(containerColor = getContainerColorDay(theme, isSelected, isHoliday, dayInMonth)),
        shape = RoundedCornerShape(100),
        onClick = onClick
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(theme.fontFamily)),
                color = getTextColorDay(theme, isSelected, isHoliday, dayInMonth)
            )
        }
    }
}

