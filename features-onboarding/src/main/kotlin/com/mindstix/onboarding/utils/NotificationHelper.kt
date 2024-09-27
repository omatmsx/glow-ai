package com.mindstix.onboarding.utils
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationHelper(private val context: Context) {

    private val CHANNEL_ID = "top_of_the_day_channel"
    private val NOTIFICATION_ID = 1

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH  // Use high importance for heads-up
//            val soundUri: Uri = Uri.parse("android.resource://" + context.packageName + "/" + com.mindstix.core.R.raw.notification_sound)  // Use your own sound file

            // Set up audio attributes for the notification sound
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()

            val channel = NotificationChannel(CHANNEL_ID, "Tip of the Day", importance).apply {
                description = "Channel for Top of the Day notifications"
//                setSound(soundUri, audioAttributes)  // Add sound to the channel
            }

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission")
    fun sendNotification(message: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(com.mindstix.core.R.drawable.ic_image)  // Replace with your app icon
            .setContentTitle("Tip of the Day")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)  // For heads-up notification
            .setAutoCancel(true)  // Remove notification after tapping
            .setDefaults(NotificationCompat.DEFAULT_ALL)  // Use vibration and sound from channel

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }
}
