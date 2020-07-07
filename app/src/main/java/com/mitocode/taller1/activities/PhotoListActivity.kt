package com.mitocode.taller1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mitocode.taller1.adapters.PhotoListAdapter
import com.mitocode.taller1.databinding.ActivityPhotoListBinding
import com.mitocode.taller1.models.AlbumModel
import com.mitocode.taller1.models.PhotoModel

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

            val data = ArrayList<PhotoModel>()
            data.add(
                PhotoModel(
                    1,
                    1,
                    "Foto 1",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg"
                )
            )
            data.add(
                PhotoModel(
                    2,
                    2,
                    "Foto 2",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg"
                )
            )
            adapter.addItems(data)
        }
    }

    override fun onClick(model: PhotoModel) {

    }
}