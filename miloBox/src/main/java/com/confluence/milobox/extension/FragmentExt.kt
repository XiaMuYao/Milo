package com.confluence.milobox.extension

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
inline fun <T> Fragment.lazyArgument(key: String, defaultValue: T) = lazy {
//    arguments?.let { get(it, key, defaultValue) }
    arguments?.get(key) as? T ?: defaultValue
}

inline fun <T> Fragment.intentExtra(key: String, defaultValue: T) = lazy {
    activity?.intent?.extras?.get(key) as? T ?: defaultValue
}


internal fun <T> get(arguments: Bundle, key: String, defaultValue: T): Any? {
    return when (defaultValue) {
        // Scalars
        is Boolean -> arguments.getBoolean(key, defaultValue)
        is Byte -> arguments.getByte(key, defaultValue)
        is Char -> arguments.getChar(key, defaultValue)
        is Double -> arguments.getDouble(key, defaultValue)
        is Float -> arguments.getFloat(key, defaultValue)
        is Int -> arguments.getInt(key, defaultValue)
        is Long -> arguments.getLong(key, defaultValue)
        is Short -> arguments.getShort(key, defaultValue)

        // References
        is Bundle -> arguments.getBundle(key)
        is CharSequence -> arguments.getCharSequence(key, defaultValue)
//        is Parcelable -> arguments.getParcelable(value)

//        // Scalar arrays
//        is BooleanArray -> arguments.putExtra(key, defaultValue)
//        is ByteArray ->arguments. putExtra(key, defaultValue)
//        is CharArray -> arguments.putExtra(key, defaultValue)
//        is DoubleArray -> arguments.putExtra(key, defaultValue)
//        is FloatArray ->arguments. putExtra(key, defaultValue)
//        is IntArray ->arguments. putExtra(key, defaultValue)
//        is LongArray ->arguments. putExtra(key, defaultValue)
//        is ShortArray -> arguments.putExtra(key, defaultValue)

//        // Reference arrays
//        is Array<*> -> {
//            val componentType = key::class.java.componentType!!
//            @Suppress("UNCHECKED_CAST") // Checked by reflection.
//            when {
//                Parcelable::class.java.isAssignableFrom(componentType) -> {
//                    arguments.getParcelableArray (key, key as Array<Parcelable>)
//                }
//                String::class.java.isAssignableFrom(componentType) -> {
//                    arguments.   getStringArrayList(key, key as Array<String>)
//                }
//                CharSequence::class.java.isAssignableFrom(componentType) -> {
//                    arguments.   getCharSequenceArray(key, key as Array<CharSequence>)
//                }
//                java.io.Serializable::class.java.isAssignableFrom(componentType) -> {
//                    arguments.   putExtra(key, defaultValue)
//                }
//                else -> {
//                    val valueType = componentType.canonicalName
//                    throw IllegalArgumentException(
//                        "Illegal value array type $valueType for key \"$key\""
//                    )
//                }
//            }
//        }


        else -> {
            val valueType = key.javaClass.canonicalName
            throw IllegalArgumentException("Illegal value type $valueType for key \"$key\"")
            null
        }
    }
}