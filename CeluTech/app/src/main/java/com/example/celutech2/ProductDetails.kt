package com.example.celutech2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class ProductDetails : AppCompatActivity() {

    private lateinit var img: ImageView
    private lateinit var back: ImageView
    private lateinit var proName: TextView
    private lateinit var proPrice: TextView
    private lateinit var proDesc: TextView
    private lateinit var proQty: TextView
    private lateinit var proUnit: TextView

    private lateinit var name: String
    private var image: Int = 0
    private lateinit var price: String
    private lateinit var desc: String
    private lateinit var qty: String
    private lateinit var unit: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)


        val intent = intent
        name = intent.getStringExtra("name").toString()
        image = intent.getIntExtra("image", R.drawable.b1)
        price = intent.getStringExtra("price").toString()
        desc = intent.getStringExtra("desc").toString()
        qty = intent.getStringExtra("qty").toString()
        unit = intent.getStringExtra("unit").toString()

        proName = findViewById(R.id.productName)
        proDesc = findViewById(R.id.prodDesc)
        proPrice = findViewById(R.id.prodPrice)
        img = findViewById(R.id.big_image)
        back = findViewById(R.id.back2)
        proQty = findViewById(R.id.qty)
        proUnit = findViewById(R.id.unit)

        proName.text = name
        proPrice.text = price
        proDesc.text = desc
        proQty.text = qty
        proUnit.text = unit

        img.setImageResource(image)

        back.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ProductDetails, Productos_list::class.java)
            startActivity(i)
            finish()
        })
    }
}