package com.bangkit.rextra.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bangkit.rextra.data.response.activity.ActivityDataResponse
import com.bangkit.rextra.data.response.recommendation.RecommendDataResponse
import com.bangkit.rextra.databinding.ItemRecomActivityBinding

class ResultActivityAdapter(val onClick: (RecommendDataResponse) -> Unit = {}): Adapter<ResultActivityAdapter.ResultActivityViewHolder>() {
    private val _data = mutableListOf<RecommendDataResponse>()
    class ResultActivityViewHolder(val binding: ItemRecomActivityBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultActivityViewHolder {
        val binding = ItemRecomActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultActivityViewHolder(binding)
    }

    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: ResultActivityViewHolder, position: Int) {
        val item = _data[position]
        with(holder.binding) {
            jenisKegiatan.text = item.penyelenggara
            namaKegiatan.text = item.posisi
            root.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    fun addData(newData: List<RecommendDataResponse>) {
        _data.clear()
        _data.addAll(newData)
        notifyDataSetChanged()
    }
}