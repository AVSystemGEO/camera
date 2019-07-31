package com.avsystemgeo.cameraman.listener

import java.io.Serializable

import com.avsystemgeo.cameraman.model.CameramanOutput

/**
 * @author Lucas Cota
 * @since 18/06/2019 14:42
 */

interface CameramanCallback : Serializable {

    fun onPreviewConfirmed(output: CameramanOutput)
}
