package com.confluence.milo.constant

import com.confluence.milo.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    viewModel {
        MainViewModel()
    }

}