package com.example.kisahnabi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.kisahnabi.DetailActivityRasul
import com.example.kisahnabi.databinding.ItemRecyclerRasulBinding
import com.example.kisahnabi.model.ResponseRasulItem

class RasulAdapter(private val listDataRasul: ArrayList<ResponseRasulItem> = arrayListOf()) :
    RecyclerView.Adapter<RasulAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemRecyclerRasulBinding) : RecyclerView.ViewHolder(binding.root){

    }

    fun addDataRasul(getData: List<ResponseRasulItem>) {
        listDataRasul.clear()
        listDataRasul.addAll(getData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itembinding = ItemRecyclerRasulBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nabi = listDataRasul[position]
        holder.binding.txtJudulrasul.text = nabi.nama
        holder.binding.txtDeskripsirasul.text = nabi.deskripsi
        holder.binding.imageViewRasul.load(nabi.avatar!!) {
            scale(Scale.FIT)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivityRasul::class.java)
            intent.putExtra(DetailActivityRasul.DATAS, nabi)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listDataRasul.size
}