package com.mindstix.onboarding.utils

class SkinCareQueryBuilder {

    companion object{
        fun getQuery(data:String): String {
            return """
            use this data 
            $data
            use this data and give me skin care routine based on this in below structure json only nothing else
            [{"task":"","time":"morning/evening/night","whyWeShouldDoIt":""}]
        """.trimIndent()
        }
    }

}