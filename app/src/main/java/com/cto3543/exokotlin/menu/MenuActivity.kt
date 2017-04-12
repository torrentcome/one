package com.cto3543.exokotlin.menu

import android.content.Intent
import android.os.Bundle
import com.cto3543.exokotlin.BaseActivity
import com.cto3543.exokotlin.ExoKotlinApp
import com.cto3543.exokotlin.block.BlockActivity
import com.cto3543.exokotlin.bolivar.BolivarActivity
import com.cto3543.exokotlin.groupmarket.GroupMarketActivity
import org.jetbrains.anko.setContentView


class MenuActivity : BaseActivity() {
    lateinit var ui: MenuListUI

    var currency: String? = null
    var exchange: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = MenuListUI()
        ui.setContentView(this@MenuActivity)

        store = (application as ExoKotlinApp).store

        // receive stuff
        subscriber = store?.subscribe {
        }
    }

    fun gotoMarket() {
        println("gotoMarket")
        val intent = Intent(this@MenuActivity, GroupMarketActivity::class.java)
        startActivity(intent)
    }

    fun gotoBlock() {
        println("gotoBlock")
        val intent = Intent(this@MenuActivity, BlockActivity::class.java)
        startActivity(intent)
    }

    fun gotoBolivar() {
        println("gotoBolivar")
        val intent = Intent(this@MenuActivity, BolivarActivity::class.java)
        startActivity(intent)
    }
}
