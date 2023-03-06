package com.example.ukmfairapk

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import com.example.ukmfairapk.databinding.ActivityMoveSelectedBinding

class MoveSelected : AppCompatActivity() {
    private lateinit var binding: ActivityMoveSelectedBinding
    private lateinit var button : Button

    companion object {
        const val EXTRA_UKM = "extra_ukm"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveSelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ukm = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_UKM, UKM::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_UKM)
        }
        if (ukm != null) {
            binding.imgItemPhotoSelected.setImageResource(ukm.photo)
            binding.tvItemName.text = ukm.nama
            binding.tvItemDescription.text = ukm.description
            binding.tvItemKategori.text = ukm.kategori
            binding.tvItemSosmed.text = ukm.sosmed
            binding.tvItemAlamat.text = ukm.alamat
            binding.tvItemJuara.text = ukm.juara
            button = findViewById(R.id.button_sharee)
            button.setOnClickListener{
                val share = ukm.description
                val intentbutton = Intent(Intent.ACTION_SEND)
                intentbutton.type = "text/plan"
                intentbutton.putExtra("Share this", share)
                val choose = Intent.createChooser(intentbutton, "Share using....")
                startActivity(choose)
            }
            supportActionBar?.apply {
                title = getString(R.string.Slected)
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}