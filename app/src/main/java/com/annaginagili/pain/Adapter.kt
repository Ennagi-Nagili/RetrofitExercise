package com.annaginagili.pain

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import javax.microedition.khronos.opengles.GL

class Adapter(private val context: Context, private val itemList: List<Product>):
    RecyclerView.Adapter<Adapter.ItemHolder>() {
    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.image)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val price = itemView.findViewById<TextView>(R.id.price)

        fun setData(item: Product, context: Context) {
            this.name.text = item.title
            this.price.text = item.price.toString()
            Glide.with(context).load(Uri.parse(item.thumbnail)).into(this.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(itemList[position], context)
    }
}