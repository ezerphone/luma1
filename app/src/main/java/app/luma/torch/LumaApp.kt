package app.luma.torch

import android.app.Application
import android.os.Process
import android.util.Log

// נקודת הבדיקה היחידה של הקושחה. Application נוצר לפני כל Activity, Service ו-Receiver,
// כך שבקושחה לא מקורית שום חלק באפליקציה לא מגיע לרוץ.
class LumaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (!FirmwareGuard.isGenuine()) {
            Log.e("Luma", "קובץ ההרשאות של הקושחה לא נמצא: האפליקציה נסגרת")
            Process.killProcess(Process.myPid())
        }
    }
}
