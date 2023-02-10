package com.confluence.milo.model.di

import com.confluence.milo.factory.ServiceCreator
import com.confluence.milo.model.RemoteUserSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
object DateSourceModule {
    @Provides
    fun provideRemoteUserSource(): RemoteUserSource {
        return ServiceCreator.create(RemoteUserSource::class.java)
    }
}

