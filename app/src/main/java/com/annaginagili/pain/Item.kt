package com.annaginagili.pain

import android.net.Uri

class Item {
    var image: Uri? = null
    var name: String? = null
    var price: String? = null

    companion object {
        fun getData(imageList: ArrayList<Uri>, nameList: ArrayList<String>, priceList: ArrayList<String>): ArrayList<Item> {
            val itemList = ArrayList<Item>()
            for (i in 0 until imageList.size) {
                val item = Item()
                item.image = imageList[i]
                item.name = nameList[i]
                item.price = priceList[i]
                itemList.add(item)
            }
            return itemList
        }
    }
}