package com.scuchina.helloworld.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyAdapter(private val myData: List<String>, private val listener: ClickListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface ClickListener {
        fun onItemClicked(item: String)
    }

    private val itemeventype = 0

    private val itemoddtype = 1

    override fun getItemViewType(position: Int) = if (position % 2 == 0) itemeventype else itemoddtype

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return if (p1 != itemeventype) {
            val textView = LayoutInflater.from(p0.context).inflate(R.layout.item_row_odd, p0, false)
            OddViewHolder(textView)
        } else {
            val textView = LayoutInflater.from(p0.context).inflate(R.layout.item_row_even, p0, false)
            EvenViewHolder(textView)
        }
    }

    override fun getItemCount() = myData.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        when (p0) {
            is EvenViewHolder -> {
                val item = myData.get(p1)
                p0.bind(item, listener)
            }
            is OddViewHolder -> {
                val item = myData.get(p1)
                p0.bind(item, listener)
            }
            else -> throw IllegalArgumentException("Unknown row type")
        }
    }

}
