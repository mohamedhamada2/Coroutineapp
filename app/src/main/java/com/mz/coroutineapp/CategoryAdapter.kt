package com.mz.coroutineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    var date_list: List<Data> = ArrayList<Data>()

    constructor() : super()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.setData(date_list.get(position))
    }
    fun setList(list: List<Data>){
        date_list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return date_list.size
    }
    class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_name = itemView.findViewById<TextView>(R.id.category_name)
        var category_img = itemView.findViewById<ImageView>(R.id.category_img)
        fun setData(get: Data) {
            category_name.text = get.titleSetting
            if (get.img != null) {
                Picasso.get()
                    .load("https://b.f.e.one-click.solutions/uploads/images/thumbs/" + get.img)
                    .into(category_img)
            } else {
                category_img.setImageResource(R.drawable.logo)
            }
        }
    }
}