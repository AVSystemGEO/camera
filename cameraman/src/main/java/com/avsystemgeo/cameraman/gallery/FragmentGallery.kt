package com.avsystemgeo.cameraman.gallery

import java.io.Serializable

import kotlin.properties.Delegates

import android.os.Build
import android.content.Intent

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.MenuInflater
import android.view.LayoutInflater

import androidx.fragment.app.Fragment

import com.avsystemgeo.cameraman.R
import com.avsystemgeo.cameraman.Cameraman
import com.avsystemgeo.cameraman.extension.gallery
import com.avsystemgeo.cameraman.extension.visible
import com.avsystemgeo.cameraman.model.CameramanPicture
import com.avsystemgeo.cameraman.gallery.adapter.GalleryAdapter

import kotlinx.android.synthetic.main.fragment_gallery.*

/**
 * @author Lucas Cota
 * @since 23/08/2019 10:24
 */

@Suppress("UNCHECKED_CAST")
class FragmentGallery : Fragment() {

    private var root: View by Delegates.notNull()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_gallery, container, false)

        return root
    }

    private val pictures: List<CameramanPicture> by lazy {
        arguments?.get(Cameraman.PICTURES) as List<CameramanPicture>
    }

    override fun onResume() {
        super.onResume()

        setupRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.clear()
    }

    private fun setupRecycler() {
        val adapter = GalleryAdapter(context!!, pictures, ::onItemClick)

        recycler.gallery(adapter)

        if (adapter.itemCount <= 0) txtNoPictures.visible(true) else txtNoPictures.visible(false)
    }

    private fun onItemClick(position: Int) {
        val intent = Intent(activity, ImageViewerActivity::class.java)
            .putExtra(Cameraman.POSITION, position)
            .putExtra(Cameraman.PICTURES, pictures as Serializable)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

        startActivity(intent)
    }
}
