package com.example.myapplication.di

import com.example.myapplication.data.local.auth.LocalAuthDataSourceI
import com.example.myapplication.data.local.auth.LocalAuthDataSource
import com.example.myapplication.data.storage.LocalStorageModel
import com.example.myapplication.data.storage.UserStorage
import com.example.myapplication.data.storage.preferances.AppPreferences
import com.example.myapplication.data.storage.preferances.AppPreferencesImpl
import org.koin.dsl.module

val appModules = module {

    single<LocalAuthDataSourceI> { LocalAuthDataSource() }
    single<UserStorage> { LocalStorageModel() }
    single<AppPreferences> { AppPreferencesImpl() }

}