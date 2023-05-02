package com.example.nav.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nav.databinding.ItemOnboardingBinding
import com.example.nav.model.OnBoard
import com.example.nav.utils.loadImage

class OnBoardingAdapter(private val onClick: (OnBoard) -> Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            title = "Title 1",
            desc = "Desc 1",
            "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"
        ),
        OnBoard(
            title = "Title 2",
            desc = "Desc 2",
            "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"
        ),
        OnBoard(
            title = "Title 3",
            desc = "Desc 3",
            "https://cdn-icons-png.flaticon.com/512/2098/2098402.png"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
        holder.itemView.setOnClickListener{
            onClick(OnBoard())
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image)

        }
    }
}