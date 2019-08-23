package com.avsystemgeo.cameraman.gallery

import java.io.Serializable

import android.os.Bundle

import com.avsystemgeo.cameraman.Cameraman
import com.avsystemgeo.cameraman.model.CameramanPicture

/**
 * @author Lucas Cota
 * @since 23/08/2019 10:37
 */

class CameramanGallery(private var pictures: List<CameramanPicture>) {

    fun build(): FragmentGallery {
        val fragment = FragmentGallery()

        fragment.arguments = Bundle().apply {
            putSerializable(Cameraman.PICTURES, pictures as Serializable)
        }

        return fragment
    }
}
