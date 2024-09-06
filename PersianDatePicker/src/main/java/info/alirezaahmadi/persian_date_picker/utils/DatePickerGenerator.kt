package info.alirezaahmadi.persian_date_picker.utils

import android.icu.util.Calendar
import android.util.Log
import info.alirezaahmadi.persian_date_picker.model.DayInfoModel
import ir.huri.jcal.JalaliCalendar

class DatePickerGenerator private constructor() {
    companion object {
        val instance by lazy { DatePickerGenerator() }
    }

    private fun getDaysOfMonth(month: Int, isLeap: Boolean): Int {
        return when (month) {
            in 1..6 -> 31
            in 7..11 -> 30
            else -> {
                if (isLeap) {
                    30
                } else {
                    29
                }
            }
        }
    }

    fun generateListForPersianDatePicker(year: Int, month: Int): ArrayList<DayInfoModel> {
        val jalaliCalendar = JalaliCalendar().apply {
            this.year = year
            this.month = month
        }
        val currentDaysOfMonth = getDaysOfMonth(jalaliCalendar.month, jalaliCalendar.isLeap)
        var previousDaysOfMonth = getDaysOfMonth(jalaliCalendar.month - 1, jalaliCalendar.isLeap)
        var nextDaysOfMonth = 1
        val daysList = ArrayList<DayInfoModel>()
        jalaliCalendar.day = 1
        for (i in 1..jalaliCalendar.dayOfWeek) {
            daysList.add(DayInfoModel(false, previousDaysOfMonth, false))
            previousDaysOfMonth -= 1
        }
        daysList.reverse()
        for (i in 1..currentDaysOfMonth) {
            jalaliCalendar.day = i
            val isHoliday = jalaliCalendar.dayOfWeek == Calendar.FRIDAY
            daysList.add(DayInfoModel(isHoliday, i, true))
        }
        if (jalaliCalendar.dayOfWeek != Calendar.FRIDAY) {
            jalaliCalendar.day = currentDaysOfMonth
            for (i in (if (jalaliCalendar.dayOfWeek == 7) 0 else jalaliCalendar.dayOfWeek) ..<6) {
                daysList.add(DayInfoModel(false, nextDaysOfMonth, false))
                nextDaysOfMonth += 1
            }
        }
        return daysList
    }
}