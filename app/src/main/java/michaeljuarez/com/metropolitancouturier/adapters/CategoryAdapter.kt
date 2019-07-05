package michaeljuarez.com.metropolitancouturier.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_category.view.*
import kotlinx.android.synthetic.main.list_item_home_page.view.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.callbacks.CategoryClickCallback
import michaeljuarez.com.metropolitancouturier.restful_api_structures.CategoryItem
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.metropolitancouturier.utility.GlideApp
import michaeljuarez.com.metropolitancouturier.views.HomePageActivity

class CategoryAdapter(val items: ArrayList<String>?, val categoryClickCallback : CategoryClickCallback) : RecyclerView.Adapter<CategoryAdapter.CategoryItemViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int): CategoryItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_category, parent, false)
        return CategoryItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return Integer.valueOf(items.size)
        }
        return 0
    }

    override fun onBindViewHolder(holder : CategoryItemViewHolder, position: Int) {
        if (items != null) {
            holder.bind(items.get(holder.adapterPosition))
            if (items.get(holder.adapterPosition).equals(holder.itemView.context.getString(R.string.category_new))){
                holder.itemView.setOnClickListener{
                    categoryClickCallback.newCategoryClicked()
                }
            } else {
                holder.itemView.categoryName.setTextColor(holder.itemView.context.resources.getColor(R.color.mtrl_btn_bg_color_disabled))
            }
        }
    }

    class CategoryItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : String) {
            // Set Category
            itemView.categoryName.setText(item)
        }
    }
}