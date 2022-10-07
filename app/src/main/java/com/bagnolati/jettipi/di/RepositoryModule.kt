package com.bagnolati.jettipi.di

import com.bagnolati.jettipi.data.repository.CountryRepositoryImpl
import com.bagnolati.jettipi.domain.repository.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountryRepository(
        userRepositoryImpl: CountryRepositoryImpl,
    ): CountryRepository

}
