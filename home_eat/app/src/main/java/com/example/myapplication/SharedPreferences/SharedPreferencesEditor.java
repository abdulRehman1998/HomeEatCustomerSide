package com.example.myapplication.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesEditor {

    /* SHARED PREFERENCES CONSTANTS */
    private final String PREF_SYNC_REQUIRED = "syncRequired";
    private final String PREF_USER_ID = "user_id";
    /* APPLICATION CONSTANTS */
    private final String PREF_FILE_APP = "ApplicationDetails";

    private final String PREF_LOGGED_IN = "loggedIn";
    private final String PREF_MOBILE_NO = "mobileNo";
    private final String PREF_SERVER_KEY = "serverKey";
    private final String PREF_PASS = "password";
    private final String PREF_TO_BE_VERIFIED = "verified";
    private final String PREF_FIRST_TIME_LOGIN = "firstTimeLogin";

    private Context mContext = null;

    public SharedPreferencesEditor(Context context) {
        this.mContext = context;
    }

    public void clearPreferences(){
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
        editor.clear().commit();

    }
    public boolean getSyncRequired() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            boolean value = sharedPreferences.getBoolean(PREF_SYNC_REQUIRED, true);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean setSyncRequired(boolean syncRequired) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putBoolean(PREF_SYNC_REQUIRED, syncRequired);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getUserORDER() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            String value = sharedPreferences.getString(PREF_USER_ID, "");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "User not found";
        }
    }

    public boolean setUserORDER(String value) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putString(PREF_USER_ID, value);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public String getUserID() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            String value = sharedPreferences.getString(PREF_USER_ID, "");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "User not found";
        }
    }

    public boolean setUserID(String value) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putString(PREF_USER_ID, value);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean IsLoggedIn() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            boolean value = sharedPreferences.getBoolean(PREF_LOGGED_IN, false);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    public boolean setLoggedIn(boolean syncRequired) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putBoolean(PREF_LOGGED_IN, syncRequired);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String getMobileNo() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            String value = sharedPreferences.getString(PREF_MOBILE_NO, "");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public boolean setMobileNo(String value) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putString(PREF_MOBILE_NO, value);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String getServerKey() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            String value = sharedPreferences.getString(PREF_SERVER_KEY, "");

            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public boolean setServerKey(String value) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putString(PREF_SERVER_KEY, value);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPass() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            String value = sharedPreferences.getString(PREF_PASS, "");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public boolean setPass(String value) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putString(PREF_PASS, value);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean IsToBeVerified() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            boolean value = sharedPreferences.getBoolean(PREF_TO_BE_VERIFIED, false);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    public boolean setToBeVerified(boolean syncRequired) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putBoolean(PREF_TO_BE_VERIFIED, syncRequired);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean firstTimeLogin() {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE);
            boolean value = sharedPreferences.getBoolean(PREF_FIRST_TIME_LOGIN, false);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    public boolean setFirstTimeLogin(boolean firstTimeLogin) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(PREF_FILE_APP, Context.MODE_PRIVATE).edit();
            editor.putBoolean(PREF_FIRST_TIME_LOGIN, firstTimeLogin);
            return editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
