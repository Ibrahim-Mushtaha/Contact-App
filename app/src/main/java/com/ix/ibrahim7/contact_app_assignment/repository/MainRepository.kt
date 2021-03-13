package com.ix.ibrahim7.contact_app_assignment.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.ix.ibrahim7.contact_app_assignment.model.User
import com.ix.ibrahim7.contact_app_assignment.util.Resource

class MainRepository private constructor() {


    val UserLiveData = MutableLiveData<Resource<ArrayList<User>>>()

    fun addUser(user: User) = FirebaseFirestore.getInstance().collection("user").add(user)


    fun getAllUsers() {
        UserLiveData.postValue(Resource.Loading())
        val arrayList = ArrayList<User>()
            FirebaseFirestore.getInstance().collection("user")
                .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    arrayList.clear()
                    for (item in querySnapshot!!.documents) arrayList.add(item.toObject(User::class.java)!!)
                    UserLiveData.postValue(Resource.Success(arrayList))
                }
    }

    companion object {
        @Volatile
        private var instance: MainRepository? = null
        private val LOCK = Any()

        operator fun invoke() =
            instance ?: synchronized(LOCK) {
                instance ?: createMainActivityRepository().also {
                    instance = it
                }
            }

        private fun createMainActivityRepository() = MainRepository()
    }


}