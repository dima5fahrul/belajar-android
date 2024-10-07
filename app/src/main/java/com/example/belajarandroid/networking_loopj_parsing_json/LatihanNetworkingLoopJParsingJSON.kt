package com.example.belajarandroid.networking_loopj_parsing_json

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarandroid.databinding.ActivityLatihanNetworkingLoopJparsingJsonBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class LatihanNetworkingLoopJParsingJSON : AppCompatActivity() {
    companion object {
        private val TAG = LatihanNetworkingLoopJParsingJSON::class.java.simpleName
    }

    private lateinit var binding: ActivityLatihanNetworkingLoopJparsingJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLatihanNetworkingLoopJparsingJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRandomQuote()

        binding.btnAllQuotes.setOnClickListener {
            startActivity(
                Intent(
                    this@LatihanNetworkingLoopJParsingJSON,
                    ListQuotesActivity::class.java
                )
            )
        }
    }

    private fun getRandomQuote() {
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://quote-api.dicoding.dev/random"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                binding.progressBar.visibility = View.INVISIBLE

                val result = String(responseBody)
                Log.d(TAG, result)

                try {
                    val response = JSONObject(result)

                    val quote = response.getString("en")
                    val author = response.getString("author")

                    binding.tvQuote.text = quote
                    binding.tvAuthor.text = author
                } catch (e: Exception) {
                    Log.e(TAG, "onSuccess: ${e.message}")
                    Toast.makeText(
                        this@LatihanNetworkingLoopJParsingJSON,
                        e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.progressBar.visibility = View.INVISIBLE

                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }

                Toast.makeText(
                    this@LatihanNetworkingLoopJParsingJSON,
                    errorMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}