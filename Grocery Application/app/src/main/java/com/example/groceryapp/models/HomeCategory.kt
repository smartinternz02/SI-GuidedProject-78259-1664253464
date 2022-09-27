package com.example.groceryapp.models

class HomeCategory {
    var name: String? = null
    var type: String? = null
    var img_url: String? = null

    constructor() {}
    constructor(name: String?, type: String?, img_url: String?) {
        this.name = name
        this.type = type
        this.img_url = img_url
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HomeCategory

        if (name != other.name) return false
        if (type != other.type) return false
        if (img_url != other.img_url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (img_url?.hashCode() ?: 0)
        return result
    }


}