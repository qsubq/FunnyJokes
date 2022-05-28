package com.github.qsubq.funnyjockes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.qsubq.funnyjockes.data.model.JokeModel
import com.github.qsubq.funnyjockes.databinding.JokeItemLayoutBinding


class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {

    class FavouriteViewHolder(val binding: JokeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    private var jokesList = emptyList<JokeModel>()

    private lateinit var currentJoke: JokeModel
    private fun setCurrentJoke(jokeModel: JokeModel) {
        this.currentJoke = jokeModel
    }

    fun getCurrentJoke(): JokeModel {
        return currentJoke
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val itemBinding =
            JokeItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FavouriteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.binding.tvFavouriteJoke.text = jokesList[position].joke
        holder.itemView.setOnLongClickListener {
            setCurrentJoke(jokesList[position])
            false
        }
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<JokeModel>) {
        jokesList = list
        notifyDataSetChanged()
    }

    override fun onViewRecycled(holder: FavouriteViewHolder) {
        super.onViewRecycled(holder)
        holder.itemView.setOnLongClickListener(null)
    }
}