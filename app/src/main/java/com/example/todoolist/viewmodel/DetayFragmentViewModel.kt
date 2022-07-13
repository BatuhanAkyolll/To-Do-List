package com.example.todoolist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoolist.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor (var krepo : YapilacaklarDaoRepository) : ViewModel() {



    fun guncelle(yapilacak_id : Int ,yapilacak_is : String){
        krepo.yapilacakIsGuncelle(yapilacak_id ,yapilacak_is)
    }
}