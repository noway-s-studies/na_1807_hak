package eu.artouch.ah02.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.preference.CheckBoxPreference
import android.support.v7.preference.PreferenceFragmentCompat
import  eu.artouch.ah02.R

class SettingsFragment : PreferenceFragmentCompat() {

    companion object {
        val ID_TAG = SettingsFragment::class.java.simpleName
    }

    var orderButtonAllowedPreference: CheckBoxPreference? = null

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.app_settings)

        setPreferences()
    }

    private fun setPreferences() {
        orderButtonAllowedPreference = findPreference(getString(R.string.preference_order_button)) as CheckBoxPreference

        orderButtonAllowedPreference?.isChecked = SettingsPreferences().getOrderButtonAllowed(activity as AppCompatActivity)
        orderButtonAllowedPreference?.onPreferenceChangeListener = android.support.v7.preference.Preference.OnPreferenceChangeListener { preference, any ->
            SettingsPreferences().setOrderButtonAllowed(activity as AppCompatActivity, !(preference as CheckBoxPreference).isChecked)
            true
        }
    }
}
