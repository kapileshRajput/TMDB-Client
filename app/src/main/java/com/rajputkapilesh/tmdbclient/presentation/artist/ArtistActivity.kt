package com.rajputkapilesh.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rajputkapilesh.tmdbclient.R
import com.rajputkapilesh.tmdbclient.databinding.ActivityArtistBinding
import com.rajputkapilesh.tmdbclient.presentation.di.Injector
import javax.inject.Inject

private const val TAG = "ArtistActivity"
class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this@ArtistActivity)

        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)

        val responseLiveData = artistViewModel.getArtists()

        responseLiveData.observe(this, Observer {
            Log.i(TAG, "onCreate: ${it.toString()}")
        })
    }
}