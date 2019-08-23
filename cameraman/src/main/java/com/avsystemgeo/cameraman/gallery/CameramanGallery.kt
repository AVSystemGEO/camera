package com.avsystemgeo.cameraman.gallery

import com.avsystemgeo.cameraman.listener.CameramanGalleryListener

/**
 * @author Lucas Cota
 * @since 23/08/2019 10:37
 */

class CameramanGallery {

    companion object {
        private var listener: CameramanGalleryListener? = null

        internal fun getListener(): CameramanGalleryListener? {
            return listener
        }
    }

    fun build(listener: CameramanGalleryListener): FragmentGallery {
        CameramanGallery.listener = listener

        return FragmentGallery()
    }
}
