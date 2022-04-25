package com.makeevrserg.todolist.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import com.makeevrserg.todolist.data.network.models.Additional
import java.lang.Exception
import java.lang.reflect.Type


object MyConverter {
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    inline fun <reified T> fromObject(obj: T): String {
        return Gson().toJson(obj)
    }

    @TypeConverter
    inline fun <reified T> fromJson(json: String): T? {
        return try {
//            val listType: Type = object : TypeToken<ArrayList<T?>?>() {}.type
            return Gson().fromJson(json, T::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}

object Converter {
    @TypeConverter
    fun fromLocation(obj: Additional): String = MyConverter.fromObject(obj)

    @TypeConverter
    fun toLocation(json: String): Additional {
        return MyConverter.fromJson<Additional>(json) ?: Additional()
    }
}