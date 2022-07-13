package com.example.todoolist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoolist.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor (var krepo : YapilacaklarDaoRepository) : ViewModel() {


    fun kaydet(yapilacak_is : String){
        krepo.yapilacakIsKayit(yapilacak_is)
    }
}