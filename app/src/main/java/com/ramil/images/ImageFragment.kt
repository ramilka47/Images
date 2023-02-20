package com.ramil.images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.facebook.drawee.view.SimpleDraweeView

class ImageFragment : Fragment() {

    companion object{
        const val IMAGE_LOADER = "image_loader"
    }

    private final val URL_IMAGE = "https://static.baza.farpost.ru/v/1653011265829_bulletin"
    private lateinit var imageView : SimpleDraweeView

    private var image_load = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        image_load = arguments?.getBoolean(IMAGE_LOADER) ?: false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.image_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.imageView)

        if (image_load){
            imageGlide()
        } else {
            imageFresco()
        }
    }

    private fun imageGlide(){
        Glide.with(this).load(URL_IMAGE).into(imageView)
    }

    private fun imageFresco(){
        imageView.setImageURI(URL_IMAGE)
    }

}