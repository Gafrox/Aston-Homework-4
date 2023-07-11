package ru.gustavo.astonhomework42

import io.github.serpro69.kfaker.Faker

class UserRepository {
    val photos = PhotosEnum.values()
    private var id = 0
    private fun generateUsers(): List<User> {
        val list = mutableListOf<User>()
        repeat(10) {
            list.add(id, createUser())
            id += 1
        }
        return list
    }

    private fun createUser(): User {
        val faker = Faker()
        return User(
            id = id,
            firstName = faker.name.firstName(),
            lastName = faker.name.lastName(),
            phoneNumber = faker.phoneNumber.phoneNumber(),
            photo = photos.random().photo
        )
    }

    companion object {
        val users = UserRepository().generateUsers()
    }
}