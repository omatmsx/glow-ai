/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.onboarding.di

import com.mindstix.onboarding.repository.SkinAnalysisRepository
import com.mindstix.onboarding.usecases.LoginUseCase
import com.mindstix.onboarding.usecases.LoginUseCaseImpl
import com.mindstix.onboarding.usecases.SkinAnalysisUseCase
import com.mindstix.onboarding.usecases.SkinAnalysisUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    fun provideLoginRepo(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase = loginUseCaseImpl

    @Provides
    fun provideSkinAnalyseUseCase(skinAnalysisUseCaseImpl: SkinAnalysisUseCaseImpl): SkinAnalysisUseCase = skinAnalysisUseCaseImpl

}
