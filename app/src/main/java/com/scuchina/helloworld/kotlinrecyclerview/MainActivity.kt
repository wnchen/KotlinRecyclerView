package com.scuchina.helloworld.kotlinrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MyAdapter.ClickListener {
    override fun onItemClicked(item: String) {
        Toast.makeText(this, getString(R.string.item_clicked) + item, Toast.LENGTH_SHORT).show()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MyAdapter(constructDataList(), this)

        recyclerView = rv_main.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
    }

    private fun constructDataList(): List<String> {
        val count = 50
        val myData = arrayListOf<String>()
        for (i in 1..count) {
            myData.add(if (i % 2 == 0) "Even row $i" else "Odd row $i")
        }
        return myData
    }
}
