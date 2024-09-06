package info.alirezaahmadi.persian_date_picker.controller

fun interface OnRangeDatePickerEvents {
    fun onDateChange(year: Int, month: Int, day: ArrayList<Int>) {}
    fun onClose() {}
    fun onConfirmButtonClick(year: Int, month: Int, day: List<Int>)
    fun onGoToday() {}
}