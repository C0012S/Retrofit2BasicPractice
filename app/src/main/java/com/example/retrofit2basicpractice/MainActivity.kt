package com.example.retrofit2basicpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2basicpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val tmprAdapter by lazy {
        TmprAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = tmprAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        binding.btnGet.setOnClickListener {
            retrofitWork()
        }
    }

    private fun retrofitWork() {
        val service = RetrofitApi.tmprService

        // enqueue로 처리
//        service.getTmprData(getString(R.string.api_key), "json")
//            .enqueue(object : Callback<TmprResponse> {
//                override fun onResponse(
//                    call: Call<TmprResponse>,
//                    response: Response<TmprResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Log.d("TAG", response.body().toString())
//                        val result = response.body()?.tmprScrnIspcOfic?.get(1)?.row
//                        tmprAdapter.submitList(result!!)
//                    }
//                }
//
//                override fun onFailure(call: Call<TmprResponse>, t: Throwable) {
//                    Log.d("TAG", t.message.toString())
//                }
//            })

        // Coroutine으로 수행
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getDataCoroutine(getString(R.string.api_key), "json")

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val result = response.body()?.tmprScrnIspcOfic?.get(1)?.row
                    result?.let {
                        tmprAdapter.submitList(it)
                    }
                } else {
                    Log.d("TAG", response.code().toString())
                }
            }
        }
    }
}