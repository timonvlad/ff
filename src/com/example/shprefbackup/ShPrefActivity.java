package com.example.shprefbackup;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.PowerManager;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class ShPrefActivity extends Activity {
	
	Button backup;
	final String[] su = {"su"};
	final String[] copyToBackup = { "dd if=/data/data/com.navjagpal.fileshare/databases/file_sharer.db of=/mnt/sdcard/file_sharer.db" };
	final String[] chmodBackup = {"chmod 666 /data/data/com.navjagpal.fileshare/databases/file_sharer.db"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sh_pref);
        
        backup = (Button) findViewById(R.id.backup);
        backup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			//	execCommand(su);
				//sleep(300);
			//	execCommand(chmodBackup);
			//	sleep(300);
			//	execCommand(copyToBackup);
			//	sleep(300);
				
				
			//******	ExEc();
			//	reboot();
				iwlist();
		//		execCommand("");
			//**	PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			//**	pm.reboot("recovery");
			}
		});
    }
    private void shutdown() {
		try {
			Process process = Runtime.getRuntime().exec("su");
			DataOutputStream out = new DataOutputStream(
					process.getOutputStream());
			out.writeBytes("input keyevent 9\n");
			out.writeBytes("exit\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
    private void iwlist() {
		try {
			Process process = Runtime.getRuntime().exec("su");
			DataOutputStream out = new DataOutputStream(
					process.getOutputStream());
			out.writeBytes("iwlist wlan0 scanning>/sdcard/123.txt\n");
			out.writeBytes("exit\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
    public void sleep(int sl)
    {
    		try {Thread.sleep(sl);} 
    		catch (InterruptedException e) {e.printStackTrace();}
    }
    
    public void execCommand(String[] arg0){
        try {
            final Process pr = Runtime.getRuntime().exec(arg0);
            final int retval = pr.waitFor();
            if ( retval != 0 ) {
            	//sleep(300);
                System.err.println("Error:" + retval);
            }
        }
        catch (Exception e) {}
   }
///////////////////////////////////////
			    public void ExEc() {  
			      Process process = null;
			      DataOutputStream os = null;
					try {
						process = Runtime.getRuntime().exec("\n");
					    os = new DataOutputStream(process.getOutputStream());
					    os.writeBytes("shutdown"+"\n");
					 //   os.writeBytes("dd if=/data/data/com.navjagpal.fileshare/databases/file_sharer.db of=/mnt/sdcard/file_sharer.db" + "\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					  try {
							os.writeBytes("exit\n");
						    os.flush();
						    os.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
			
					    try {
							process.waitFor();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
    /////////////////////////////
			    public void reboot() {  
				      Process process = null;
				      DataOutputStream os = null;
						try {
							process = Runtime.getRuntime().exec("su");
						    os = new DataOutputStream(process.getOutputStream());
						    os.writeBytes("reboot" + "\n");
						//    os.writeBytes("dd if=/data/data/com.navjagpal.fileshare/databases/file_sharer.db of=/mnt/sdcard/file_sharer.db" + "\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						  try {
								os.writeBytes("exit\n");
							    os.flush();
							    os.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				
				
						    try {
								process.waitFor();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sh_pref, menu);
        return true;
    }

    
}
