package com.avsystemgeo.cameraman.gallery.adapter

import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.view.LayoutInflater

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import com.avsystemgeo.cameraman.R
import com.avsystemgeo.cameraman.extension.visible
import com.avsystemgeo.cameraman.extension.fileExists
import com.avsystemgeo.cameraman.model.CameramanPicture

import kotlinx.android.synthetic.main.item_image_viewer.view.*

/**
 * @author Lucas Cota
 * @since 05/07/2019 14:29
 */

internal class ImageViewerAdapter(
    private val context: Context,
    private val itens: List<CameramanPicture>
) : RecyclerView.Adapter<ImageViewerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_viewer, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val picture = itens[position]

        if (picture.path.fileExists()) {
            Glide.with(context)
                .load(picture.path)
                .into(holder.itemView.imageView)

            holder.itemView.txtDescricao.text = picture.description

            holder.itemView.txtPictureNotFound.visible(false)
        } else {
            holder.itemView.txtPictureNotFound.visible(true)
        }
    }
}
