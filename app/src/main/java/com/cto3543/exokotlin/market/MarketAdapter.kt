package com.cto3543.exokotlin.market

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.cto3543.exokotlin.groupmarket.SummaryViewHolder
import com.cto3543.exokotlin.groupmarket.Market
import org.jetbrains.anko.*

/**
 * Created by cto3543 on 30/03/2017.
 */
class MarketAdapter(val handler: MarketAdapter.EventMarketAdapter, val list: List<Market>?) :
        RecyclerView.Adapter<SummaryViewHolder>() {

    interface EventMarketAdapter {
        fun onClick(currency: String? = null, currencyPair: String? = null)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SummaryViewHolder = SummaryViewHolder(
            TextView(parent?.context).apply {
                textSize = 20f
                padding = dip(8)
                layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
            }
    )

    override fun onBindViewHolder(holder: SummaryViewHolder?, position: Int) {
        val exchange = list?.get(position)?.exchange
        val currencyPair = list?.get(position)?.currencyPair
        holder?.textView?.text = exchange + " --->  " + currencyPair
        holder?.textView?.onClick { handler.onClick(exchange, currencyPair) }
    }

    override fun getItemCount(): Int {
        if (list != null)
            return list.size
        else
            return 0
    }
}