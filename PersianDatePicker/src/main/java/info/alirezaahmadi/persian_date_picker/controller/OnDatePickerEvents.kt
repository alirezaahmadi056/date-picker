package info.alirezaahmadi.persian_date_picker.controller

interface OnDatePickerEvents {
    fun onDateChange(year: Int, month: Int, day: Int){}
    fun onClose() {}
    fun onConfirmButtonClick(year: Int, month: Int, day: Int)
    fun onGoToday(){}
}