package com.scuchina.helloworld.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyAdapter(private val myData: List<String>, private val listener: ClickListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface ClickListener {
        fun onItemClicked(item: String)
    }

    private val ITEM_EVEN_TYPE = 0

    private val ITEM_ODD_TYPE = 1

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) ITEM_EVEN_TYPE else ITEM_ODD_TYPE
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val vh: RecyclerView.ViewHolder
        if (p1 == ITEM_EVEN_TYPE) {
            val textView = LayoutInflater.from(p0.context).inflate(R.layout.item_row_even, p0, false)
            vh = EvenViewHolder(textView)
        } else {
            val textView = LayoutInflater.from(p0.context).inflate(R.layout.item_row_odd, p0, false)
            vh = OddViewHolder(textView)
        }
        return vh
    }

    override fun getItemCount(): Int {
        return myData.size
    }

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
