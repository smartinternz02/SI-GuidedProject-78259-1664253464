package com.example.groceryapp.models

class PopularModel {
    var name: String? = null
    var description: String? = null
    var rating: String? = null
    var discount: String? = null
    var type: String? = null
    var img_url: String? = null

    constructor() {}
    constructor(
        name: String?,
        description: String?,
        rating: String?,
        discount: String?,
        type: String?,
        img_url: String?
    ) {
        this.name = name
        this.description = description
        this.rating = rating
        this.discount = discount
        this.type = type
        this.img_url = img_url
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PopularModel

        if (name != other.name) return false
        if (description != other.description) return false
        if (rating != other.rating) return false
        if (discount != other.discount) return false
        if (type != other.type) return false
        if (img_url != other.img_url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (rating?.hashCode() ?: 0)
        result = 31 * result + (discount?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (img_url?.hashCode() ?: 0)
        return result
    }

}