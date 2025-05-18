package com.muhammedturgut.todoapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.muhammedturgut.todoapp.data.repo.KayitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class DetaylarViewModel @Inject constructor(var kayitRepository: KayitRepository) : ViewModel(){
    fun guncelle(kayit_id: Int, kayit: String){
        CoroutineScope(Dispatchers.Main).launch {
            kayitRepository.guncelle(kayit,kayit_id)
        }
    }

    fun sil(kayit_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            kayitRepository.sil(kayit_id)
        }
    }
}