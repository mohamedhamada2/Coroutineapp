package com.mz.coroutineapp.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.mz.coroutineapp.R
import com.squareup.picasso.Picasso

class SliderAdapter : PagerAdapter{
   var sliderlist:List<Image> = ArrayList<Image>()
   lateinit var layoutinflater :LayoutInflater
    constructor() : super() {

    }

    override fun getCount(): Int {
        return  sliderlist.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view == `object`
    }
    fun setSliderList(sliderlist:List<Image>){
        this.sliderlist = sliderlist
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutinflater = container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutinflater.inflate(R.layout.viewpageritem,null)
        val imageView = view.findViewById<ImageView>(R.id.imageviewpager)
        /*Picasso.get()
                .load(list.get(position).getPhoto())
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(imageView);*/
        //imageView.setImageResource(list.get(position).getImg());
        //imageView.setImageResource(list.get(position).getImage());
        try{

        }catch (e:Exception){
            Log.d("oooo",e.message.toString())
        }
        Picasso.get()
            .load("https://b.f.e.one-click.solutions/uploads/thumbs/" + sliderlist.get(position).image)
            .into(imageView)
        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}