package com.example.viewdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewdata.databinding.ActivityRecylerBinding

class RecylerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecylerBinding

    // Data buah dan gambar yang akan ditampilkan
    private val dataBuah = arrayOf(
        "Alpukat", "Durian", "Jambu Air", "Manggis", "Strawberry"
    )

    private val dataGambar = arrayOf(
        R.drawable.alpukat,
        R.drawable.durian,
        R.drawable.jambuair,
        R.drawable.manggis,
        R.drawable.strawberry
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding
        binding = ActivityRecylerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Membuat instance dari BuahAdapter
        val adapter = BuahAdapter(this, dataBuah, dataGambar)

        // Membuat LayoutManager untuk RecyclerView
        val layoutManager = LinearLayoutManager(this)


        // Menetapkan adapter dan layout manager ke RecyclerView
        binding.recylerView.adapter = adapter
        binding.recylerView.layoutManager = layoutManager
    }
}
