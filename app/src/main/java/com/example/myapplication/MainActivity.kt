package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Item(val albumId: Int,
                val id: Int,
                val title: String,
                val url: String,
                val thumnailUrl: String)
class MainActivity : AppCompatActivity() {

    lateinit var list: List<Item>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        val result = application.assets.open("data.json")
            .bufferedReader().use { it.readText() }
        // GSON
        val gson = GsonBuilder().create()
        list = gson.fromJson(result,Array<Item>::class.java).toList()
        recyclerView.adapter = MyAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}