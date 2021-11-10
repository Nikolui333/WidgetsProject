package com.example.widgetsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.widgetsproject.databinding.MainMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainMenu : BottomSheetDialogFragment(), View.OnClickListener {

    private var binding: MainMenuBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_menu, container, false)

      //  binding = DataBindingUtil.setContentView(this, R.layout.main_menu)

        binding?.buttonMovie?.setOnClickListener(this)

        return binding?.root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onClick(view: View) {

        val details = Details()

        val parameters = Bundle()

        parameters.putString("nameMovie", binding?.nameMovie?.text?.toString())
        parameters.putString("longMovie", binding?.longMovie?.text?.toString())
        parameters.putString("actorsMovie", binding?.actorsMovie?.text?.toString())

        details.arguments = parameters

        details.show(getActivity()!!.supportFragmentManager, "details")

    }
}