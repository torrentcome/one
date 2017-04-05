package com.cto3543.exokotlin.groupmarket

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cto3543.exokotlin.groupmarket.Market
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.wrapContent

/**
 * Created by cto3543 on 30/03/2017.
 */
class GroupsMarketsAdapter(val handler: EventMarketAdapter, val list: Map<String, List<Market>>) :
        RecyclerView.Adapter<SummaryViewHolder>() {

    interface EventMarketAdapter {
        fun onClick(currency: String? = null, exchange: List<Market>? = null)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SummaryViewHolder = SummaryViewHolder(
            TextView(parent?.context).apply {
                textSize = 20f
                padding = dip(8)
                layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
            }
    )

    override fun onBindViewHolder(holder: SummaryViewHolder?, position: Int) {
        val key = list.keys.toList().get(position)
        val tabsize = list[key]?.size
        holder?.textView?.text = key + " --->  " + tabsize
        holder?.textView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handler.onClick(key, list[key])
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

class SummaryViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)