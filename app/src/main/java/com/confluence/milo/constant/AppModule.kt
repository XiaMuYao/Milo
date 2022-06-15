package com.confluence.milo.constant

import com.confluence.milo.TestViewModel
import com.confluence.milo.factory.ServiceCreator
import com.confluence.milo.model.MainRepository
import com.confluence.milo.model.RemoteUserSource
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milo.viewmodel.NewTopListViewModel
import com.confluence.milo.viewmodel.NewsTopViewModel
import com.confluence.milo.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MainRepository(get()) }

    single { ServiceCreator.create(RemoteUserSource::class.java) }


    viewModel { MainViewModel(get()) }
    viewModel { NewsTopViewModel() }
    viewModel { NewsViewModel() }
    viewModel { NewTopListViewModel() }
    viewModel { TestViewModel() }
}