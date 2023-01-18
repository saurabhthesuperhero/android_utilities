package com.developersmarket.myapplication

import android.os.Bundle

//val name = bundle.getValue("name", "unknown")
//val age = bundle.getValue("age", 0)
inline fun <reified T : Any> Bundle.getValue(key: String, defaultValue: T? = null): T? {
    return when (val value = get(key)) {
        is T -> value
        else -> {
            if (value != null && value::class.java.isAssignableFrom(T::class.java)) {
                @Suppress("UNCHECKED_CAST")
                value as T
            } else {
                defaultValue
            }
        }
    }
}
