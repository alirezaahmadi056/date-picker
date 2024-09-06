package info.alirezaahmadi.persian_date_picker.model

data class DayInfoModel(
    val isHoliday: Boolean,
    val dayNumber: Int,
    val dayInMonth:Boolean
) {
    fun isSelectedDay(index: Int): Boolean{
        return this.dayNumber == index
    }
}
