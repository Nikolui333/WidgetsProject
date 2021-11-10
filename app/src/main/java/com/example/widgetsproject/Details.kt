package com.example.widgetsproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.widgetsproject.databinding.DetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Details : BottomSheetDialogFragment(),View.OnClickListener {

    private var binding: DetailsBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.details, container, false)

        binding?.nameMovieDetails?.text = arguments?.getString("nameMovie").toString()
        binding?.longMovieDetails?.text = arguments?.getString("longMovie").toString()
        binding?.actorsMovieDetails?.text = arguments?.getString("actorsMovie").toString()

        when(binding?.nameMovieDetails?.text) {
            getString(R.string.badBoys) -> binding?.imageMovieDetails?.setImageResource(R.drawable.baner)
        }

        binding?.closePanel?.setOnClickListener(this)

        return binding?.root
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.closePanel -> dismiss()
        }
    }
}