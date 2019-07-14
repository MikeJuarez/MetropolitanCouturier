package michaeljuarez.com.metropolitancouturier.views

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_retail_item_list.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.RetailItemListAdapter
import michaeljuarez.com.metropolitancouturier.callbacks.CategoryClickCallback
import michaeljuarez.com.metropolitancouturier.callbacks.RetailItemClicked
import michaeljuarez.com.metropolitancouturier.callbacks.RetrieveRetailItemCallback
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.Constants.Companion.RETAIL_ITEM_CLICKED_KEY
import michaeljuarez.com.metropolitancouturier.utility.Constants.Companion.RETAIL_ITEM_LIST_DETAILS_KEY
import michaeljuarez.com.metropolitancouturier.utility.Constants.Companion.RETAIL_ITEM_LIST_KEY
import java.util.*
import kotlin.collections.ArrayList

class RetailItemFragment : Fragment() {

    private lateinit var mRetailItemList: ArrayList<RetailItem>

    private lateinit var mGridLayoutManager: GridLayoutManager
    private lateinit var mAdapter : RetailItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments!!.containsKey(RETAIL_ITEM_LIST_KEY)) {
            mRetailItemList = arguments!!.getParcelableArrayList(RETAIL_ITEM_LIST_KEY)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var view : View = inflater.inflate(R.layout.fragment_retail_item_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = RetailItemListAdapter(mRetailItemList, mRetailItemClicked)
        mGridLayoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)

        retailItemRecyclerView.layoutManager = mGridLayoutManager
        retailItemRecyclerView.adapter = mAdapter
    }

    val mRetailItemClicked  = object : RetailItemClicked {
        override fun retailItemClicked(position: Int) {
            val intent = Intent(activity, RetailItemDetailsActivity::class.java)
            intent.putExtra(RETAIL_ITEM_LIST_DETAILS_KEY, mRetailItemList.get(position))
            startActivity(intent)
        }
    }

}