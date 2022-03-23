package com.example.myapplication.utils.extensions

import kotlinx.coroutines.flow.MutableStateFlow

suspend fun MutableStateFlow<Unit>.call() = emit(Unit)