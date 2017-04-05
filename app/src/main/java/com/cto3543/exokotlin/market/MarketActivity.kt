package com.cto3543.exokotlin.market

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.cto3543.exokotlin.BaseActivity
import com.cto3543.exokotlin.R
import com.cto3543.exokotlin.action.Action
import com.cto3543.exokotlin.detail.DetailsActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MarketActivity : BaseActivity(), MarketAdapter.EventMarketAdapter {

    lateinit var recyclerView: RecyclerView
    lateinit var title: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            lparams(width = matchParent, height = matchParent)
            backgroundColor = Color.WHITE

            imageView {
                lparams(width = matchParent, height = matchParent)
                imageResource = R.drawable.eth_icon
                scaleType = ImageView.ScaleType.CENTER
            }

            verticalLayout {
                lparams(width = matchParent, height = matchParent)
                padding = dip(30)
                title = textView {
                    id = R.id.title
                    text = context.getString(R.string.title_activity_second)
                    textSize = 26f
                }
                recyclerView = recyclerView {
                    layoutManager = GridLayoutManager(context, 2)
                }.lparams {
                    width = matchParent
                }
            }
        }
        // receive stuff
        subscriber = store?.subscribe {
            println("exchange = " + store)
            println("exchange = " + store?.state?.exchange)
            if (store?.state?.exchange != null) {
                recyclerView.adapter = MarketAdapter(this, store?.state?.exchange)
            }
            if (store?.state?.currency != null) {
                title.setText(store?.state?.currency)
            }

        }
        store?.dispatch(Action.getState())
    }

    override fun onPause() {
        super.onPause()
        subscriber?.unsubscribe()
    }

    override fun onClick(currency: String?, currencyPair: String?) {
        store?.dispatch(Action.setCurrentSummary(currency, currencyPair))
        val intent = Intent(this@MarketActivity, DetailsActivity::class.java)
        startActivity(intent)
    }
}
