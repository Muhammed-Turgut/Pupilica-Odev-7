package com.muhammedturgut.todoapp.di

import android.content.Context
import androidx.room.Room
import androidx.transition.Visibility
import com.muhammedturgut.todoapp.data.dataSource.DataSource
import com.muhammedturgut.todoapp.data.repo.KayitRepository
import com.muhammedturgut.todoapp.room.KayitDao
import com.muhammedturgut.todoapp.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKayitRepostory(kayitDataSource: DataSource): KayitRepository{
        return KayitRepository(kayitDataSource)
    }

    @Provides
    @Singleton
    fun provideKayitDataSource(kayitDao: KayitDao): DataSource{
        return DataSource(kayitDao)
    }

    @Provides
    @Singleton
    fun provideKayitDao(@ApplicationContext context: Context): KayitDao{

        val veriTabani = Room.databaseBuilder(context, VeriTabani::class.java,"kayitdb.db")
            .createFromAsset("kayitdb.db")
            .build()

        return veriTabani.getKayitDao()
    }

}