package com.avsystemgeo.cameraman.geo.model

import java.io.Serializable

import android.content.Context

import com.avsystemgeo.cameraman.R

/**
 * @author Lucas Cota
 * @since 18/06/2019 14:45
 */

data class GeolocationOutput(
    var latitude: Double,
    var longitude: Double,
    var utm: String,
    var utmX: String,
    var utmY: String
) : Serializable {

    fun toPlotString(context: Context, date: String): String {
        return "${context.getString(R.string.camera_utm)}$utm\n" +
                "${context.getString(R.string.camera_utm_x)}$utmX\n" +
                "${context.getString(R.string.camera_utm_y)}$utmY\n" +
                "${context.getString(R.string.camera_date)}$date"
    }
}
