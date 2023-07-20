package com.coyul.catsapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.coyul.catsapp.databinding.FragmentCatsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsFragment : Fragment() {

    private val viewModel: CatsViewModel by viewModels()
    private val adapter by lazy { CatsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCatsBinding
        .inflate(inflater, container, false)
        .apply {
            countriesRecyclerView.adapter = adapter
            viewModel.listState.observe(viewLifecycleOwner) {
                when (it) {
                    is CatsListResult.CatsList -> {
                        progress.visibility = View.GONE
                        countriesRecyclerView.visibility = View.VISIBLE
                        adapter.submitList( it.items.toList())
                    }

                    CatsListResult.Error -> {
                        progress.visibility = View.GONE
                        countriesRecyclerView.visibility = View.GONE
                        error.visibility = View.VISIBLE
                    }

                    CatsListResult.Loading -> {
                        countriesRecyclerView.visibility = View.GONE
                        error.visibility = View.GONE
                        progress.visibility = View.VISIBLE
                    }
                }
            }
        }.root
}