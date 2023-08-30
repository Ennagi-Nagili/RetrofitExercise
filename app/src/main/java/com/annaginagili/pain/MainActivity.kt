package com.annaginagili.pain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler)

        recycler.setHasFixedSize(true)
        recycler.layoutManager = GridLayoutManager(this, 2)
        getProducts()
    }

    private fun getProducts() {
        val call = RetrofitClient.getInstance().getApi().getProducts()
        call.enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                val products: Products? = response.body()
                adapter = Adapter(this@MainActivity, products!!.products)
                recycler.adapter = adapter
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
                Log.e("errorin", t.message.toString())
            }
        })
    }
}