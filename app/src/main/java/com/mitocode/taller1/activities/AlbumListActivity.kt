package com.mitocode.taller1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mitocode.taller1.R
import com.mitocode.taller1.adapters.AlbumListAdapter
import com.mitocode.taller1.databinding.ActivityAlbumListBinding
import com.mitocode.taller1.models.AlbumModel
import com.mitocode.taller1.net.ConfiguracionRetrofit
import com.mitocode.taller1.net.Metodo
import com.mitocode.taller1.response.AlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumListActivity : AppCompatActivity(), AlbumListAdapter.AlbumListCallback {
    private lateinit var binding: ActivityAlbumListBinding
    private lateinit var adapter: AlbumListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AlbumListAdapter(this)
        binding.rvAlbum.layoutManager = LinearLayoutManager(this)
        binding.rvAlbum.adapter = adapter

        val retrofit = ConfiguracionRetrofit.getConfiguration()?.create(Metodo::class.java)
        val call = retrofit!!.obtenerAlbunes()
        call.enqueue(object : Callback<ArrayList<AlbumResponse>> {
            override fun onFailure(call: Call<ArrayList<AlbumResponse>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<AlbumResponse>>,
                response: Response<ArrayList<AlbumResponse>>
            ) {
                val respuesta = response.body()
                val data = ArrayList<AlbumModel>()
                for (item in respuesta!!) {
                    data.add(AlbumModel(item.id, item.title))
                }
                adapter.addItems(data)
            }

        })

    }

    override fun onClick(model: AlbumModel) {
        val intent = Intent(this, PhotoListActivity::class.java)
        intent.putExtra("item", model)
        startActivity(intent)
    }
}