package com.example.appretrofit

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appretrofit.databinding.InfoFragmentBinding

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()
    private lateinit var binding: InfoFragmentBinding

    private lateinit var myAdapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InfoFragmentBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        viewModel.init()
        initRecycler()
        observe()

        binding.refresh.setOnRefreshListener {
            myAdapter.clearData()
            viewModel.init()
        }
    }


    private fun initRecycler() {
        myAdapter = RecyclerAdapter(object: IOnclick {
            override fun sendUserId(id: Int?) {
                val intent = Intent(requireContext(), DetailsActivity::class.java)
                intent.putExtra("ID", id)
                startActivity(intent)
            }

        })
        binding.recycler.layoutManager = LinearLayoutManager(requireActivity())
        binding.recycler.adapter = myAdapter
    }

    private fun observe() {
        viewModel._loadingLiveData.observe(viewLifecycleOwner) {
            binding.refresh.isRefreshing = it
        }

        viewModel._countryLiveData.observe(viewLifecycleOwner) {
            it.toMutableList().let { it1 -> myAdapter.setData(it1) }
        }
    }

}