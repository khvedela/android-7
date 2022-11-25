package com.example.appretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.appretrofit.databinding.ActivityDetailsBinding
import com.example.appretrofit.databinding.InfoFragmentBinding
import com.example.appretrofit.models.SingleUser
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("ID", 0)

        lifecycleScope.launch {
            val result = RetrofitService.service().getSingleUser(id)
            if (result.isSuccessful) {
                setData(result.body())
            }
        }

    }

    private fun setData(user: SingleUser?) {
        binding.tvId.text = user?.data?.id.toString()
        binding.tvEmail.text = user?.data?.email.toString()
        binding.tvName.text = user?.data?.firstName.toString()
        binding.tvLastName.text = user?.data?.lastName.toString()

        user?.data?.avatar?.let { binding.ivAvatar.loadImage(it) }
    }
}