package info.alirezaahmadi.persian_date_picker.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.alirezaahmadi.persian_date_picker.model.PersianDatePickerModel
import ir.barbossa.composescrollpicker.PickerState
import ir.barbossa.composescrollpicker.ScrollPicker

@Composable
fun PersianYearAndMonthPickerView(
    yearPickerState: PickerState,
    monthPickerState: PickerState,
    dividerColor: Color,
    closeIcon: Int,
    colorOfTheConfirmationText: Color,
    colorOfTheConfirmationContainer: Color,
    textStyle: TextStyle,
    backgroundColor: Color,
    starterYear: Int,
    starterMonth: Int,
    onCloseClick: () -> Unit,
    onConfirmation: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .wrapContentWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = "انتخاب تاریخ", style = textStyle.copy(fontSize = 20.sp))
                IconButton(
                    modifier = Modifier.size(30.dp), onClick = onCloseClick
                ) {
                    Image(painter = painterResource(closeIcon), contentDescription = null)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
            ) {
                ScrollPicker(
                    modifier = Modifier.weight(1f),
                    state = yearPickerState,
                    items = PersianDatePickerModel.years.map { item -> item.toString() },
                    textModifier = Modifier.padding(8.dp),
                    dividerColor = dividerColor,
                    textStyle = textStyle,
                    startIndex = starterYear
                )
                ScrollPicker(
                    modifier = Modifier.weight(1f),
                    state = monthPickerState,
                    items = PersianDatePickerModel.month,
                    textModifier = Modifier.padding(8.dp),
                    dividerColor = dividerColor,
                    textStyle = textStyle,
                    startIndex = starterMonth
                )
            }
            Button(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 5.dp, horizontal = 10.dp),
                onClick = onConfirmation,
                colors = ButtonDefaults.buttonColors(containerColor = colorOfTheConfirmationContainer),
                contentPadding = PaddingValues(2.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "انتخاب", color = colorOfTheConfirmationText, style = TextStyle()
                )
            }
        }
    }
}