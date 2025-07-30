package com.example.uipractice.Pagination.api.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.uipractice.Pagination.api.ApiService
import com.example.uipractice.Pagination.api.model.Product
import java.lang.Exception

class ProductPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, Product>(){
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
       return try{
           val currentPage=params.key?:0
           val response=apiService.getProduct(limit = 10,skip=currentPage)
           Log.d("Paging", "Fetched ${response.products.size} products")
           println("${response.products.size}")
           LoadResult.Page(
               data = response.products,
               prevKey = if(currentPage==0) null else currentPage-10,
               nextKey = if(response.products.isEmpty()) null else currentPage+10
           )

       }catch (e: Exception){
           LoadResult.Error(e)
       }
    }
}