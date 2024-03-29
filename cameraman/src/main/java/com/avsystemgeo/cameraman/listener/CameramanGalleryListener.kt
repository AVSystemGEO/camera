package com.avsystemgeo.cameraman.listener

import java.io.Serializable

import com.avsystemgeo.cameraman.model.CameramanPicture

/**
 * @author Lucas Cota
 * @since 23/08/2019 14:16
 */

interface CameramanGalleryListener : Serializable {

    fun onGallerySetupRecycler(): List<CameramanPicture>
}
