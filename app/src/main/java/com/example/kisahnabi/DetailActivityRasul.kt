package com.example.kisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.kisahnabi.databinding.ActivityDetailRasulBinding
import com.example.kisahnabi.model.ResponseRasulItem

class DetailActivityRasul : AppCompatActivity() {

    private lateinit var binding : ActivityDetailRasulBinding

    companion object {
        const val DATAS = "MWHEHEH"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRasulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataItem = intent.getParcelableExtra<ResponseRasulItem>(DATAS)

        with(binding) {
            imageViewRasul.load(dataItem!!.avatar)
            txtJudulsrasul.text = dataItem.nama
            txtDeskrasul.text = dataItem.deskripsi
            txtLahirrasul.text = dataItem.tempat
            txtUsiarasul.text = dataItem.usia
        }
    }
}