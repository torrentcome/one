package com.cto3543.exokotlin.groupmarket

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cto3543.exokotlin.R
import com.cto3543.exokotlin.block.Block
import com.cto3543.exokotlin.block.component.BlockItemComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by cto3543 on 30/03/2017.
 */
class BlockAdapter(val list: List<Block>?) :
        RecyclerView.Adapter<BlockHolder>() {

    interface EventBlockAdapter {
        fun onClick(blockList: List<Block>? = null)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BlockHolder? {
        return BlockHolder(BlockItemComponent().createView(AnkoContext.Companion.create(parent!!.context, parent)))
    }

    override fun onBindViewHolder(holder: BlockHolder?, position: Int) {
        holder?.bind(list?.get(position))
        holder?.onclick(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })
    }

    override fun getItemCount(): Int {
        if (list != null)
            return list.size
        else
            return 0
    }
}

class BlockHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val id: TextView = itemView.find(R.id.block_item_id)
    val previousHash: TextView = itemView.find(R.id.block_item_previous_hash)
    val timestamp: TextView = itemView.find(R.id.block_item_timestamp)
    val data: TextView = itemView.find(R.id.block_item_data)
    val hash: TextView = itemView.find(R.id.block_item_hash)

    fun bind(block: Block?) {
        id.text = "Id =" + block?.index.toString()
        previousHash.text = "PreviousHash =" + block?.previousHash
        timestamp.text = "Timestamp =" + block?.timestamp
        data.text = "Data =" + block?.data
        hash.text = "Hash =" + block?.hash
    }

    fun onclick(handle: View.OnClickListener) {
        itemView.setOnClickListener(handle)
    }
}