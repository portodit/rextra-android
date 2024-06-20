import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bangkit.rextra.data.response.activity.ActivityDataResponse
import com.bangkit.rextra.databinding.ItemRecomActivityBinding

class RecomActivityAdapter(val onClick: (ActivityDataResponse) -> Unit = {}): Adapter<RecomActivityAdapter.RecomActivityViewHolder>() {
    private val _data = mutableListOf<ActivityDataResponse>()
    class RecomActivityViewHolder(val binding: ItemRecomActivityBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomActivityViewHolder {
        val binding = ItemRecomActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecomActivityViewHolder(binding)
    }

    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: RecomActivityViewHolder, position: Int) {
        val item = _data[position]
        with(holder.binding) {
            jenisKegiatan.text = item.jenisKegiatan
            namaKegiatan.text = item.namaKegiatan
            root.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    fun addData(newData: List<ActivityDataResponse>) {
        _data.clear()
        _data.addAll(newData)
        notifyDataSetChanged()
    }
}