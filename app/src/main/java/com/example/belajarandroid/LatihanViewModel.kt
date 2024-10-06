package com.example.belajarandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.belajarandroid.databinding.ActivityLatihanViewModelBinding

class LatihanViewModel : AppCompatActivity() {
    private lateinit var binding: ActivityLatihanViewModelBinding

    //    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_view_model)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityLatihanViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        displayResult()

        binding.btnCalculate.setOnClickListener {
            val width = binding.edtWidth.text.toString()
            val height = binding.edtHeight.text.toString()
            val length = binding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    binding.edtWidth.error = "Masih kosong"
                }

                height.isEmpty() -> {
                    binding.edtHeight.error = "Masih kosong"
                }

                length.isEmpty() -> {
                    binding.edtLength.error = "Masih kosong"
                }

                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }

    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}