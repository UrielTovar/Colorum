package com.colorum.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger
import logcat.LogPriority

@HiltAndroidApp
class ColorumApplication : Application() {
	
	override fun onCreate() {
		super.onCreate()
		AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
	}

}