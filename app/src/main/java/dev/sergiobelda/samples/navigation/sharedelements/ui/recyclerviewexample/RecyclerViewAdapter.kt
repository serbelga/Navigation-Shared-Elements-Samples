package dev.sergiobelda.samples.navigation.sharedelements.ui.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.sergiobelda.samples.navigation.sharedelements.R
import dev.sergiobelda.samples.navigation.sharedelements.ui.recyclerviewexample.dummy.DummyContent.DummyItem

class RecyclerViewAdapter(
    private val items: List<DummyItem>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    lateinit var listener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        private val image: ImageView = mView.findViewById(R.id.item_image)
        private val name: TextView = mView.findViewById(R.id.item_name)

        fun bindItem(item: DummyItem) {
            name.text = item.id
            image.transitionName = item.id
            mView.setOnClickListener {
                listener.onItemClickListener(item, image)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClickListener(item: DummyItem, imageView: ImageView)
    }
}
