package com.exchange.di

import com.exchange.repository.DashboardRepo
import com.exchange.viewModel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule  = module {
    single { DashboardRepo(get()) }
    viewModel { DashboardViewModel(get(), get()) }
}