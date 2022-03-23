package com.example.myapplication.di

import com.example.myapplication.data.local.auth.LocalAuthServiceI
import com.example.myapplication.data.local.auth.LocalAuthService
import com.example.myapplication.data.storage.LocalStorageModel
import com.example.myapplication.data.storage.UserStorage
import com.example.myapplication.data.storage.preferances.AppPreferences
import com.example.myapplication.data.storage.preferances.AppPreferencesImpl
import org.koin.dsl.module

val appModules = module {

    single<LocalAuthServiceI> { LocalAuthService() }
    single<UserStorage> { LocalStorageModel() }
    single<AppPreferences> { AppPreferencesImpl() }

}