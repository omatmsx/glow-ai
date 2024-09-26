package com.mindstix.capabilities.network.rest.model

import com.google.gson.annotations.SerializedName


class ChatCompletionRequest {
    @SerializedName("model")
    private val model: String? = null

    @SerializedName("messages")
    private val messages: List<Message>? = null

    @SerializedName("max_tokens")
    private val maxTokens = 0

    // Getters and Setters
    class Message {
        @SerializedName("role")
        private val role: String? = null

        @SerializedName("content")
        private val content: List<Content>? = null // Getters and Setters
    }

    class Content {
        @SerializedName("type")
        private val type: String? = null

        @SerializedName("text")
        private val text: String? = null // Getters and Setters
    }
}
