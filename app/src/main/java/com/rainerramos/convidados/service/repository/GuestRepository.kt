package com.rainerramos.convidados.service.repository

import android.content.Context
import com.rainerramos.convidados.service.model.GuestModel

class GuestRepository private constructor(context: Context){

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object{
        private lateinit var repository: GuestRepository


        fun getInstance(context: Context) : GuestRepository {
            if(!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel) {
        mGuestDataBaseHelper.writableDatabase
    }


    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    //CRUD - Create, Read, Update, Delete



    fun update(guest: GuestModel) {
    }

    fun delete(guest: GuestModel) {
    }

}