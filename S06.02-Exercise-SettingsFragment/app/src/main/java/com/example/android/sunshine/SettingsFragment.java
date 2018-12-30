package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by Vicuko on 30/12/18.
 */

// Do steps 5 - 11 within SettingsFragment
// TODO (4) Create SettingsFragment and extend PreferenceFragmentCompat - Done

public class SettingsFragment extends PreferenceFragmentCompat implements
// TODO (10) Implement OnSharedPreferenceChangeListener from SettingsFragment - Done
        SharedPreferences.OnSharedPreferenceChangeListener {

    // TODO (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference - Done
    public void setPreferenceSummary(Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            /* For list preferences, look up the correct display value in
            the preference's entries list (since they have separate labels/values).*/
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            //For other preferences, set the summary to the value's simple string representation
            preference.setSummary(stringValue);
        }
    }

    // TODO (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource - Done
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);

        // Do step 9 within onCreatePreference
        // TODO (9) Set the preference summary on each preference that isn't a CheckBoxPreference - Done
        PreferenceScreen prefScreen = getPreferenceScreen();
        SharedPreferences sharedPreferences = prefScreen.getSharedPreferences();
        int count = prefScreen.getPreferenceCount();
        for (int i = 0; i<count;i++){
            Preference p = prefScreen.getPreference(i);
            if (!(p instanceof CheckBoxPreference)){
                String value = sharedPreferences.getString(p.getKey(),"");
                setPreferenceSummary(p, value);
            }
        }
    }

    // TODO (13) Unregister SettingsFragment (this) as a SharedPreferenceChangedListener in onStop
    @Override
    public void onStop() {
        super.onStop();
        /* Unregister the preference change listener */
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    // TODO (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart
    @Override
    public void onStart() {
        super.onStart();
        /* Register the preference change listener */
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    // TODO (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (null != preference) {
            if (!(preference instanceof CheckBoxPreference)) {
                setPreferenceSummary(preference, sharedPreferences.getString(key, ""));
            }
        }
    }


}
