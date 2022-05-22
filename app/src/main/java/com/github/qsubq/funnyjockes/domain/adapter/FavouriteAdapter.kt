package com.github.qsubq.funnyjockes.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.qsubq.funnyjockes.data.model.JokeModel
import com.github.qsubq.funnyjockes.databinding.JokeItemLayoutBinding

class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {
    class FavouriteViewHolder(val binding: JokeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    var jokesList = emptyList<JokeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val itemBinding =
            JokeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.binding.tvFavouriteJoke.text = jokesList[position].joke
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<JokeModel>) {
        jokesList = list
        notifyDataSetChanged()
    }
}