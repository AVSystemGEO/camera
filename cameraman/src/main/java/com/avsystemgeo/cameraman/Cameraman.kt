package com.avsystemgeo.cameraman

import android.content.Intent
import android.content.Context

import com.avsystemgeo.cameraman.view.CameraActivity
import com.avsystemgeo.cameraman.model.CameramanSettings
import com.avsystemgeo.cameraman.listener.CameramanCallback

/**
 * @author Lucas Cota
 * @since 13/06/2019 17:19
 */

class Cameraman(private var context: Context, private var settings: CameramanSettings) {

    companion object {
        const val CAMERA_SETTINGS = "CAMERA_SETTINGS"
        const val POSITION = "POSITION"
        const val PICTURES = "PICTURES"

        internal var callback: CameramanCallback? = null

        internal fun stayNight(): CameramanCallback? {
            return callback
        }
    }

    fun start(callback: CameramanCallback) {
        Cameraman.callback = callback

        context.startActivity(Intent(context, CameraActivity::class.java).putExtra(CAMERA_SETTINGS, settings))
    }
}
