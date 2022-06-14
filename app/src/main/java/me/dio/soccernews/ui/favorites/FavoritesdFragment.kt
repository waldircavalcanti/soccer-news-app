package me.dio.soccernews.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import me.dio.soccernews.databinding.FragmentFavoritesBinding
import me.dio.soccernews.domain.News
import me.dio.soccernews.ui.adapters.NewsAdapter


class FavoritesdFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private var _binding: FragmentFavoritesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        loadFavoriteNews();

        return binding.root
    }

    private fun loadFavoriteNews() {
        favoritesViewModel.loadFavoriteNews()?.observe(viewLifecycleOwner) { localNews ->
            binding.rvNews.layoutManager = LinearLayoutManager(context)
            binding.rvNews.adapter = NewsAdapter(
                localNews
            ) { updatedNews: News? ->
                favoritesViewModel.saveNews(updatedNews)
                loadFavoriteNews()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}