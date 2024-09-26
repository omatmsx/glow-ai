package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.network.rest.model.SkinAnalysisReportModel
import retrofit2.Response
import java.io.File

interface SkinAnalysisUseCase {

    suspend  fun getSkinAnalysis(imageFilePath:File)

}