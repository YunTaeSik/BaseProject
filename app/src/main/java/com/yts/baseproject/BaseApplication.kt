package com.yts.baseproject

import androidx.multidex.MultiDexApplication
import com.yts.baseproject.realm.Migration
import io.realm.Realm
import io.realm.RealmConfiguration

class BaseApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("yts.realm")
            .schemaVersion(0)
            .migration(Migration())
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }

}