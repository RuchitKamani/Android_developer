package com.codestudioapps.photoeffect.frame

import android.view.MotionEvent

interface OnFrameTouchListener {
    fun onFrameTouch(event: MotionEvent)
    fun onFrameDoubleClick(event: MotionEvent)
}
