package ru.gustavo.astonhomework42

data class User(
    val id: Int,
    var photo: Int? = null,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String
)