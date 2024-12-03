package com.ej.languagetest

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

fun Context.updateLocale(locale: Locale): Context {
    Locale.setDefault(locale)

    val config = Configuration(this.resources.configuration)
    config.setLocale(locale)
    return this.createConfigurationContext(config)
}
