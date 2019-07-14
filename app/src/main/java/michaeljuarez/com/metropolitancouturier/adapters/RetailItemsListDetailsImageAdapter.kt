package michaeljuarez.com.metropolitancouturier.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_retail_item_details_image.view.*
import michaeljuarez.com.metropolitancouturier.utility.GlideApp
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class RetailItemsListDetailsImageAdapter(val items: List<String>?) :
    RecyclerView.Adapter<RetailItemsListDetailsImageAdapter.RetailItemDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetailItemDetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            michaeljuarez.com.metropolitancouturier.R.layout.list_item_retail_item_details_image,
            parent,
            false
        )
        return RetailItemDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return Integer.valueOf(items.size)
        }
        return 0
    }

    override fun onBindViewHolder(holder: RetailItemDetailsViewHolder, position: Int) {
        if (items != null) {
            holder.bind(items.get(holder.adapterPosition))
        }
    }

    class RetailItemDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            GlideApp.with(itemView.context)
                .load(item)
                .centerCrop()
                .into(itemView.listItemRetailItemDetailsImage)
        }
    }

}