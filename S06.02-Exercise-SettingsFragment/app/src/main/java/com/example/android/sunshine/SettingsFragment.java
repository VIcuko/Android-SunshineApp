package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by Vicuko on 30/12/18.
 */
// Do steps 5 - 11 within SettingsFragment
// TODO (4) Create SettingsFragment and extend PreferenceFragmentCompat
public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);
    }
// TODO (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource

// TODO (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference

// TODO (10) Implement OnSharedPreferenceChangeListener from SettingsFragment

// Do step 9 within onCreatePreference
// TODO (9) Set the preference summary on each preference that isn't a CheckBoxPreference

// TODO (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed



}
