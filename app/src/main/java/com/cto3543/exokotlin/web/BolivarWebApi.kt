package com.cto3543.exokotlin.web

import com.cto3543.exokotlin.bolivar.DolarToday
import com.github.kittinunf.fuel.core.FuelError

/**
 * Created by cto3543 on 10/04/2017.
 */
object BolivarWebApi{

    fun getDolartoday():Pair<DolarToday, FuelError?> = CryptoWebApi.callGetRequest("https://s3.amazonaws.com/dolartoday/data.json", DolarToday::class.java)

    fun getRomarcaEnvios():Pair<String, FuelError?> = CryptoWebApi.callGetRequest("https://www.romarcaenvios.com/", String::class.java)

}