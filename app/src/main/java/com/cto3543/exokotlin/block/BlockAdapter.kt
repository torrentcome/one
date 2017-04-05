package com.cto3543.exokotlin.groupmarket

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cto3543.exokotlin.block.Block
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.wrapContent

/**
 * Created by cto3543 on 30/03/2017.
 */
class BlockAdapter(val list: List<Block>?) :
        RecyclerView.Adapter<SummaryViewHolder>() {

    interface EventBlockAdapter {
        fun onClick(blockList: List<Block>? = null)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SummaryViewHolder = SummaryViewHolder(
            TextView(parent?.context).apply {
                textSize = 20f
                padding = dip(8)
                layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
            }
    )

    override fun onBindViewHolder(holder: SummaryViewHolder?, position: Int) {
        holder?.textView?.text = list?.get(position)?.data
        holder?.textView?.setOnClickListener(object : View.OnClickListener {
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
