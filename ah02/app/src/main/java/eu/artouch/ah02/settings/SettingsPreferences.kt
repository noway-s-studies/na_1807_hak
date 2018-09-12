package eu.artouch.ah02.settings

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity

class SettingsPreferences {

    private fun getPreferences(activity: AppCompatActivity): SharedPreferences {
        return activity.getSharedPreferences(activity.applicationInfo.packageName, Context.MODE_PRIVATE)
    }

    fun getOrderButtonAllowed(activity: AppCompatActivity): Boolean {
        return getPreferences(activity).getBoolean(PreferenceConstants(activity).ORDER_BUTTON_ALLOWED, false)
    }

    fun setOrderButtonAllowed(activity: AppCompatActivity, isAllowed: Boolean) {
        getPreferences(activity).edit().putBoolean(PreferenceConstants(activity).ORDER_BUTTON_ALLOWED, isAllowed).apply()
    }
}