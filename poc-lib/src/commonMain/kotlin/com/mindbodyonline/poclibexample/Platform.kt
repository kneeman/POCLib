package com.mindbodyonline.poclibexample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform