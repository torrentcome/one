package com.cto3543.exokotlin.model

import com.cto3543.exokotlin.groupmarket.GroupMarkets
import com.cto3543.exokotlin.groupmarket.Market

/**
 * Created by cto3543 on 30/03/2017.
 */
data class State(val summary: Summary? = null, val groupMarkets: GroupMarkets? = null, val exchange: List<Market>? = null, val currency: String? = null, val currencyPair: String? = null)