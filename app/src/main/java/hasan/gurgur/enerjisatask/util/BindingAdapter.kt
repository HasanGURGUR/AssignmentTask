package hasan.gurgur.enerjisatask.util

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import hasan.gurgur.enerjisatask.R

object BindingAdapter {


    @SuppressLint("CheckResult")
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImageFromUrl(imageview: ImageView, key: Int?) {
       when(key){
           1-> Glide.with(imageview.context).load(R.drawable.ic_abonelik).into(imageview)
           2-> Glide.with(imageview.context).load(R.drawable.ic_dilekce_basvuru).into(imageview)
           4-> Glide.with(imageview.context).load(R.drawable.ic_tahliye).into(imageview)
           5-> Glide.with(imageview.context).load(R.drawable.ic_nakil_tasima).into(imageview)
       }
    }
}