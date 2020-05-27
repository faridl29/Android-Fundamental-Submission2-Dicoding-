package com.example.submission2.Views.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.submission2.Adapter.SectionsPagerAdapter
import com.example.submission2.R
import com.example.submission2.Model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var sectionsPagerAdapter : SectionsPagerAdapter

    companion object{
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getParcelableExtra(EXTRA_USER) as User

        initToolbar()
        setupAdapter(user)
        addData(user)
    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Detail User")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupAdapter(user : User) {
        sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager,
                user.username
            )
        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
        supportActionBar?.elevation = 0f
    }

    private fun addData(user: User) {
        Picasso.get()
            .load(user.avatar)
            .resize(300,300)
            .into(image)

        tvRepository.text = user.repository
        tvFollowers.text = user.followers
        tvFollowing.text = user.following
        tvNama.text = user.name
        tvUsername.text = resources.getString(R.string.username, user.username)
        tvCompany.text = resources.getString(R.string.company, user.company)
        tvLocation.text = resources.getString(R.string.location, user.location)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}
