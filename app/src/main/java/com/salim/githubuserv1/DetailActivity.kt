package com.salim.githubuserv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvObject: TextView = findViewById(R.id.txt_name)
        val imgPhoto: ImageView = findViewById(R.id.img_photo)

        val detail = intent.getParcelableExtra<Detail>(EXTRA_DETAIL) as Detail
        val text = "Name : ${detail.name} \nUser Name : ${detail.username} \nLocation : ${detail.location} \nRepository : ${detail.repository} \nCompany : ${detail.company} \nFollowers : ${detail.followers} \nFollowing : ${detail.following}"

        tvObject.text = text

        Glide.with(this@DetailActivity)
            .load(detail.photo)
            .apply(RequestOptions())
            .into(imgPhoto)

        val actionBar = supportActionBar
        this!!.title = "Detail User"
        actionBar.run {
            this!!.title = detail.name.toString()
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}