package com.muhammedturgut.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.muhammedturgut.todoapp.R
import com.muhammedturgut.todoapp.databinding.FragmentDetaylarBinding
import com.muhammedturgut.todoapp.ui.viewModel.DetaylarViewModel
import com.muhammedturgut.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class DetaylarFragment : Fragment() {

    private lateinit var binding: FragmentDetaylarBinding
    private lateinit var viewModel: DetaylarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentDetaylarBinding.inflate(layoutInflater,container,false)
        val bundle : DetaylarFragmentArgs by navArgs()
        val gelenKayit = bundle.kayit

        binding.editTextAciklama.setText(gelenKayit.kayit)

        binding.buttonGuncelle.setOnClickListener {
            val kayit = binding.editTextAciklama.text.toString()
            viewModel.guncelle(kayit = kayit, kayit_id = gelenKayit.id)
        }

        binding.buttonSil.setOnClickListener {
            viewModel.sil(gelenKayit.id)
        }

        binding.imageViewBack.setOnClickListener {
            Navigation.gecisYap(it,R.id.anaSayfaFragment)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetaylarViewModel by viewModels()
        viewModel = tempViewModel
    }
}