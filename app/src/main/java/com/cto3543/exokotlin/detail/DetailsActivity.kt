package com.cto3543.exokotlin.detail

import android.os.Bundle
import android.widget.TextView
import com.cto3543.exokotlin.BaseActivity
import com.cto3543.exokotlin.ExoKotlinApp
import com.cto3543.exokotlin.R
import com.cto3543.exokotlin.action.Action
import com.cto3543.exokotlin.web.WebApi
import org.jetbrains.anko.*


class DetailsActivity : BaseActivity() {

    var currency: String? = null
    var exchange: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        store = (application as ExoKotlinApp).store

        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            padding = dip(30)
            textView {
                id = R.id.price_last
                textSize = 26f
            }
            textView {
                id = R.id.price_high
            }
            textView {
                id = R.id.price_low
            }

        }

        doAsync {
            val (summary, error) = WebApi.getSummary(store?.state?.currency, null)
            //send stuff
            uiThread {
                store?.dispatch(Action.getSummary(summary))
            }
        }
        // receive stuff
        subscriber = store?.subscribe {
            if (store?.state?.summary != null) {
                (findViewById(R.id.price_last) as TextView).setText("last price = " + store?.state?.summary?.result?.price?.last)
                (findViewById(R.id.price_high) as TextView).setText("high price = " + store?.state?.summary?.result?.price?.high)
                (findViewById(R.id.price_low) as TextView).setText("low price = " + store?.state?.summary?.result?.price?.low)
            }
        }
    }
}
