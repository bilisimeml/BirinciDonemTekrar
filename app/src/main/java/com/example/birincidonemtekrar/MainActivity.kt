package com.example.birincidonemtekrar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.birincidonemtekrar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun tikla(view: View) {
        val isim = binding.etText.text.toString()
        binding.textView.text = getString(R.string.greeting, isim) //"Merhaba $isim"
    }

    fun ikinciAktiviteyeGit(view: View) {
        if (binding.etText.text.toString() == "") {
            binding.etText.error = "Lütfen bir isim giriniz"
            Toast.makeText(
                this,
                "Lütfen bir isim giriniz",
                Toast.LENGTH_SHORT)
                .show()
            return
        }
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("isim", binding.etText.text.toString())
        startActivity(intent)
    }
}