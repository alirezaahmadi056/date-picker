# ScreenShot
<img src=".github/screenshot.jpg" width="350"/>

## develop by :  @barbossa-dev

# Setup
Add the JitPack repository to settings.gradle file
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...      
        maven(url = "https://jitpack.io")
    }
}
```

Add the dependencies to app-level build.gradle file
```gradle
dependencies {
    ...
    implementation("com.github.alirezaahmadi056:date-picker:0.0.7")
}
```
# Example Date Picker
```kotlin
var state by remember { mutableStateOf(false) }
PersianDatePickerDialog(
    onDismissRequest = { state = false },
    controller = object : OnDatePickerEvents {
        override fun onConfirmButtonClick(year: Int, month: Int, day: Int) {
            Log.i("result", "onConfirmButtonClick: ${day}")
        }

        override fun onClose() {
            state = false
        }

        override fun onGoToday() {
            super.onGoToday()
        }

        override fun onDateChange(year: Int, month: Int, day: Int) {
            super.onDateChange(year, month, day)
        }
    }
)
```

# Example Range Date Picker
```kotlin
PersianRangeDatePickerDialog(onDismissRequest = {
    state = false
}, controller = object : OnRangeDatePickerEvents{
    override fun onConfirmButtonClick(
        year: Int,
        month: Int,
        day: List<Int>
    ) {

    }

    override fun onClose() {
        super.onClose()
    }

    override fun onGoToday() {
        super.onGoToday()
    }

    override fun onDateChange(year: Int, month: Int, day: ArrayList<DayInfoModel>) {
        super.onDateChange(year, month, day)
    }
})
```


