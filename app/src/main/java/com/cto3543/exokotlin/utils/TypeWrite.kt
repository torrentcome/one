package com.cto3543.exokotlin.utils

import android.content.Context
import android.os.Handler
import android.view.ViewManager
import android.widget.TextView
import org.jetbrains.anko.custom.ankoView
import java.util.*

/**
 * Created by cto3543 on 12/04/2017.
 */
class TypeWrite(context: Context) : TextView(context) {

    val MAX_DELAY: Int = 150
    val MIN_DELAY: Int = 0
    val random: Random = Random()

    var mText: CharSequence? = null
    var mIndex: Int = 0
    val mHandler: Handler? = Handler()
    var mDelay: Int = random.nextInt(MAX_DELAY + 1 - MIN_DELAY) + MIN_DELAY

    val characterAdder: Runnable = Runnable {
        run {
            setText(mText?.subSequence(0, mIndex++))
            var lenght: Int = mText?.length as Int
            if (mIndex <= lenght)
                mHandler?.postDelayed(characterAdder, mDelay.toLong())
        }
    }

    fun animateText(text: CharSequence) {
        mText = text
        mIndex = 0

        setText("")
        mHandler?.removeCallbacks { characterAdder }
        mHandler?.postDelayed(characterAdder, mDelay.toLong())
    }
}

inline fun ViewManager.typeWrite(context: Context) = TypeWrite(context)
inline fun ViewManager.typeWrite(theme: Int = 0, init: TypeWrite.() -> Unit) = ankoView(::TypeWrite, theme, init)