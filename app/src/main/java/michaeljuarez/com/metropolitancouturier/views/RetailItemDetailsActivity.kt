package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_retail_item_details.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.RetailItemsListDetailsColorsAdapter
import michaeljuarez.com.metropolitancouturier.adapters.RetailItemsListDetailsImageAdapter
import michaeljuarez.com.metropolitancouturier.mvp.retail_item_details.RetailItemDetailsPresenter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.Constants.Companion.RETAIL_ITEM_LIST_DETAILS_KEY
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity

class RetailItemDetailsActivity : MvpBaseActivity<RetailItemDetailsPresenter>() {

    private lateinit var mRetailItem : RetailItem;

    private lateinit var mImageAdapter : RetailItemsListDetailsImageAdapter;
    private lateinit var mColorAdapter : RetailItemsListDetailsColorsAdapter;


    override fun createPresenter(): RetailItemDetailsPresenter {
        return RetailItemDetailsPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retail_item_details)

        if (intent.hasExtra(RETAIL_ITEM_LIST_DETAILS_KEY))
            mRetailItem = intent.getParcelableExtra(RETAIL_ITEM_LIST_DETAILS_KEY);
        else
            finish()

        setupViews()
    }

    private fun setupViews() {

        retailItemDetailsBrand.setText(mRetailItem.item_brand)
        retailItemDetailsDescription.setText(mRetailItem.item_name)
        retailItemDetailsPrice.setText(mRetailItem.price.toString())

        val imageLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val colorLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        mImageAdapter = RetailItemsListDetailsImageAdapter(mRetailItem.image_url)
        mColorAdapter = RetailItemsListDetailsColorsAdapter(mRetailItem.colors)

        retailItemDetailsRecyclerView.layoutManager = imageLinearLayoutManager
        retailItemDetailsRecyclerView.adapter = mImageAdapter

        retailItemDetailsColorRecyclerView.layoutManager = colorLinearLayoutManager
        retailItemDetailsColorRecyclerView.adapter = mColorAdapter
    }
}