package com.example.sheraz.ui.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.sheraz.R

import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_details.*
import javax.inject.Inject

class DetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val detailsViewModel: DetailsViewModel by viewModels {
        viewModelFactory
    }

    private var movieId = 0
    private lateinit var thisView: View


    companion object {
        const val MOVIE_ID = "movie_id"

        @JvmStatic
        fun newInstance(movieId: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_ID, movieId)
                }
            }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this) // Providing the dependency
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            movieId = it.getInt(MOVIE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        thisView = inflater.inflate(R.layout.fragment_movie_details, container, false)

        load()
        observeMoviesDetails()

        return thisView
    }

    private fun load() {

    }


    private fun observeMoviesDetails() {
        detailsViewModel.getMoviesList(movieId).observe(viewLifecycleOwner, Observer {
            it?.let {
                title.text = it.data?.title
                date.text = it.data?.releaseDate
                title.text = it.data?.title
                overview.text = it.data?.overview
                var genresTextString : String = ""
                if(it.data?.genres != null) {
                    for (item in it.data?.genres!!) {
                        genresTextString += item.name + ","
                    }
                    genres.text = genresTextString
                }
            }
        })
        detailsViewModel.getImagesList(movieId).observe(viewLifecycleOwner, Observer {
            it?.let {
                //Display dummy images because of Image Base Url Not Found
                val imageList = ArrayList<SlideModel>() // Create image list
                imageList.add(SlideModel("https://bit.ly/37Rn50u", "",ScaleTypes.CENTER_CROP))
                imageList.add(SlideModel("https://bit.ly/2BteuF2", ""))
                imageList.add(SlideModel("https://bit.ly/3fLJf72", ""))
                image_slider.setImageList(imageList, ScaleTypes.FIT)
            }
        })
    }
}
