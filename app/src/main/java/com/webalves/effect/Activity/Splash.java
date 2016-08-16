package com.webalves.effect.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.webalves.effect.MainActivity;
import com.webalves.effect.R;
import com.webalves.effect.lib.Cons;
import com.webalves.effect.lib.storeSharedPref;

public class Splash extends Activity {
    public static storeSharedPref sharedpref;
    String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedpref = new storeSharedPref(this);
        a = sharedpref.getSharedValue(Cons.checked_status);

        Log.i("=========", "=====ch=====" + a);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (a.equalsIgnoreCase("checked")) {
                    sharedpref.storeSharedValue(Cons.login_first, "");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    startActivity(intent);
                }
            }
        }, 5000);

    }


}
