package com.example.androidlearning;

import android.app.Application;

import org.koin.android.java.KoinAndroidApplication;
import org.koin.core.KoinApplication;
import org.koin.core.context.GlobalContext;


import static org.koin.core.context.ContextFunctionsKt.startKoin;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Start Koin
        KoinApplication koin = KoinAndroidApplication.create(this)
                .modules(ModulesKt.getAppModule() , ModulesKt.getViewModel());
        startKoin(new GlobalContext(), koin);
    }
}


