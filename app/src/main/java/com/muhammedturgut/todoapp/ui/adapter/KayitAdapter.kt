package com.muhammedturgut.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.muhammedturgut.todoapp.data.entity.Kayit
import com.muhammedturgut.todoapp.databinding.TodoRecyclerRowBinding
import com.muhammedturgut.todoapp.ui.fragment.AnaSayfaFragmentDirections
import com.muhammedturgut.todoapp.ui.viewModel.AnaSayfaViewModel
import com.muhammedturgut.todoapp.utils.gecisYap

class KayitAdapter(var mContext: Context,
                   var kayitListesi : List<Kayit>,
                   var viewModel: AnaSayfaViewModel): RecyclerView.Adapter<KayitAdapter.CardDesign>() {

    inner class CardDesign(var design: TodoRecyclerRowBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int
    ): CardDesign {
        val design = TodoRecyclerRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesign(design)
    }

    override fun onBindViewHolder(holder: CardDesign,
        position: Int
    ) {
        val kayit = kayitListesi.get(position)
        val t = holder.design

        t.textKayit.text = kayit.kayit

        t.recyclerRow.setOnClickListener {
           val gecis = AnaSayfaFragmentDirections.kayitDetayGecis(kayit=kayit)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Kayitiniz silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    viewModel.sil(kayit.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return kayitListesi.size
    }

}