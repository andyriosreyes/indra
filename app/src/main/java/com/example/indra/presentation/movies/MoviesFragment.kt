package com.example.indra.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.indra.R
import com.example.indra.databinding.FragmentMoviesBinding
import com.example.indra.domain.usecase.response.MovieResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment(),OnMoviesAdapterListener {
    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private var adapter: MoviesAdapter? = null
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MoviesAdapter(this,context)
        moviesViewModel.allMovies(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMoviesBinding.movieRV.adapter = adapter
        moviesViewModel.movieLiveData.observe(viewLifecycleOwner,{
            initRecyclerView(it)
        })

        fragmentMoviesBinding.nsMovieScroll.setOnScrollChangeListener { v: NestedScrollView, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (v.getChildAt(v.childCount - 1) != null) {
                if (scrollY >= v.getChildAt(v.childCount - 1)
                        .measuredHeight - v.measuredHeight &&
                    scrollY > oldScrollY
                ) {
                    Toast.makeText(requireContext(),"2",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun initRecyclerView(articles: List<MovieResponse>) {
        adapter?.addData(articles.sortedBy { it.id })
    }

    override fun onSelectMovie(movieResponse: MovieResponse) {
        val x = MoviesFragmentDirections.actionMoviesFragmentToMovieMainFragment(movieResponse)
        val bundle = bundleOf("amount" to movieResponse)
        view?.let { Navigation.findNavController(it).navigate(R.id.action_moviesFragment_to_movieMainFragment,bundle) }
    }
}