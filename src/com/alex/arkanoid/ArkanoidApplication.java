package com.alex.arkanoid;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.google.inject.util.Modules;

public class ArkanoidApplication extends Application {

	private static ArkanoidApplication application;

	public ArkanoidApplication() {
		application = this;
	}
	
    @Override
    public void onCreate() {
        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, 
        		Modules.override(RoboGuice.newDefaultRoboModule(this)).with(new ArkanoidModule()));
    }

	public final static Context getAppContext() {
		return application.getApplicationContext();
	}
	
	public final static Resources getAppResources() {
		return getAppContext().getResources();
	}
	
	public final static RoboInjector getInjector() {
		return RoboGuice.getInjector(getAppContext());
	}
	
}

