package com.avsystemgeo.cameraman.geo.listener

import java.io.Serializable

import com.avsystemgeo.cameraman.geo.model.GeolocationOutput

/**
 * @author Lucas Cota
 * @since 18/06/2019 14:48
 */

internal interface GeolocationListener : Serializable {

    fun onLocationChanged(output: GeolocationOutput)
}
