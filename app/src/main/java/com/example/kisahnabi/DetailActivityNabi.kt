package com.example.kisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.kisahnabi.databinding.ActivityDetailNabiBinding
import com.example.kisahnabi.model.ResponseNabiItem

class DetailActivityNabi : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNabiBinding

    companion object {
        const val DATA = "MWHEHE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNabiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataItem = intent.getParcelableExtra<ResponseNabiItem>(DATA)

        with(binding) {
            imageView2.load(dataItem!!.avatar)
            txtJuduls.text = dataItem.nama
            txtDesk.text = dataItem.deskripsi
            txtLahir.text = dataItem.tempat
            txtUsia.text = dataItem.usia
        }
    }
}