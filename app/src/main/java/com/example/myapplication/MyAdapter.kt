package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load

class MyAdapter(val list: List<Item>) : RecyclerView.Adapter<MyAdapter.MyViewItem>() {

    class MyViewItem(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val title = view.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewItem {
        Log.d("RRR","onCreateViewHolder()")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewItem(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyViewItem, position: Int) {
        Log.d("RRR","onBindViewHolder()")
        holder.title.text = list.get(position).title
        holder.image.load(list.get(position).url)
    }

}