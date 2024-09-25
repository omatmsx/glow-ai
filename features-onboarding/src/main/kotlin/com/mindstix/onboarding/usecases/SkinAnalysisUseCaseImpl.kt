package com.mindstix.onboarding.usecases

import com.mindstix.onboarding.repository.SkinAnalysisRepository
import javax.inject.Inject

class SkinAnalysisUseCaseImpl @Inject constructor(val skinAnalysisRepository: SkinAnalysisRepository) :SkinAnalysisUseCase {
    override suspend fun getSkinAnalysis(imageFilePath:String){
        skinAnalysisRepository.getSkinAnalysis(imageFilePath)
    }

}