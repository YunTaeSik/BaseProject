package com.yts.baseproject.realm

import io.realm.DynamicRealm
import io.realm.RealmMigration

class Migration : RealmMigration{
    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        val schema = realm.schema

    }

}