package com.muhammedturgut.todoapp.data.dataSource

import com.muhammedturgut.todoapp.data.entity.Kayit
import com.muhammedturgut.todoapp.room.KayitDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSource(var kayitDao: KayitDao){
    suspend fun kaydet(kayit_adi:String){
        val yeniKayit = Kayit(0,kayit_adi)
        kayitDao.kaydet(yeniKayit)
    }

    suspend fun guncelle(kayit_id:Int,kayit_adi:String){
      val güncellenenKayit = Kayit(kayit_id,kayit_adi)
      kayitDao.güncelle(güncellenenKayit)
    }

    suspend fun sil(kayit_id:Int){
     val silineneKayit = Kayit(kayit_id,"")
        kayitDao.sil(silineneKayit)
    }

    suspend fun kayitYukle(): List<Kayit> = withContext(Dispatchers.IO){
       return@withContext kayitDao.kayitYukle()
    }

    suspend fun ara(arama_kelimesi:String): List<Kayit> = withContext(Dispatchers.IO){
        return@withContext kayitDao.ara(arama_kelimesi)
    }
}