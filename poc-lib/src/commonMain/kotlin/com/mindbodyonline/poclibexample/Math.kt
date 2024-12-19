package com.mindbodyonline.poclibexample

import com.mindbodyonline.poclibexample.data.WrappedIntegers

class Math {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * POC Can iOS receive data classes?
     */
    fun addAndReturnDataClass(a: Int, b: Int): WrappedIntegers {
        return WrappedIntegers(a + b)
    }
}