package com.ej.languagetest

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import java.util.Locale

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    fun updateLocale(locale: Locale) {
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}