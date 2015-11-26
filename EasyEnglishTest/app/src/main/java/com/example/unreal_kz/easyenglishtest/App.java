package com.example.unreal_kz.easyenglishtest;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Unreal_KZ on 24.11.2015.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "pJ0JdrJSsNEiggSyFfcwPRnN89iKGqHjBbiORiBk", "DuxPnQlpfB6i99f3c8GANtNplaNjcv1irvtMx3VN");
    }
}
