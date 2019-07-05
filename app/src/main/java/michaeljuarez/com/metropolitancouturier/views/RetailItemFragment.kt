package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_retailitemlist.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.RetailItemListAdapter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.Constants.Companion.RETAIL_ITEM_LIST_KEY

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

        var view : View = inflater.inflate(R.layout.fragment_retailitemlist, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = RetailItemListAdapter(mRetailItemList)
        mGridLayoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)

        retailItemRecyclerView.layoutManager = mGridLayoutManager
        retailItemRecyclerView.adapter = mAdapter
    }
}