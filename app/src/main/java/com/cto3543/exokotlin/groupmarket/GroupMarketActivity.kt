package com.cto3543.exokotlin.groupmarket

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.cto3543.exokotlin.BaseActivity
import com.cto3543.exokotlin.R
import com.cto3543.exokotlin.action.Action
import com.cto3543.exokotlin.market.MarketActivity
import com.cto3543.exokotlin.groupmarket.Market
import com.cto3543.exokotlin.utils.Rotate3dAnimation
import com.cto3543.exokotlin.web.WebApi
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class GroupMarketActivity : BaseActivity(), GroupsMarketsAdapter.EventMarketAdapter {
    lateinit var recyclerView: RecyclerView

    var context: GroupsMarketsAdapter.EventMarketAdapter = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        relativeLayout {
            lparams(width = matchParent, height = matchParent)
            backgroundColor = Color.WHITE

            imageView {
                id = R.id.image
                lparams(width = matchParent, height = matchParent)
                imageResource = R.drawable.eth_icon
                scaleType = ImageView.ScaleType.CENTER
            }

            verticalLayout {
                lparams(width = matchParent, height = matchParent)
                padding = dip(30)
                textView {
                    id = R.id.title
                    text = context.getString(R.string.title)
                    textSize = 26f
                }
                recyclerView = recyclerView {
                    layoutManager = GridLayoutManager(context, 3) as RecyclerView.LayoutManager?
                }.lparams {
                    width = matchParent
                }
            }
        }

        doAsync {
            val (markets, error) = WebApi.getMarkets()
            animLoad(true)
            println("groupMarkets = " + markets)
            println("error = " + error)
            // send stuff
            uiThread {
                if (error != null) {
                    toast("$error")
                }
                store?.dispatch(Action.getMarkets(markets))
            }
        }

        // receive stuff
        subscriber = store?.subscribe {
            if (store?.state?.groupMarkets != null) {
                if (store?.state?.groupMarkets?.result != null) {
                    var res = (store?.state?.groupMarkets?.result as List<Market>).groupBy { it.exchange }
                    recyclerView.adapter = GroupsMarketsAdapter(context, res)
                }
            }
        }


        val image = findViewById(R.id.image) as ImageView
        image.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (isActive) {
                    val centerX: Float = (image.width / 2).toFloat()
                    val centerY: Float = (image.height / 2).toFloat()

                    val rotation: Rotate3dAnimation = Rotate3dAnimation(0f, 360f, centerX, centerY, 0.0f, true)
                    rotation.setDuration(1000);               // duration in ms
//                rotation.setFillAfter(true);               // keep rotation after animation
                    rotation.setInterpolator(LinearInterpolator())
                    rotation.repeatCount = Animation.INFINITE
                    image.startAnimation(rotation)
                    isActive = false
                } else {
                    image.clearAnimation()
                    isActive = true
                }
            }
        })
    }

    var isActive: Boolean = false

    fun animLoad(state: Boolean) {
        val image = findViewById(R.id.image) as ImageView
        if (state) {
            applyRotation(image, 0f, 180f)
        } else {
            image.clearAnimation()
            image.requestLayout()
        }
    }

    fun applyRotation(container: View, start: Float, end: Float) {
    }

    override fun onPause() {
        super.onPause()
        subscriber?.unsubscribe()
    }

    override fun onClick(currency: String?, exchange: List<Market>?) {
        store?.dispatch(Action.setCurrentList(currency, exchange))
        val intent = Intent(this@GroupMarketActivity, MarketActivity::class.java)
        startActivity(intent)
    }
}
