package michaeljuarez.com.metropolitancouturier.adapters

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_retail_details_color.view.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.utility.Constants
import michaeljuarez.com.metropolitancouturier.utility.GlideApp

class RetailItemsListDetailsColorsAdapter(val items: List<String>) :
    RecyclerView.Adapter<RetailItemsListDetailsColorsAdapter.RetailItemDetailsColorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetailItemDetailsColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_retail_details_color, parent, false)
        return RetailItemDetailsColorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.valueOf(items.size)
    }

    override fun onBindViewHolder(holder: RetailItemDetailsColorViewHolder, position: Int) {
        holder.bind(items.get(holder.adapterPosition))
    }

    class RetailItemDetailsColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {

            var drawable : Drawable = itemView.context.getDrawable(R.drawable.circle_color_black)

            when (item) {
                "black" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_black)
                "blue" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_blue)
                "green" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_green)
                "pink" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_pink)
                "red" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_red)
                "white" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_white)
                "yellow" -> drawable = itemView.context.getDrawable(R.drawable.circle_color_yellow)
            }

            itemView.retailItemDetailsColorImage.setImageDrawable(drawable)
        }
    }
}