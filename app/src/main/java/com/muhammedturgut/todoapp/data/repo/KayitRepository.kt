package com.muhammedturgut.todoapp.data.repo

import com.muhammedturgut.todoapp.data.dataSource.DataSource
import com.muhammedturgut.todoapp.data.entity.Kayit

class KayitRepository(var kayitlarDataSource: DataSource) {
    suspend fun kaydet(kayit:String,){
        kayitlarDataSource.kaydet(kayit)
    }

    suspend fun guncelle(kayit:String,kayit_id: Int) = kayitlarDataSource.guncelle(kayit_id,kayit)

    suspend fun sil(kayit_id:Int) = kayitlarDataSource.sil(kayit_id)

    suspend fun kayitYukle(): List<Kayit> = kayitlarDataSource.kayitYukle()

    suspend fun ara(aramaKelimesi:String) : List<Kayit> = kayitlarDataSource.ara(aramaKelimesi)
}