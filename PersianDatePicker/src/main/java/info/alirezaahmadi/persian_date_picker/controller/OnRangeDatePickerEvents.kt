package info.alirezaahmadi.persian_date_picker.controller

import info.alirezaahmadi.persian_date_picker.model.DayInfoModel

fun interface OnRangeDatePickerEvents {
    fun onDateChange(year: Int, month: Int, days: ArrayList<DayInfoModel>) {}
    fun onClose() {}
    fun onConfirmButtonClick(year: Int, month: Int, day: List<Int>)
    fun onGoToday() {}
}