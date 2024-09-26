package com.mindstix.capabilities.network.rest.model


import com.google.gson.annotations.SerializedName

data class AiResponseModel(
    @SerializedName("choices")
    val choices: List<Choice>,
    @SerializedName("created")
    val created: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("object")
    val objectX: String,
    @SerializedName("system_fingerprint")
    val systemFingerprint: String,
    @SerializedName("usage")
    val usage: Usage
) {
    data class Choice(
        @SerializedName("finish_reason")
        val finishReason: String,
        @SerializedName("index")
        val index: Int,
        @SerializedName("logprobs")
        val logprobs: Any,
        @SerializedName("message")
        val message: Message
    ) {
        data class Message(
            @SerializedName("content")
            val content: String,
            @SerializedName("refusal")
            val refusal: Any,
            @SerializedName("role")
            val role: String
        )
    }

    data class Usage(
        @SerializedName("completion_tokens")
        val completionTokens: Int,
        @SerializedName("completion_tokens_details")
        val completionTokensDetails: CompletionTokensDetails,
        @SerializedName("prompt_tokens")
        val promptTokens: Int,
        @SerializedName("total_tokens")
        val totalTokens: Int
    ) {
        data class CompletionTokensDetails(
            @SerializedName("reasoning_tokens")
            val reasoningTokens: Int
        )
    }
}