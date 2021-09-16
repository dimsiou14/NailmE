package com.example.nails

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class SQLiteHelper(context:Context):SQLiteOpenHelper( context , DATABASE_NAME , null , DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = "1"
        private const val DATABASE_NAME = "bookings.db"
        private const val TBL_BOOKINGS = "tbl_bookings"
        private const val username = "username"
        private const val password = "password"
        private const val email = "email"
        private const val phone = "phone"
        private const val date = "date"
        private const val time = "time"

     }




    override fun onCreate(db: SQLiteDatabase?) {
        val createTbl =
            ("CREATE TABLE" + "TBL_BOOKINGS" + "(" + username + "TEXT" + password + "CHAR" + email + "EMAIL" + phone + "NUMERIC" + date + "DATE" + time + "TIME" + ")")
        db?.execSQL(createTbl)
    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    db!!.execSQL("drop table if exists $TBL_BOOKINGS")
        onCreate(db)

    }

    fun insertBookings(std:BookingModel): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(username , std.username)
        contentValues.put(password , std.password)
        contentValues.put(email , std.email)
        contentValues.put(phone , std.phone)
        contentValues.put(date , std.date)
        contentValues.put(time , std.time)

        val success = db.insert(TBL_BOOKINGS,null,contentValues)
        db.close()
        return success
    }

    fun viewBookings(): ArrayList<BookingModel>{
        val stdList : ArrayList<BookingModel> = ArrayList()
        val selectQuery = "SELECT username , date , time  FROM $TBL_BOOKINGS"
        val db=this.readableDatabase

        val cursor:Cursor?

        try {
            cursor = db.rawQuery(selectQuery , null)
        }
        catch (e:Exception){

            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
    }
}