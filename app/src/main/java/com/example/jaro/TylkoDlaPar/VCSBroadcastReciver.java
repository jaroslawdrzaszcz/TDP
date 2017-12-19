package com.example.jaro.TylkoDlaPar;

import android.app.usage.NetworkStats;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jaro on 02.12.17.
 */

public class VCSBroadcastReciver extends BroadcastReceiver {

    private static boolean online = true;

    public static final String TAG = VCSBroadcastReciver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = manager.getActiveNetworkInfo();
        if (ni == null || ni.getState() != NetworkInfo.State.CONNECTED) {
            Log.d(TAG,"There's no network connectivity");
            if(online)
                Toast.makeText(context, R.string.internetWarning, Toast.LENGTH_SHORT).show();
            online = false;
        } else {
            Log.d ( TAG, "Network"+ni.getTypeName ()+"connected" );
            if(!online)
                Toast.makeText(context, R.string.online, Toast.LENGTH_SHORT).show();
            online = true;
        }
    }
}
