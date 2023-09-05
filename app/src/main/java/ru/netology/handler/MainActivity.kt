package ru.netology.handler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import ru.netology.handler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val urls = listOf("netology.jpg", "sber.jpg", "tcs.jpg", "404.png")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.load.setOnClickListener {
            if (index == urls.size) {
                index = 0
            }

            val url = "http://10.0.2.2:9999/avatars/${urls[index++]}"

            Picasso.get()
                .load(url)
                .error(R.drawable.ic_error_100dp)
                .into(binding.image);
        }
    }
}