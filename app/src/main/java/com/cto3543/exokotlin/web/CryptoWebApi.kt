package com.cto3543.exokotlin.web

import com.cto3543.exokotlin.groupmarket.GroupMarkets
import com.cto3543.exokotlin.model.Summary
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson

/**
 * Created by cto3543 on 30/03/2017.
 */
object CryptoWebApi {

    fun getMarkets(): Pair<GroupMarkets, FuelError?> = callGetRequest("https://api.cryptowat.ch/groupMarkets", GroupMarkets::class.java)

    fun getSummary(currency: String?, exchange: String?): Pair<Summary, FuelError?> = callGetRequest("https://api.cryptowat.ch/groupMarkets/$exchange/$currency" + "/summary", Summary::class.java)

    fun <T> callGetRequest(url: String, clazz: Class<T>): Pair<T, FuelError?> {
        val (request, response, result) = url.httpGet().responseString()
        val (data, error) = result
        return kotlin.Pair(Gson().fromJson(data, clazz), error)
    }

}