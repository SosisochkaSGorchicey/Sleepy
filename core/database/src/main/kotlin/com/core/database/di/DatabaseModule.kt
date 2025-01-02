package com.core.database.di

import androidx.room.Room
import com.core.database.Database
import org.koin.android.ext.koin.androidApplication
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule = module {
    provideDatabase()
    single { get<Database>().scheduleDao }
}

internal fun Module.provideDatabase(): KoinDefinition<Database> = single {
    Room.databaseBuilder(
        context = androidApplication(),
        klass = Database::class.java,
        name = Database.DATABASE_NAME
    ).build()
}
