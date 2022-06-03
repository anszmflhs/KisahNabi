package com.example.kisahnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisahnabi.R
import com.example.kisahnabi.adapter.NabiAdapter
import com.example.kisahnabi.databinding.FragmentNabiBinding
import com.example.kisahnabi.model.ResponseNabiItem
import com.example.kisahnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NabiFragment : Fragment() {

    private lateinit var binding: FragmentNabiBinding
    val nabiAdapter = NabiAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNabiBinding.inflate(inflater, container, false)
        with(binding) {
            recyclerNabi.setHasFixedSize(true)
            recyclerNabi.adapter = nabiAdapter
            recyclerNabi.layoutManager = GridLayoutManager(context,2)
        }
        val call = RetrofitService.getData().getDataNabi()
        call.enqueue(object : Callback<List<ResponseNabiItem>> {
            override fun onResponse(
                call: Call<List<ResponseNabiItem>>,
                response: Response<List<ResponseNabiItem>>
            ) {
                val listData = response.body()!!
                listData.let { it.let { it1 -> nabiAdapter.addDataNabi(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseNabiItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return binding.root
    }
}