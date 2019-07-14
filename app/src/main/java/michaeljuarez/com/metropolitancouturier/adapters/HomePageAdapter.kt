package michaeljuarez.com.metropolitancouturier.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import michaeljuarez.com.metropolitancouturier.R
import kotlinx.android.synthetic.main.list_item_home_page.view.*
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.metropolitancouturier.utility.GlideApp
import michaeljuarez.com.metropolitancouturier.views.HomePageActivity

class HomePageAdapter(val items: List<HomePageItem>?, val listener : HomePageActivity.HomePageItemClickListener) : RecyclerView.Adapter<HomePageAdapter.HomePageItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_home_page, parent, false)
        return HomePageItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return Integer.valueOf(items.size)
        }
        return 0
    }

    override fun onBindViewHolder(holder: HomePageItemViewHolder, position: Int) {
        if (items != null) {
            holder.bind(items.get(holder.adapterPosition))
            holder.itemView.setOnClickListener {
                listener.itemClicked(items.get(holder.adapterPosition))
            }
        }
    }

    class HomePageItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : HomePageItem) {

            // Set title
            itemView.title.setText(item.title)

            // Set background image
            GlideApp.with(itemView.context)
                .load(item.image_url)
                .centerCrop()
                .into(itemView.backgroundImageView)
        }
    }

}