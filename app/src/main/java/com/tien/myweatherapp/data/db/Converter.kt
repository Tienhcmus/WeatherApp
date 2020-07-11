package com.tien.myweatherapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class Converter {

        var gson = Gson()
        @TypeConverter
        fun stringToSomeObjectList(data: String?): List<String> {
            if (data == null) {
                return Collections.emptyList()
            }
            val listType: Type =
                object : TypeToken<List<String?>?>() {}.getType()
            return gson.fromJson(data, listType)
        }

        @TypeConverter
        fun someObjectListToString(someObjects: List<String?>?): String {
            return gson.toJson(someObjects)
        }
}