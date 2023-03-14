package com.muhsanjaved.api_practice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetails : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        supportActionBar?.hide()

        val id = intent.getIntExtra("id",0)
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val price = intent.getIntExtra("price",0)
        val discountPercentage = intent.getIntExtra("discountPercentage",0)
        val rating = intent.getIntExtra("rating",0)
        val stock = intent.getIntExtra("stock",0)
        val brand = intent.getStringExtra("brand")
        val category = intent.getStringExtra("category")
        val thumbnail = intent.getStringExtra("thumbnail")
        val image0 = intent.getStringExtra("image0")
        val image1 = intent.getStringExtra("image1")
        val image2 = intent.getStringExtra("image2")
        val image3 = intent.getStringExtra("image3")
        val image4 = intent.getStringExtra("image4")


        //val id = findViewById<TextView>(R.id.id)
        val productTitle = findViewById<TextView>(R.id.productTitle)
        val productDescription = findViewById<TextView>(R.id.productDescription)
        val productPrice = findViewById<TextView>(R.id.productPrice)
        val productDiscountPercentage = findViewById<TextView>(R.id.productDiscountPercentage)
        val productRating = findViewById<TextView>(R.id.productRating)
        val productStock = findViewById<TextView>(R.id.productStock)
        val productBrand = findViewById<TextView>(R.id.productBrand)
        val productCategory = findViewById<TextView>(R.id.productCategory)
        val productThumbnail = findViewById<ImageView>(R.id.productThumbnail)
        val productImage0 = findViewById<ImageView>(R.id.productImage0)
        val productImage1 = findViewById<ImageView>(R.id.productImage1)
        val productImage2 = findViewById<ImageView>(R.id.productImage2)
        val productImage3 = findViewById<ImageView>(R.id.productImage3)

        Picasso.get().load(thumbnail).into(productThumbnail)
        productTitle.text = title
        productDescription.text = getString(R.string.description) + description
        productPrice.text = getString(R.string.price) +price.toString()
        productDiscountPercentage.text = getString(R.string.discount_percentage) + discountPercentage.toString()
        productRating.text = getString(R.string.rating) + rating.toString()
        productStock.text = getString(R.string.stock) + stock.toString()
        productBrand.text = getString(R.string.brand) + brand
        productCategory.text = getString(R.string.category) + category

        Picasso.get().load(image0).into(productImage0)
        Picasso.get().load(image1).into(productImage1)
        Picasso.get().load(image2).into(productImage2)
        Picasso.get().load(image3).into(productImage3)

    }

}