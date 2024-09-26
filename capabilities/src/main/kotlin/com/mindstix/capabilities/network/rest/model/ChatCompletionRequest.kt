package com.mindstix.capabilities.network.rest.model

import com.google.gson.annotations.SerializedName


class ChatCompletionRequest {
    @SerializedName("model")
    private val model: String = "gpt-4o-mini"

    @SerializedName("messages")
    private val messages: List<Message> = arrayListOf(Message())

    @SerializedName("max_tokens")
    private val maxTokens = 1000

    // Getters and Setters
    class Message {
        @SerializedName("role")
        private val role: String = "user"

        @SerializedName("content")
        val content: List<Content> = arrayListOf(Content())
    }

    class Content {
        @SerializedName("type")
        private val type: String = "text"

        @SerializedName("text")
        var text: String = ""
    }

    companion object{
        fun getObject(text:String): ChatCompletionRequest {
            val obj = ChatCompletionRequest()
            obj.messages[0].content[0].text = text
            return obj
        }
    }
}
