package com.graphicless.cricketapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class VenueLiveScore(
    @Json(name = "data")
    val `data`: List<Data>?
) {
    @Entity(tableName = "Venue")
    data class Data(
        @Json(name = "resource")
        var resource: String?,
        @PrimaryKey(autoGenerate = false)
        @Json(name = "id")
        var id: Int?,
        @Json(name = "country_id")
        var countryId: Int?,
        @Json(name = "name")
        var name: String?,
        @Json(name = "city")
        var city: String?,
        @Json(name = "image_path")
        var imagePath: String?,
        @Json(name = "capacity")
        var capacity: Int?,
        @Json(name = "floodlight")
        var floodlight: Boolean?,
        @Json(name = "updated_at")
        var updatedAt: String?
    ){
        constructor(): this(
            resource = "",
            id = 0,
            countryId = 0,
            name = "",
            city = "",
            imagePath = "",
            capacity = 0,
            floodlight = false,
            updatedAt = ""
        )
    }
}