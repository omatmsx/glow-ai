package com.mindstix.onboarding.utils

class MakeUpProductQueryBuilder {

    companion object {
        fun getQuery(data: String): String {
            return """
            use this data 
            $data
            use this data and give recommended make up products based on this in below structure json only nothing else
            [{"productName":"from ESIKA/LBEL/Cyzone companies","whatItContains":"","whyWeShouldDoIt":""}]
        """.trimIndent()
        }

    }
}