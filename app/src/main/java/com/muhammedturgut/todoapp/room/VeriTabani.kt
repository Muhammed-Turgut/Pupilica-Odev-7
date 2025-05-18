package com.muhammedturgut.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammedturgut.todoapp.data.entity.Kayit

@Database(entities = [Kayit::class], version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun getKayitDao() : KayitDao
}