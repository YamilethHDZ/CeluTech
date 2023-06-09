package com.example.celutech2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.celutech2.adapter.CategoryAdapter
import com.example.celutech2.adapter.DiscountedProductAdapter
import com.example.celutech2.adapter.RecentlyViewedAdapter

import com.example.celutech2.model.Category
import com.example.celutech2.model.DiscountedProducts
import com.example.celutech2.model.RecentlyViewed


class Productos_list : AppCompatActivity() {

    private lateinit var discountRecyclerView: RecyclerView
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var recentlyViewedRecycler: RecyclerView
    private lateinit var allCategory: TextView

    private lateinit var discountedProductAdapter: DiscountedProductAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var recentlyViewedAdapter: RecentlyViewedAdapter

    private val discountedProductsList = ArrayList<DiscountedProducts>()
    private val categoryList = ArrayList<Category>()
    private val recentlyViewedList = ArrayList<RecentlyViewed>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_list)

        discountRecyclerView = findViewById(R.id.discountedRecycler)
        categoryRecyclerView = findViewById(R.id.categoryRecycler)
        allCategory = findViewById(R.id.allCategoryImage)
        recentlyViewedRecycler = findViewById(R.id.recently_item)


        allCategory.setOnClickListener {
            val intent = Intent(this, AllCategory::class.java)
            startActivity(intent)

        }

        // Agregar datos a la lista de productos con descuento
        discountedProductsList.add(DiscountedProducts(1, R.drawable.discountsamsung))
        discountedProductsList.add(DiscountedProducts(2, R.drawable.discountiphone))
        discountedProductsList.add(DiscountedProducts(3, R.drawable.discountxiaomi))
        discountedProductsList.add(DiscountedProducts(4, R.drawable.discountsamsung))
        discountedProductsList.add(DiscountedProducts(5, R.drawable.discountiphone))
        discountedProductsList.add(DiscountedProducts(6, R.drawable.discountxiaomi))

        // Agregar datos a la lista de categorías
        categoryList.add(Category(1, R.drawable.ic_androi))
        categoryList.add(Category(2, R.drawable.ic_honor))
        categoryList.add(Category(3, R.drawable.ic_huawei))
        categoryList.add(Category(4, R.drawable.ic_iphone))
        categoryList.add(Category(5, R.drawable.ic_motorola))
        categoryList.add(Category(6, R.drawable.ic_oppo))
        categoryList.add(Category(7, R.drawable.ic_realme))
        categoryList.add(Category(8, R.drawable.ic_xiaomi))

        // Agregar datos a la lista de elementos vistos recientemente
        recentlyViewedList.add(
            RecentlyViewed(
                "Samsung Galaxy S22 Ultra",
                "5G Dual-SIM, 7,09 x 3,74 x 1,06 pulgadas, 12GB RAM.",
                "$ 899.99",
                "256",
                "GB",
                R.drawable.card1,
                R.drawable.b1
            )
        )
        recentlyViewedList.add(
            RecentlyViewed(
                "iPhone 13 Pro Max",
                "Pantalla OLED de 6.7 pulgadas,cuenta con una pantalla con 120Hz.",
                "$ 1199.99",
                "256",
                "GB",
                R.drawable.card2,
                R.drawable.b2
            )
        )
        recentlyViewedList.add(
            RecentlyViewed(
                "Redmi Note 12 pro",
                "Dimensity 1080 5G, cámara de 50 MP,OLED de 120 Hz y 5.000 mAh de batería",
                "$ 449.99",
                "256",
                "GB",
                R.drawable.card3,
                R.drawable.b3
            )
        )
        recentlyViewedList.add(
            RecentlyViewed(
                "Kiwi",
                "6,8 pg, pantallas: FHD+ (2520 × 1080)120 Hz,(720×382) 60Hz, Min 30Hz.",
                "$ 913.00",
                "256",
                "GB",
                R.drawable.card4,
                R.drawable.b4
            )
        )

        setDiscountedRecycler(discountedProductsList)
        setCategoryRecycler(categoryList)
        setRecentlyViewedRecycler(recentlyViewedList)
    }

    private fun setDiscountedRecycler(dataList: List<DiscountedProducts>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        discountRecyclerView.layoutManager = layoutManager
        discountedProductAdapter = DiscountedProductAdapter(this, dataList)
        discountRecyclerView.adapter = discountedProductAdapter
    }

    private fun setCategoryRecycler(categoryDataList: List<Category>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = layoutManager
        categoryAdapter = CategoryAdapter(this, categoryDataList)
        categoryRecyclerView.adapter = categoryAdapter
    }

    private fun setRecentlyViewedRecycler(recentlyViewedDataList: List<RecentlyViewed>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recentlyViewedRecycler.layoutManager = layoutManager
        recentlyViewedAdapter = RecentlyViewedAdapter(this, recentlyViewedDataList)
        recentlyViewedRecycler.adapter = recentlyViewedAdapter


    }
}