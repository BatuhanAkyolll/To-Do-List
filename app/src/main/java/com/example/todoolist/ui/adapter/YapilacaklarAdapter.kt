package com.example.todoolist.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoolist.R
import com.example.todoolist.databinding.CardTasarimBinding
import com.example.todoolist.data.entity.Yapilacaklar
import com.example.todoolist.ui.fragment.AnasayfaFragmentDirections
import com.example.todoolist.util.gecisYap
import com.example.todoolist.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext:Context,
                          var yapilacaklarListesi:List<Yapilacaklar>,
                          var viewModel: AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.cardTasarimTutuci>() {
    inner class cardTasarimTutuci(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim : CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutuci {
        val layoutInflater = LayoutInflater.from(mContext)
        val  tasarim :CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim ,parent,false)
        return cardTasarimTutuci(tasarim)
    }

    override fun onBindViewHolder(holder: cardTasarimTutuci, position: Int) {
        val yapilacak =yapilacaklarListesi.get(position)
        val t= holder.tasarim
        t.yapilacakNesnesi = yapilacak

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.isDetayGecis(yapilacak = yapilacak)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_is} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                   viewModel.sil(yapilacak.yapilacak_id)
                }.show()


        }

    }

    override fun getItemCount(): Int {
        return  yapilacaklarListesi.size

    }

}