package com.example.viewdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewdata.databinding.ActivityDetailBuahBinding

class DetailBuahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBuahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding
        binding = ActivityDetailBuahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menangkap data dari Intent
        val namaBuah = intent.getStringExtra("nama") ?: "Nama Buah Tidak Ditemukan"
        val image = intent.getIntExtra("gambar", 0)

        // Menampilkan data yang diterima ke layout
        binding.tvNamaBuah.text = namaBuah
        if (image != 0) {
            binding.imgBuah.setImageResource(image)
        }
    }
}
