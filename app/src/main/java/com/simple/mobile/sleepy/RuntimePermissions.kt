package com.simple.mobile.sleepy

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat

//todo
//// Declare the launcher at the top of your Activity/Fragment:
//private val requestPermissionLauncher = registerForActivityResult(
//    ActivityResultContracts.RequestPermission(),
//) { isGranted: Boolean ->
//    if (isGranted) {
//        // FCM SDK (and your app) can post notifications.
//    } else {
//        // TODO: Inform user that that your app will not show notifications.
//    }
//}
//
//private fun askNotificationPermission(context: Context) {
//    // This is only necessary for API level >= 33 (TIRAMISU)
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) ==
//            PackageManager.PERMISSION_GRANTED
//        ) {
//            // FCM SDK (and your app) can post notifications.
//        } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
//            // TODO: display an educational UI explaining to the user the features that will be enabled
//            //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
//            //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
//            //       If the user selects "No thanks," allow the user to continue without notifications.
//        } else {
//            // Directly ask for the permission
//            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
//        }
//    }
//}