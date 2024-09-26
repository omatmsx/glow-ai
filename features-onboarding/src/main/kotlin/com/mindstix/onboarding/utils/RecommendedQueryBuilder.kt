package com.mindstix.onboarding.utils

class RecommendedQueryBuilder {

    companion object{
        fun getQuery(data:String): String {
            return """
            use this data 
            $data
            
            use this data and give me skin care product recommendation in below structure json only nothing else

            [{"productName":"from a famous skin care companies","whatItContains":"","whyWeShouldDoIt":"","productImage":"give real image of product image link"}]
        """.trimIndent()
        }
    }

}