package com.scuchina.helloworld.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_row_odd.view.*

class OddViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: String, listener: MyAdapter.ClickListener) {
        oddTextView.text = item
        oddTextView.setOnClickListener {
            listener.onItemClicked(item)
        }
    }

    val oddTextView = view.tv_content
}
