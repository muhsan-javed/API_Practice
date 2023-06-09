package com.muhsanjaved.api_practice.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muhsanjaved.api_practice.models.Product
import com.muhsanjaved.api_practice.activities.ProductDetails
import com.muhsanjaved.api_practice.R
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context , private val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return productArrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = productArrayList[position]

        holder.title.text = currentItem.title
        // Picasso?, image view , How to show image in imageView if the image is in from if url, 3rd party library
        Picasso.get().load(currentItem.thumbnail).into(holder.image);

        val rat : Double = currentItem.rating
        holder.rating.text = "Rating: $rat"

        holder.description.text =  currentItem.description

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetails::class.java)
            intent.putExtra("id", currentItem.id)
            intent.putExtra("title", currentItem.title)
            intent.putExtra("description", currentItem.description)
            intent.putExtra("price", currentItem.price)
            intent.putExtra("discountPercentage", currentItem.discountPercentage)
            intent.putExtra("rating", rat)
            intent.putExtra("stock", currentItem.stock)
            intent.putExtra("brand", currentItem.brand)
            intent.putExtra("category", currentItem.category)
            intent.putExtra("thumbnail", currentItem.thumbnail)
            // How to show multiple Images
            intent.putExtra("image0", currentItem.images[0])
            intent.putExtra("image1", currentItem.images[1])
            intent.putExtra("image2", currentItem.images[2])
            intent.putExtra("image3", currentItem.images[3])
            context.startActivity(intent)
        }

    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView
        val image : ImageView
        val rating : TextView
        val description : TextView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            rating = itemView.findViewById(R.id.productRating)
            description = itemView.findViewById(R.id.productDescription)
        }
    }


}