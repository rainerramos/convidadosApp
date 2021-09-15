package com.rainerramos.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.rainerramos.convidados.service.constants.DataBaseConstants
import com.rainerramos.convidados.service.model.GuestModel
import java.sql.DatabaseMetaData

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository


        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel): Boolean {
        return try {

            val db = mGuestDataBaseHelper.writableDatabase

            val contentvalues = ContentValues()
            contentvalues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentvalues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentvalues)
            true
        } catch (e: Exception) {
            false
        }
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


    fun update(guest: GuestModel): Boolean {
        return try {

            val db = mGuestDataBaseHelper.writableDatabase

            val contentvalues = ContentValues()
            contentvalues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentvalues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentvalues, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {

            val db = mGuestDataBaseHelper.writableDatabase
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

}