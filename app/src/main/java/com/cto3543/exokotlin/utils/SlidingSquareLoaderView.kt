package com.cto3543.exokotlin.utils

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.custom.ankoView


/**
 * Created by cto3543 on 12/04/2017.
 */
class SlidingSquareLoaderView(context: Context) : com.hamza.slidingsquaresloaderview.SlidingSquareLoaderView(context)

inline fun ViewManager.slidingSquareLoader(context: Context) = SlidingSquareLoaderView(context)
inline fun ViewManager.slidingSquareLoader(theme: Int = 0, init: SlidingSquareLoaderView.() -> Unit) = ankoView(::SlidingSquareLoaderView, theme, init)