package com.mindstix.onboarding.utils

class SkinCareQueryBuilder {

    companion object {
        fun getQuery(data: String): String {
            return """
            use this data 
            $data
            use this data and give me skin care routine for both morning and evening based on this in below structure json only nothing else
            [{"task":"","time":"morning or evening","whyWeShouldDoIt":"","productName":"from ESIKA/LBEL/Cyzone companies","whatItContains":""}]
        """.trimIndent()
        }

        fun getQueryForDayTip(temp: String, weatherCondition: String, currentTime: String): String {
            return """
            temp is
            $temp
             celcius and $weatherCondition and current time is $currentTime, give me skin care tip under 10 words.
                     """.trimIndent()
        }
    }
}