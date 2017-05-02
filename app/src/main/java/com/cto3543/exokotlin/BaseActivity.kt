package com.cto3543.exokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cto3543.exokotlin.block.BlockChain
import com.cto3543.exokotlin.bolivar.BolivarState
import com.cto3543.exokotlin.bolivar.DolarToday
import com.cto3543.exokotlin.model.State
import redux.api.Store

abstract class BaseActivity : AppCompatActivity() {

    var subscriber: Store.Subscription? = null

    var store: Store<State>? = null
    var storeBlock: Store<BlockChain>? = null
    var storeDolarToday: Store<BolivarState>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        store = (application as ExoKotlinApp).store
        storeBlock = (application as ExoKotlinApp).storeblock
        storeDolarToday = (application as ExoKotlinApp).storeDolarToday
    }

}
