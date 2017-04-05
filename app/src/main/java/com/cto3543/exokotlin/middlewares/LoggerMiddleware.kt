package com.cto3543.exokotlin.middlewares

import redux.api.Store
import redux.api.enhancer.Middleware

/**
 * Created by cto3543 on 03/04/2017.
 */
fun <S : Any> createLoggerMiddleware() = Middleware { store: Store<S>, next, action ->
    val result = next.dispatch(action)
    println("Dispatching $action, state= ${store.state}")
    result
}