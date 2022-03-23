package com.example.myapplication.di

import com.example.myapplication.data.network.service.auth.NetworkAuthService
import com.example.myapplication.data.network.service.auth.NetworkAuthServiceImpl
import com.example.myapplication.data.storage.LocalStorageModel
import com.example.myapplication.data.storage.MusicStorage
import com.example.myapplication.data.storage.UserStorage
import com.example.myapplication.data.storage.preferances.AppPreferences
import com.example.myapplication.data.storage.preferances.AppPreferencesImpl
import org.koin.dsl.module
import org.koin.dsl.single

val appModules = module {

    single<NetworkAuthService> { NetworkAuthServiceImpl() }
    single<UserStorage> { LocalStorageModel() }
    single<AppPreferences> { AppPreferencesImpl() }

}