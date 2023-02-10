package com.confluence.milo.model.di

import com.confluence.milo.factory.ServiceCreator
import com.confluence.milo.model.RemoteUserSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {
    @Provides
    fun provideRemoteUserSource(): RemoteUserSource {
        return ServiceCreator.create(RemoteUserSource::class.java)
    }
}

