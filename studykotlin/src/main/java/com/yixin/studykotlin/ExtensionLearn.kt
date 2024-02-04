package com.yixin.studykotlin

import android.content.res.Resources
import android.util.TypedValue

class ExtensionLearn {
    
    val Float.dp
        get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
        )
    
    fun test() {
        
    }
}