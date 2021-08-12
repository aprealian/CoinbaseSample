package me.aprilian.coinbasesample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.aprilian.coinbasesample.databinding.FragmentCoinDetailBinding

class CoinDetailFragment : Fragment() {

    private lateinit var binding: FragmentCoinDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCoinDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(){}
    }
}