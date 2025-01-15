package com.core.data.repository

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class NotificationsFirebaseMessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        println("TAG: Refreshed token: $token")
        super.onNewToken(token)
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Handle data payload of FCM messages.
        if (remoteMessage.data.isNotEmpty()) {
            println("TAG: remoteMessage.data ${remoteMessage.data}")
            // Handle the data message here.
        }

        // Handle notification payload of FCM messages.
        remoteMessage.notification?.let {
            println("TAG: remoteMessage.notification ${it}")
            // Handle the notification message here.
        }
    }
}