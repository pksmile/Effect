package com.webalves.effect.lib;

/**
 * Created by WebM on 8/8/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

public class storeSharedPref {
    public static final String MyPREFERENCES = "MyPrefs";
    public static Context _ctx;
    SharedPreferences sharedpreferences;
    Editor editor;

    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    //Email Address
    public static final String KEY_EMAIL = "email";
    public storeSharedPref(Context ctx) {
        _ctx = ctx;

    }

    public void storeSharedValue(String key, String value)

    {
        SharedPreferences sharedpreferences = _ctx.getSharedPreferences(
                MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.commit();

    }

    public void resetValues() {

        SharedPreferences sharedpreferences = _ctx.getSharedPreferences(
                MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = sharedpreferences.edit();
        editor.clear().commit();
        editor.commit();

    }

    public void storeSharedValue(String key, Boolean value)

    {
        SharedPreferences sharedpreferences = _ctx.getSharedPreferences(
                MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }

    public String getSharedValue(String key) {

        SharedPreferences sharedpreferences = _ctx.getSharedPreferences(
                MyPREFERENCES, Context.MODE_PRIVATE);

        // sharedpreferences.getString(key, "0");

        return sharedpreferences.getString(key, "0");
    }


    public void createUserLoginSession(String email) {
        // Storing login value as TRUE
        editor.putBoolean(IS_USER_LOGIN, true);
        //Storing email in pref
        editor.putString(KEY_EMAIL, email);
        //editor.putBoolean(IS_USER_LOGIN,true);
        editor.commit();
    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else do anything
     */

    public boolean checkLogin() {
        // Check login status
        if (!this.isUserLoggedIn()) {

            // user is not logged in redirect him to Login Activity
		/*	Intent i = new Intent(_ctx, LoginActivity.class);

			// Staring Login Activity
			_ctx.startActivity(i);*/

            return true;
        }
        return false;
    }

    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {

        //Use hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();

        // user email id
        user.put(KEY_EMAIL, sharedpreferences.getString(KEY_EMAIL, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {

        // Clearing all user data from Shared Preferences

        resetValues();
	/*	editor.clear();
		editor.commit();*/

        // After logout redirect user to Login Activity
/*		Intent i = new Intent(_ctx, Sign_In_Page.class);

		// Staring Login Activity
		_ctx.startActivity(i);*/
    }

    // Check for login
    public boolean isUserLoggedIn() {
        return sharedpreferences.getBoolean(IS_USER_LOGIN, false);
    }
}