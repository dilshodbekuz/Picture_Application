package com.example.pictureapplication.screen.posts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pictureapplication.R
import com.example.pictureapplication.databinding.ActivityPostsBinding
import com.example.pictureapplication.model.Model

class PostsActivity : AppCompatActivity() {
    lateinit var binding:ActivityPostsBinding
    lateinit var user: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        user = intent.getSerializableExtra("extra_data") as Model
        binding.tvTitle.text = user.firstName+" "+ user.lastName
    }
    fun loadPosts(){*/

    }
}