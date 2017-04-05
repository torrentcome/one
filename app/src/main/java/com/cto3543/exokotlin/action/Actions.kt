package com.cto3543.exokotlin.action

import com.cto3543.exokotlin.block.Block
import com.cto3543.exokotlin.groupmarket.GroupMarkets
import com.cto3543.exokotlin.groupmarket.Market
import com.cto3543.exokotlin.model.Summary

/**
 * Created by cto3543 on 30/03/2017.
 */
sealed class Action {

    // state
    class getState : Action()

    class getMarkets(val groupMarkets: GroupMarkets?) : Action()
    class getSummary(val summary: Summary?) : Action()
    class setCurrentList(val currency: String?, val exchange: List<Market>?) : Action()
    class setCurrentSummary(val currency: String?, val currencyPair: String?) : Action()

    // block
    class getStateBlock : Action()

    class setCurrentBlock(val currentblock: Block?) : Action()
    class setCurrentListBlock(val listBlock: ArrayList<Block>?) : Action()
}
