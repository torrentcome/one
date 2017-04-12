package com.cto3543.exokotlin

import android.app.Application
import com.cto3543.exokotlin.block.BlockChain
import com.cto3543.exokotlin.bolivar.DolarToday
import com.cto3543.exokotlin.middlewares.createLoggerMiddleware
import com.cto3543.exokotlin.model.State
import com.cto3543.exokotlin.reducer.blockReducer
import com.cto3543.exokotlin.reducer.dolarTodayReducer
import com.cto3543.exokotlin.reducer.mainReducer
import redux.api.Store
import redux.applyMiddleware
import redux.createStore

/**
 * Created by cto3543 on 29/03/2017.
 */
class ExoKotlinApp : Application() {

    var store: Store<State>? = null

    var storeblock: Store<BlockChain>? = null

    var storeDolarToday: Store<DolarToday>? = null

    override fun onCreate() {
        super.onCreate()
        store = createStore(mainReducer, State(), applyMiddleware(createLoggerMiddleware()))
        storeblock = createStore(blockReducer, BlockChain(), applyMiddleware(createLoggerMiddleware()))
        storeDolarToday = createStore(dolarTodayReducer, DolarToday(), applyMiddleware(createLoggerMiddleware()))
    }
}