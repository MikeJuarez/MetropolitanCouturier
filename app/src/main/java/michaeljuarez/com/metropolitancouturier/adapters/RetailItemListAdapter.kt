package michaeljuarez.com.metropolitancouturier.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_retailitem.view.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.GlideApp

class RetailItemListAdapter (val items: List<RetailItem>?) : RecyclerView.Adapter<RetailItemListAdapter.RetailItemItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetailItemListAdapter.RetailItemItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_retailitem, parent, false)
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
//            holder.itemView.setOnClickListener {
//                listener.itemClicked(items.get(holder.adapterPosition))//To change body of created functions use File | Settings | File Templates.
//            }
        }
    }

    class RetailItemItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : RetailItem) {

            // Set background image
            GlideApp.with(itemView.context)
                .load(item.image_url)
                .centerCrop()
                .into(itemView.retailItemImage)

            itemView.retailItemBrandTextView.text = item.item_brand
            itemView.retailItemNameTextView.text = item.item_name
            item.price?.let { itemView.retailItemPriceTextView.text = itemView.context.getString(R.string.retail_list_adapter_price) + it }
        }
    }

}