package com.example.kisahnabi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.bumptech.glide.Glide
import com.example.kisahnabi.DetailActivityNabi
import com.example.kisahnabi.databinding.ItemRecyclerNabiBinding
import com.example.kisahnabi.model.ResponseNabiItem

class NabiAdapter(private val listDataNabi: ArrayList<ResponseNabiItem> = arrayListOf()) :
    RecyclerView.Adapter<NabiAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNabi(getData: List<ResponseNabiItem>) {
        listDataNabi.clear()
        listDataNabi.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemRecyclerNabiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itembinding =
            ItemRecyclerNabiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nabi = listDataNabi[position]
        holder.binding.txtJudul.text = nabi.nama
        holder.binding.txtDeskripsi.text = nabi.deskripsi
        holder.binding.imageView.load(nabi.avatar!!) {
            scale(Scale.FIT)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivityNabi::class.java)
            intent.putExtra(DetailActivityNabi.DATA, nabi)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listDataNabi.size
}