package com.confluence.milo.model.di

import com.confluence.milo.model.MainRepository
import com.confluence.milo.model.RemoteUserSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepo(remoteUserSource: RemoteUserSource): MainRepository {
        return MainRepository(remoteUserSource)
    }
}