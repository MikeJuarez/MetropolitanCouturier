package michaeljuarez.com.metropolitancouturier.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_retail_item.view.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.callbacks.RetailItemClicked
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.GlideApp

class RetailItemListAdapter (val items: List<RetailItem>?, val mRetailItemClicked : RetailItemClicked) : RecyclerView.Adapter<RetailItemListAdapter.RetailItemItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetailItemItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_retail_item, parent, false)
        return RetailItemItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return Integer.valueOf(items.size)
        }
        return 0
    }

    override fun onBindViewHolder(holder: RetailItemItemViewHolder, position: Int) {
        if (items != null) {
            holder.bind(items.get(holder.adapterPosition))

            holder.itemView.setOnClickListener {
                mRetailItemClicked.retailItemClicked(holder.adapterPosition)
            }
        }
    }

    class RetailItemItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : RetailItem) {

            // Set background image
            GlideApp.with(itemView.context)
                .load(item.image_url.get(0))
                .centerCrop()
                .into(itemView.retailItemImage)

            itemView.retailItemBrandTextView.text = item.item_brand
            itemView.retailItemNameTextView.text = item.item_name
            item.price?.let { itemView.retailItemPriceTextView.text = itemView.context.getString(R.string.retail_list_adapter_price) + it }
        }
    }

}