package com.mitocode.taller1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mitocode.taller1.adapters.PhotoListAdapter
import com.mitocode.taller1.databinding.ActivityPhotoListBinding
import com.mitocode.taller1.models.AlbumModel
import com.mitocode.taller1.models.PhotoModel
import com.mitocode.taller1.net.ConfiguracionRetrofit
import com.mitocode.taller1.net.Metodo
import com.mitocode.taller1.response.PhotoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoListActivity : AppCompatActivity(), PhotoListAdapter.PhotoListCallback {
    private lateinit var binding: ActivityPhotoListBinding
    private lateinit var adapter: PhotoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("item")) {
            val item = intent.getParcelableExtra<AlbumModel>("item")
            title = item!!.title

            adapter = PhotoListAdapter(this)
            binding.rvPhotos.layoutManager = GridLayoutManager(this, 2)
            binding.rvPhotos.adapter = adapter

            val retrofit = ConfiguracionRetrofit.getConfiguration()!!.create(Metodo::class.java)
            val call = retrofit.obtenerFotos()
            call.enqueue(object : Callback<ArrayList<PhotoResponse>> {
                override fun onFailure(call: Call<ArrayList<PhotoResponse>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ArrayList<PhotoResponse>>,
                    response: Response<ArrayList<PhotoResponse>>
                ) {
                    val respuesta = response.body()
                    val data = ArrayList<PhotoModel>()
                    for (itemFoto in respuesta!!) {
                        data.add(PhotoModel(itemFoto.id, 0, itemFoto.titulo, itemFoto.url, ""))
                    }
                    adapter.addItems(data)
                }

            })
        }
    }

    override fun onClick(model: PhotoModel) {

    }
}