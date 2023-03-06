package com.example.ukmfairapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUKMs : RecyclerView
    private val list = ArrayList<UKM>()

    private fun getListUKM():ArrayList<UKM>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_decsription)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataKategori = resources.getStringArray(R.array.data_kategori)
        val dataSosmed = resources.getStringArray(R.array.data_sosmed)
        val dataAlamat = resources.getStringArray(R.array.Basecamp)
        val dataLomba = resources.getStringArray(R.array.lomba)
        val listUKM = ArrayList<UKM>()
        for (i in dataName.indices){
            val ukm = UKM(dataName[i], dataDescription[i], dataPhoto.getResourceId(i,-1),
                dataKategori[i], dataSosmed[i], dataAlamat[i], dataLomba[i])
            listUKM.add(ukm)
        }
        return listUKM
    }

    private fun showRecycleList(){
        rvUKMs.layoutManager = LinearLayoutManager(this)
        val listUKMAdapter = ListUKMAdapter(list)
        rvUKMs.adapter = listUKMAdapter

        listUKMAdapter.setOnItemClickCallback(object : ListUKMAdapter.OnItemClickCallback{
            override fun onItemClicked(data: UKM) {
                showSelectedUKM(data)
            }
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUKMs = findViewById(R.id.rv_ukm)
        rvUKMs.setHasFixedSize(true)

        list.addAll(getListUKM())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about ->{
                val aboutIntent = Intent(this@MainActivity, MoveAbout::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedUKM(ukm: UKM){
        val intentDetail = Intent(this, MoveSelected::class.java)
        intentDetail.putExtra(MoveSelected.EXTRA_UKM, ukm)
        startActivity(intentDetail)
    }

}