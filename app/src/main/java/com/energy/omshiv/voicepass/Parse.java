package com.energy.omshiv.voicepass;

import android.app.Application;

/**
 * Created by omshiv on 14/10/2015.
 */



    public class Parse extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            //ParseCrashReporting.enable(this);
            com.parse.Parse.enableLocalDatastore(this);
            com.parse.Parse.initialize(this, getString(R.string.ApplicationID), getString(R.string.Client_ID));


        }


}
