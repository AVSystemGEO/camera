package com.avsystemgeo.cameraman.selector

import io.fotoapparat.selector.ResolutionSelector

/**
 * @author Lucas Cota
 * @since 13/06/2019 14:53
 */

fun highResolution(): ResolutionSelector = {
    val resolutions = this.sortedByDescending { it.area }

    val half = resolutions.size / 2
    val index = (resolutions.size - half) / 2

    resolutions[index]
}

fun mediumResolution(): ResolutionSelector = {
    val resolutions = this.sortedByDescending { it.area }

    val index = resolutions.size / 2

    resolutions[index]
}

fun lowResolution(): ResolutionSelector = {
    val resolutions = this.sortedByDescending { it.area }

    val half = resolutions.size / 2
    val index = half + (half / 2)

    resolutions[index]
}
