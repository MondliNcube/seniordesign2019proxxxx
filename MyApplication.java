package com.estimote.proximity;

import android.app.Application;

import com.estimote.proximity_sdk.api.EstimoteCloudCredentials;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MyApplication extends Application {

    public EstimoteCloudCredentials cloudCredentials =
            new EstimoteCloudCredentials("official-proximity-for-a-s-n5h", "4591a6ab53e33572dd2b2e8d16b4e87c");
}
