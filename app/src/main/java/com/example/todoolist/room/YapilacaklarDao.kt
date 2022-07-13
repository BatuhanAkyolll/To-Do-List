package com.example.todoolist.room

import androidx.room.*
import com.example.todoolist.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacakIsler() : List<Yapilacaklar>

    @Insert
    suspend fun yapilacakEkle(yapilacaklar: Yapilacaklar)

    @Update
    suspend fun yapilacakGuncelle(yapilacaklar: Yapilacaklar)

    @Delete
    suspend fun yapilacakSil(yapilacaklar: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi ||'%'")
    suspend fun yapilacakAra(aramaKelimesi : String) : List<Yapilacaklar>
}