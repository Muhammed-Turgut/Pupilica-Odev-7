package com.muhammedturgut.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.muhammedturgut.todoapp.data.entity.Kayit

@Dao
interface KayitDao {

    @Query("SELECT * FROM kayitdb")
    suspend fun kayitYukle(): List<Kayit>

    @Insert
    suspend fun kaydet(kayit: Kayit)

    @Delete
    suspend fun sil(kayit: Kayit)

    @Update
    suspend fun güncelle(kayit: Kayit)

    @Query("SELECT * FROM kayitdb WHERE kayit LIKE '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi: String): List<Kayit>
}