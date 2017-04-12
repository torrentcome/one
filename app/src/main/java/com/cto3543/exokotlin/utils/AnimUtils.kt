package com.cto3543.exokotlin.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator

/**
 * Created by cto3543 on 11/04/2017.
 */
object AnimUtils {

    fun createAnim(image : View){
        val centerX: Float = (image.width / 2).toFloat()
        val centerY: Float = (image.height / 2).toFloat()

        val rotation: Rotate3dAnimation = Rotate3dAnimation(0f, 360f, centerX, centerY, 0.0f, true)
        rotation.setDuration(1000);               // duration in ms
//                rotation.setFillAfter(true);               // keep rotation after animation
        rotation.setInterpolator(LinearInterpolator())
        rotation.repeatCount = Animation.INFINITE
        image.startAnimation(rotation)
    }

    fun clearAnimation(image : View){
        image.clearAnimation()
    }

}