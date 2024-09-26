/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.onboarding.di

import android.content.Context
import com.mindstix.onboarding.repository.SkinAnalysisRepository
import com.mindstix.onboarding.usecases.LoginUseCase
import com.mindstix.onboarding.usecases.LoginUseCaseImpl
import com.mindstix.onboarding.usecases.SkinAnalysisUseCase
import com.mindstix.onboarding.usecases.SkinAnalysisUseCaseImpl
import com.mindstix.onboarding.utils.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    fun provideLoginRepo(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase = loginUseCaseImpl

    @Provides
    fun provideSkinAnalyseUseCase(skinAnalysisUseCaseImpl: SkinAnalysisUseCaseImpl): SkinAnalysisUseCase = skinAnalysisUseCaseImpl

    @Provides
    fun provideSharedPreferenceManager(@ApplicationContext context: Context): SharedPreferenceManager {
        return SharedPreferenceManager(context)
    }
}
