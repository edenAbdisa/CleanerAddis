package com.iyoa.cleanaddis.repository.common

import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.data.user.UserDAO

class UserRepository (val userDAO: UserDAO) {
    fun findUserByUsername(username: String): User {
        return userDAO.findUserByUsername(username)
    }
}