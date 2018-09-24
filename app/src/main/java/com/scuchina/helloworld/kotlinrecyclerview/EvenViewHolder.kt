package com.scuchina.helloworld.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_row_even.view.*

class EvenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: String, listener: MyAdapter.ClickListener) {
        evenTextView.text = item
        evenTextView.setOnClickListener {
            listener.onItemClicked(item)
        }
    }

    private val evenTextView = view.tv_content!!
}
