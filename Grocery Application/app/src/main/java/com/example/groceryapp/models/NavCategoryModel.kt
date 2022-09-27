package com.example.groceryapp.models

class NavCategoryModel {
    var name: String? = null
    var discount: String? = null
    var img_url: String? = null

    constructor() {}
    constructor(name: String?, discount: String?, img_url: String?) {
        this.name = name
        this.discount = discount
        this.img_url = img_url
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NavCategoryModel

        if (name != other.name) return false
        if (discount != other.discount) return false
        if (img_url != other.img_url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (discount?.hashCode() ?: 0)
        result = 31 * result + (img_url?.hashCode() ?: 0)
        return result
    }


}