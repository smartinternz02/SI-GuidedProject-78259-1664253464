package com.example.groceryapp.models

class RecommendedModel {
    var name: String? = null
    var description: String? = null
    var rating: String? = null
    var img_url: String? = null
    var price = 0

    constructor() {}
    constructor(
        name: String?,
        description: String?,
        rating: String?,
        img_url: String?,
        price: Int
    ) {
        this.name = name
        this.description = description
        this.rating = rating
        this.img_url = img_url
        this.price = price
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecommendedModel

        if (name != other.name) return false
        if (description != other.description) return false
        if (rating != other.rating) return false
        if (img_url != other.img_url) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (rating?.hashCode() ?: 0)
        result = 31 * result + (img_url?.hashCode() ?: 0)
        result = 31 * result + price
        return result
    }

}