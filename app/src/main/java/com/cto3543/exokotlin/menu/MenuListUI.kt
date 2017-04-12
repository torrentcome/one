package com.cto3543.exokotlin.menu

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.cto3543.exokotlin.R
import org.jetbrains.anko.*

/**
 * Created by cto3543 on 31/03/2017.
 */
class MenuListUI : AnkoComponent<MenuActivity> {
    lateinit var gotomarket: Button
    lateinit var gotoblock: Button
    lateinit var gotoBolivar: Button

    override fun createView(ui: AnkoContext<MenuActivity>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.HORIZONTAL
                textView {
                    textSize = 16f
                }

                gotomarket = button {
                    text = resources.getString(R.string.gotomarket)
                    onClick {
                        ui.owner.gotoMarket()
                    }
                }.lparams {
                    topMargin = 48
                }

                gotoblock = button {
                    text = resources.getString(R.string.gotoblock)
                    onClick {
                        ui.owner.gotoBlock()
                    }
                }.lparams {
                    topMargin = 48
                }

                gotoBolivar = button {
                    text = resources.getString(R.string.gotobolivar)
                    onClick {
                        ui.owner.gotoBolivar()
                    }
                }.lparams {
                    topMargin = 48
                }
            }
        }
    }
}