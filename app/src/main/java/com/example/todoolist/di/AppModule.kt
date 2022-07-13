package com.example.todoolist.di

import android.content.Context
import androidx.room.Room
import com.example.todoolist.data.repo.YapilacaklarDaoRepository
import com.example.todoolist.room.VeriTabani
import com.example.todoolist.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarDaoRepository(ydao : YapilacaklarDao) :YapilacaklarDaoRepository{
        return YapilacaklarDaoRepository(ydao) // var krepo = YapilacaklarDaoRepository()
    }
    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context: Context) :YapilacaklarDao{
        val vt = Room.databaseBuilder(context,VeriTabani ::class.java,"yapilacaklar.sqlite").createFromAsset("yapilacaklar.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}