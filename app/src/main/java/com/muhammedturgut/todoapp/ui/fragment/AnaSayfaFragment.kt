package com.muhammedturgut.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.todoapp.R
import com.muhammedturgut.todoapp.databinding.FragmentAnaSayfaBinding
import com.muhammedturgut.todoapp.ui.adapter.KayitAdapter
import com.muhammedturgut.todoapp.ui.viewModel.AnaSayfaViewModel
import com.muhammedturgut.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnaSayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(layoutInflater,container,false)

        binding.imageViewaAdd.setOnClickListener {
            Navigation.gecisYap(it,R.id.kayitKaydetGecis)
        }

        viewModel.kayitListesi.observe(viewLifecycleOwner){
            val kayitAdapter = KayitAdapter(requireContext(),it,viewModel)
            binding.recyclerViewAnaSayfa.adapter = kayitAdapter
        }

        binding.recyclerViewAnaSayfa.layoutManager = LinearLayoutManager(requireContext())

        binding.searchBar.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Ara buttonuna basılınca
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnaSayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kayitListesi
    }
}
