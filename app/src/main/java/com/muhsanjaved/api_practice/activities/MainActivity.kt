package com.muhsanjaved.api_practice.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhsanjaved.api_practice.R
import com.muhsanjaved.api_practice.adapters.MyAdapter
import com.muhsanjaved.api_practice.apis.ApiInterface
import com.muhsanjaved.api_practice.models.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        recyclerView = findViewById(R.id.recyclerView)

        // Step 4
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // if api call is Success, then use the data of API and show in your app
                var responseBody = response.body()
                val productList = responseBody?.products!!

//                val collectDataSB = StringBuilder()
//                for (myData in productList){
//                    collectDataSB.append(myData.title + " ")
//                }
//
//                val tv = findViewById<TextView>(R.id.textView)
//                tv.text = collectDataSB

                myAdapter = MyAdapter(this@MainActivity, productList)
                recyclerView.adapter = myAdapter

                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // if api call fail
                Log.d("Main Activity ", "onFailure: ${t.message.toString()}")
            }
        })


//        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
//            override fun onItemClick(position: Int) {
//                // on clicking each item, What action do you want to perform
//
////                val intent = Intent(this@MainActivity, ProductDetails::class.java)
////                intent.putExtra("heading", retrofitData[position].title)
////                intent.putExtra("imageId", newsArrayList[position].newsImage)
////                intent.putExtra("newContent", newsArrayList[position].newsContent)
////                startActivity(intent)
//                Log.d("MAIN ACTIVITY", "onItemClick")
//            }
//        })

    }
}