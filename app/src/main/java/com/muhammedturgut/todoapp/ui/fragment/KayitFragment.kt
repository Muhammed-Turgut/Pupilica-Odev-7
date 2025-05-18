package com.muhammedturgut.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.muhammedturgut.todoapp.R
import com.muhammedturgut.todoapp.databinding.FragmentKayitBinding
import com.muhammedturgut.todoapp.ui.viewModel.KaydetViewModel
import com.muhammedturgut.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding
    private val viewModel: KaydetViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(layoutInflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val kayit = binding.editTextAciklama.text.toString()
            viewModel.kaydet(kayit)
        }

        binding.imageViewBack.setOnClickListener {
            Navigation.gecisYap(it, R.id.anaSayfaFragment)
        }

        return binding.root
    }
}
