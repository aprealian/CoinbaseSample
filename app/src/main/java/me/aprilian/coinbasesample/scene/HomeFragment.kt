package me.aprilian.coinbasesample.scene

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.android.parcel.Parcelize
import me.aprilian.coinbasesample.databinding.FragmentHomeBinding
import me.aprilian.coinbasesample.databinding.ItemWatchlistBinding
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: WatchListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        adapter = WatchListAdapter()
        binding.adapter = adapter
        //Coin.getSample().let { adapter.submitList(it) }
        homeViewModel.getCoins().let { adapter.submitList(it) }
        homeViewModel.loadUsers()
    }

    companion object {
        @JvmStatic
        fun newInstance(){}
    }
}

class WatchListAdapter : ListAdapter<Coin, WatchListAdapter.UserViewHolder>(Companion) {

    class UserViewHolder(val binding: ItemWatchlistBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemWatchlistBinding.inflate(layoutInflater)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentCoin = getItem(position)
        holder.binding.coin = currentCoin
        holder.binding.executePendingBindings()
    }
}

@Parcelize
data class Coin(
    val id: Long,
    val name: String,
    val symbol: String,
    val price: Long,
    val growth: Double
) : Parcelable {
    companion object {
        fun getSample(): ArrayList<Coin>{
            return arrayListOf(
                Coin(1, "Bitcoin", "BTC", 3000000, 2.67),
                Coin(2, "DogeCoin", "DOGE", 30, 20.00),
                Coin(3, "TRON", "TRX", 78, 20.00),
                Coin(4, "Bitcoin", "BTC", 3000000, 2.67),
                Coin(5, "DogeCoin", "DOGE", 30, 20.00),
                Coin(6, "TRON", "TRX", 78, 20.00),
            )
        }
    }
}

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){
    //private val coins: MutableLiveData<List<Coin>> = MutableLiveData()
    private val coins: ArrayList<Coin> = arrayListOf()

    fun getCoins(): ArrayList<Coin> {
        return coins
    }

    fun loadUsers() {
        coins.addAll(Coin.getSample())
    }

    init {
        loadUsers()
    }
}