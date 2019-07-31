package com.avsystemgeo.cameraman.model

import java.io.Serializable

import io.fotoapparat.selector.ResolutionSelector

import com.avsystemgeo.cameraman.selector.mediumResolution

/**
 * @author Lucas Cota
 * @since 18/06/2019 14:43
 */

data class CameramanSettings(
    var savePath: String,
    var resolutionSelector: ResolutionSelector = mediumResolution(),
    var enableFocusView: Boolean = false,
    var enableCoordinates: Boolean = false,
    var enableDescription: Boolean = false,
    var datePattern: String,
    var descriptionPrefix: String = ""
) : Serializable
