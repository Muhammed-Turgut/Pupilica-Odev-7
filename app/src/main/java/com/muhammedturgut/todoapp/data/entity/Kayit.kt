package com.muhammedturgut.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "kayitdb")
data class Kayit(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") @NotNull var id: Int,

    @ColumnInfo(name = "kayit") @NotNull var kayit:String): Serializable{}
