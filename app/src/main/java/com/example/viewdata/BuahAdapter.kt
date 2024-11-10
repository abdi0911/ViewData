package com.example.viewdata

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewdata.databinding.ListItemBinding

// Adapter untuk RecyclerView yang menampilkan daftar buah
class BuahAdapter(
    private var context: RecylerActivity,  // Context dari Activity
    private val dataBuah: Array<String>,   // Data nama buah yang harus berupa String
    private val dataGambar: Array<Int>     // Data gambar buah yang berupa ID gambar
) : RecyclerView.Adapter<BuahAdapter.BuahHolder>() {

    // Membuat ViewHolder baru ketika RecyclerView membutuhkan tampilan baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahHolder {
        // Menginflate layout item untuk list (ListItemBinding)
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuahHolder(binding)
    }

    // Menghubungkan data ke ViewHolder pada posisi tertentu
    override fun onBindViewHolder(holder: BuahHolder, position: Int) {
        // Mengatur nama buah pada TextView
        holder.binding.tvNamaBuah.text = dataBuah[position]  // dataBuah sekarang adalah Array<String>

        // Mengatur gambar buah pada ImageView
        holder.binding.imgBuah.setImageResource(dataGambar[position])

        // Set listener untuk item yang diklik
        holder.itemView.setOnClickListener {
            // Membuat Intent untuk membuka DetailBuahActivity
            val intent = Intent(context, DetailBuahActivity::class.java)
            // Mengirimkan data nama dan gambar buah ke DetailBuahActivity
            intent.putExtra("nama", dataBuah[position]) // Mengirimkan nama buah
            intent.putExtra("gambar", dataGambar[position]) // Mengirimkan ID gambar
            // Memulai Activity dengan Intent yang sudah dibuat
            context.startActivity(intent)
        }
    }

    // Mengembalikan jumlah item dalam RecyclerView
    override fun getItemCount(): Int = dataBuah.size

    // ViewHolder untuk setiap item pada RecyclerView
    inner class BuahHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
