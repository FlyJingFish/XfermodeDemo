package com.flyjingfish.xfermodedemo

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class XfermodeAdapter : RecyclerView.Adapter<MyHolder>() {
    var onItemClickListener:OnItemClickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_xfermode,parent,false))
    }

    override fun getItemCount(): Int {
        return PorterDuff.Mode.values().size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        if (holder.itemView is Button){
            (holder.itemView as Button).text = PorterDuff.Mode.values()[position].name
        }
        holder.itemView.setOnClickListener{
            onItemClickListener?.onClick(position)
        }
    }

    interface OnItemClickListener{
        fun onClick(position:Int)
    }
}