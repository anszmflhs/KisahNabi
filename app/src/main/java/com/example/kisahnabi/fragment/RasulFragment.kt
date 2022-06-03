package com.example.kisahnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kisahnabi.adapter.RasulAdapter
import com.example.kisahnabi.databinding.FragmentRasulBinding
import com.example.kisahnabi.model.ResponseRasulItem
import com.example.kisahnabi.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RasulFragment : Fragment() {

    private lateinit var binding: FragmentRasulBinding
    val rasulAdapter = RasulAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRasulBinding.inflate(inflater, container, false)
        with(binding) {
            recyclerRasul.setHasFixedSize(true)
            recyclerRasul.adapter = rasulAdapter
            recyclerRasul.layoutManager = GridLayoutManager(context,2)
        }
        val call = RetrofitServices.getDatas().getDataRasul()
        call.enqueue(object : Callback<List<ResponseRasulItem>> {
            override fun onResponse(
                call: Call<List<ResponseRasulItem>>,
                response: Response<List<ResponseRasulItem>>
            ) {
                val listDatas = response.body()!!
                listDatas.let { it.let { it1 -> rasulAdapter.addDataRasul(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseRasulItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return binding.root
    }
}