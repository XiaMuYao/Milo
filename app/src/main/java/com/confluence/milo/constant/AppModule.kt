package com.confluence.milo.constant

import com.confluence.milo.factory.ServiceCreator
import com.confluence.milo.model.MainRepository
import com.confluence.milo.model.RemoteUserSource
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milo.viewmodel.NFCViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MainRepository(get()) }

    single { ServiceCreator.create(RemoteUserSource::class.java) }

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        NFCViewModel()
    }

}