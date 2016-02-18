package com.smartdatainc.activities;

import android.app.Application;

import com.smartdatainc.utils.Constants;
import com.splunk.mint.Mint;


/**
 * Created by Anurag Sethi
 * The class will start once the application will start and will set the Splunk Key for handling
 * Bugsense issues 
 */

public class MyApplication extends Application {

   

    @Override
    public void onCreate() {
        super.onCreate();

        Mint.enableDebug();
        Mint.initAndStartSession(getApplicationContext(), Constants.BugSenseConstants.SPLUNK_API_KEY);

        
    }
    
    
}
