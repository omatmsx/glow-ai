/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */
package com.mindstix.core.logger

/**
 * Helper class for performing remote logging operations.
 *
 * @author Alhaj SIddiqui
 */
class RemoteLoggingHelper {
    /**
     * This function is responsible for implementing the logic for remote logging.
     *
     * @param tag The tag to be included in the remote log.
     * @param message The message to be logged remotely.
     * @param throwable An optional throwable associated with the log message (default is null).
     */
    fun performRemoteLogging(
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        // Implement the logic for remote logging
        // Logger.d { "performRemoteLogging : tag = $tag || message = $message || throwable = $throwable" }
    }
}
