package com.rajputkapilesh.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rajputkapilesh.tmdbclient.R
import com.rajputkapilesh.tmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}