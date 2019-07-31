package com.avsystemgeo.cameraman.listener

import android.view.View
import android.content.Context
import android.view.animation.Animation
import android.view.OrientationEventListener

/**
 * @author Lucas Cota
 * @since 31/07/2019 10:04
 */

class OrientationListener(
    context: Context,
    private val portraitAnim: Animation,
    private val landscapeAnim: Animation,
    private val reversePortraitAnim: Animation,
    private val reverseLandscapeAnim: Animation,
    private val views: Array<View>
) : OrientationEventListener(context) {

    companion object {
        private const val ROTATION_O = 1
        private const val ROTATION_90 = 2
        private const val ROTATION_180 = 3
        private const val ROTATION_270 = 4
    }

    private var rotation: Int = 0

    override fun onOrientationChanged(orientation: Int) {
        when {

            // PORTRAIT
            (orientation < 35 || orientation > 325) && rotation != ROTATION_O -> {
                rotation = ROTATION_O

                views.forEach { view ->
                    //view.rotation = 0f
                    view.startAnimation(portraitAnim)
                }
            }

            // REVERSE PORTRAIT
            orientation in 146..214 && rotation != ROTATION_180 -> {
                rotation = ROTATION_180

                views.forEach { view ->
                    //view.rotation = -180f
                    view.startAnimation(reversePortraitAnim)
                }
            }

            // REVERSE LANDSCAPE
            orientation in 56..124 && rotation != ROTATION_270 -> {
                rotation = ROTATION_270

                views.forEach { view ->
                    //view.rotation = -90f
                    view.startAnimation(reverseLandscapeAnim)
                }
            }

            // LANDSCAPE
            orientation in 236..304 && rotation != ROTATION_90 -> {
                rotation = ROTATION_90

                views.forEach { view ->
                    //view.rotation = 90f
                    view.startAnimation(landscapeAnim)
                }
            }
        }
    }
}