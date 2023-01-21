package com.example.pictureapplication.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pictureapplication.adapter.*
import com.example.pictureapplication.api.ApiServise
import com.example.pictureapplication.api.BaseImageResponce
import com.example.pictureapplication.api.BaseResponce
import com.example.pictureapplication.databinding.ActivityMainBinding
import com.example.pictureapplication.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()/*,SwipeRefreshLayout.OnRefreshListener*/ {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.swipe.setOnRefreshListener(this)
        binding.swipe.isRefreshing = true*/
        /* binding.rvImage.layoutManager =
             LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
         binding.rvImage.adapter = adapter*/

        loadImages()
        loadPost()
        loadDisney()
        /* loadDog()
         loadImage()*/
        loadImage()
    }

    fun loadImages() {
        ApiServise.apiCLient().getCatImage().enqueue(object : Callback<BaseResponce<List<Model>>> {
            override fun onResponse(
                call: Call<BaseResponce<List<Model>>>,
                response: Response<BaseResponce<List<Model>>>
            ) {
                binding.rvCat.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                binding.rvCat.adapter =
                    CatAdapter(response.body()?.data ?: emptyList(), object : UserListener {
                        override fun onClick(item: Model) {
                            val intent = Intent(this@MainActivity, PostAdapter::class.java)
                            intent.putExtra("extra_data", item)
                            startActivity(intent)
                        }

                    })
            }

            override fun onFailure(call: Call<BaseResponce<List<Model>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

              /*override fun onFailure(call: Call<BaseResponce<List<Model>>>, t: Throwable) {
                  binding.swipe.isRefreshing = false
                  Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
              }*/
        })
    }

   fun loadPost() {
        ApiServise.apiCLient().getPost().enqueue(object : Callback<BaseResponce<List<PostModel>>> {
            override fun onResponse(
                call: Call<BaseResponce<List<PostModel>>>,
                response: Response<BaseResponce<List<PostModel>>>
            ) {
                binding.rvPost.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                binding.rvPost.adapter = PostAdapter(response.body()?.data ?: listOf())
            }

            override fun onFailure(call: Call<BaseResponce<List<PostModel>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }

    /*  fun loadDog() {
         ApiServise.apiDog().getDog().enqueue(object : Callback<Test> {
             override fun onResponse(
                 call: Call<Test>,
                 response: Response<Test>
             ) {
                 binding.rvDog.layoutManager =
                     LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                 Glide.with(this@MainActivity).load(response.body()?.message).into(binding.ivDogs)
             }

             override fun onFailure(call: Call<Test>, t: Throwable) {
                 Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
             }
         })
     }*/

     fun loadImage() {

         ApiServise.apiImage().getImage().enqueue(object : Callback<BaseImageResponce<List<Pixaboy>>>{
             override fun onResponse(
                 call: Call<BaseImageResponce<List<Pixaboy>>>,
                 response: Response<BaseImageResponce<List<Pixaboy>>>
             ) {
                 binding.rvImage.layoutManager =
                     LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                 binding.rvImage.adapter = ImageAdapter(response.body()?.hits ?: listOf() )
             }

             override fun onFailure(call: Call<BaseImageResponce<List<Pixaboy>>>, t: Throwable) {
                 Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()            }
         })

     }

    fun loadDisney(){
        ApiServise.apiDisney().getDisney().enqueue(object : Callback<Disney<List<DataX>>>{
            override fun onResponse(
                call: Call<Disney<List<DataX>>>,
                response: Response<Disney<List<DataX>>>
            ) {
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                binding.rvImage.adapter = DisneyAdapter((response.body()?.data ?: listOf()) )
            }
            override fun onFailure(call: Call<Disney<List<DataX>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}





