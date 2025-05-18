package com.muhammedturgut.todoapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammedturgut.todoapp.data.entity.Kayit
import com.muhammedturgut.todoapp.data.repo.KayitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor(var kayitRepository: KayitRepository): ViewModel() {
    var kayitListesi = MutableLiveData<List<Kayit>>()

    init {
        kayitListesi
        kayitYukle()
    }

     fun kayitYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            kayitListesi.value = kayitRepository.kayitYukle()
        }
    }

     fun sil(kayit_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
        kayitRepository.sil(kayit_id)
            kayitYukle()
        }
    }

     fun ara(aramaKelimesi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            kayitListesi.value = kayitRepository.ara(aramaKelimesi)
        }
    }
}