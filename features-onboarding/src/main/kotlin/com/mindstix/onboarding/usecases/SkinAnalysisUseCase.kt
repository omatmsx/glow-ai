package com.mindstix.onboarding.usecases

interface SkinAnalysisUseCase {

    suspend  fun getSkinAnalysis(imageFilePath:String)

}