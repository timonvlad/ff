package com.example.shprefbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;

public class InternetReceiver extends BroadcastReceiver{

	private boolean screenOff;
	Time today;
    
    
    @Override
    public void onReceive(Context context, Intent intent) {
    	Intent nextScreen = new Intent(context, ShPrefActivity.class);
        nextScreen.putExtra("name", "name");
        nextScreen.putExtra("email", ";laskfj;aslfkj");
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(nextScreen);
    //	Intent i = new Intent(context, ShPrefActivity.class);
    	
      
    }

}
