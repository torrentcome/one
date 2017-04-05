package com.cto3543.exokotlin.groupmarket

import java.io.Serializable

/**
 * Created by cto3543 on 30/03/2017.
 */
data class GroupMarkets(val result: List<Market>)

data class Market(val exchange: String, val currencyPair: String) : Serializable {
}