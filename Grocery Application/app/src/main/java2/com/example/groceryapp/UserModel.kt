package com.example.groceryapp

class UserModel {
    var name: String? = null
    var password: String? = null
    var email: String? = null

    constructor() {}
    constructor(name: String?, password: String?, email: String?) {
        this.name = name
        this.password = password
        this.email = email
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserModel

        if (name != other.name) return false
        if (password != other.password) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (password?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        return result
    }

}