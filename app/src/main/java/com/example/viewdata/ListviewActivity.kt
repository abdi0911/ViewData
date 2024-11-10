package com.example.viewdata

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.viewdata.databinding.ActivityListviewBinding
import java.util.Arrays

class ListviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding
        binding = ActivityListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data array dari resources
        val dataArray: Array<String> = resources.getStringArray(R.array.jurusan)

        // Mengurutkan array
        Arrays.sort(dataArray)

        // Menyiapkan adapter untuk ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataArray)
        binding.listView.adapter = adapter
    }
}
