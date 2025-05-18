package com.muhammedturgut.todoapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.muhammedturgut.todoapp.data.repo.KayitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KaydetViewModel @Inject constructor(var kayitRepository: KayitRepository) : ViewModel() {

    fun kaydet(kayit_adi:String){
        CoroutineScope(Dispatchers.Main).launch {
            kayitRepository.kaydet(kayit_adi)
        }
    }

}