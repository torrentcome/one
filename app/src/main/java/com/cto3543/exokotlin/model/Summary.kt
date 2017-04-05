package com.cto3543.exokotlin.model

/**
 * Created by cto3543 on 30/03/2017.
 */
data class Summary(val result: Result, val allowance: Allowance)

data class Result(val price: Price, val volume: String)

data class Price(val last: String, val high: String, val low: String, val change: Change)

data class Change(val percentage: String, val absolute: String)

data class Allowance(val cost: String, val remaining: String)

