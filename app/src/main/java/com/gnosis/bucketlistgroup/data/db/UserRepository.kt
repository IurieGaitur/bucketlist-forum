package com.gnosis.bucketlistgroup.data.db

import com.gnosis.bucketlistgroup.util.RxSchedulers

class UserRepository(val db: AppDatabase, rxSchedulers: RxSchedulers) {

    fun insertUser(user: User) {
        db.userDao().insert(user)
    }
}