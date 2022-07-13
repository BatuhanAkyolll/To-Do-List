package com.example.todoolist.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoolist.data.entity.Yapilacaklar
import com.example.todoolist.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var ydao:YapilacaklarDao) {
    var yapilacaklarListesi : MutableLiveData<List<Yapilacaklar>>

    init {
        yapilacaklarListesi = MutableLiveData()
    }
    fun yapilacakIsleriGetir() : MutableLiveData<List<Yapilacaklar>>{

        return yapilacaklarListesi
    }

    fun yapilacakIsKayit(yapilacak_is : String){
        val job = CoroutineScope(Dispatchers.Main).launch {
           val yeniyapilacak = Yapilacaklar(0,yapilacak_is)
            ydao.yapilacakEkle(yeniyapilacak)
        }
    }

    fun yapilacakIsGuncelle (yapilacak_id: Int, yapilacak_is : String){

        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenyapilacak = Yapilacaklar(yapilacak_id,yapilacak_is)
            ydao.yapilacakGuncelle(guncellenenyapilacak)
        }
    }
    fun yapilacakAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value=ydao.yapilacakAra(aramaKelimesi)
        }
    }
    fun yapilacakSil(yapilacak_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenyapilacak = Yapilacaklar(yapilacak_id,"")
            ydao.yapilacakSil(silinenyapilacak)
            tumYapilacakalariAl()
        }
    }
    fun tumYapilacakalariAl(){
      val job = CoroutineScope(Dispatchers.Main).launch {
          yapilacaklarListesi.value=ydao.tumYapilacakIsler()
      }
    }
}