package com.cto3543.exokotlin.utils

import android.graphics.Camera
import android.graphics.Matrix
import android.view.animation.Animation
import android.view.animation.Transformation

/**
 * Created by cto3543 on 03/04/2017.
 */
class Rotate3dAnimation : Animation {
    var mFromDegrees: Float = 0.0f
    var mToDegrees: Float = 0.0f
    var mCenterX: Float = 0.0f
    var mCenterY: Float = 0.0f
    var mDepthZ: Float = 0.0f
    var mReverse: Boolean = false
    var mCamera: Camera? = null

    constructor(fromDegrees: Float, toDegrees: Float,
                centerX: Float, centerY: Float, depthZ: Float, reverse: Boolean) {
        mFromDegrees = fromDegrees
        mToDegrees = toDegrees
        mCenterX = centerX
        mCenterY = centerY
        mDepthZ = depthZ
        mReverse = reverse
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        mCamera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val fromDegrees: Float = mFromDegrees
        val degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime)
        val centerX: Float = mCenterX
        val centerY: Float = mCenterY
        val camera: Camera? = mCamera
        val matrix: Matrix = t?.matrix as Matrix
        camera?.save()
        if (mReverse) {
            camera?.translate(0.0f, 0.0f, mDepthZ * interpolatedTime)
        } else {
            camera?.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime))
        }
        camera?.rotateY(degrees)
        camera?.getMatrix(matrix)
        camera?.restore()
        matrix.preTranslate(-centerX, -centerY)
        matrix.postTranslate(centerX, centerY)
    }
}
