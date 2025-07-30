package com.example.uipractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uipractice.Pagination.api.ProductAdapter
import com.example.uipractice.Pagination.api.RetrofitInstance
import com.example.uipractice.databinding.ActivityMainBinding
import com.example.uipractice.Pagination.api.paging.ProductPagingSource
import com.example.uipractice.RYGEnum.Enum_Activity
import com.example.uipractice.calendar.CalendarActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setupRecyclerView()
//
//        lifecycleScope.launch {
//            Pager(PagingConfig(pageSize = 10)) {
//                ProductPagingSource(RetrofitInstance.apiService)
//            }.flow.cachedIn(lifecycleScope).collectLatest {
//                adapter.submitData(it)
//            }
//        }
        startActivity(Intent(this, CalendarActivity::class.java))
//        binding.fragementbtn1.setOnClickListener {
//            replaceFragement(Fragement1())
//        }
//        binding.fragementbtn2.setOnClickListener {
//            replaceFragement(Fragement2())
//        }
    }

    private fun replaceFragement(fragment: Fragment) {
        val fragementManager= supportFragmentManager
        val fragementTransaction=fragementManager.beginTransaction()
        fragementTransaction.replace(R.id.fragementContainer,fragment)
        fragementTransaction.commit()
    }


//    private fun setupRecyclerView() {
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.adapter = adapter
//    }
}
