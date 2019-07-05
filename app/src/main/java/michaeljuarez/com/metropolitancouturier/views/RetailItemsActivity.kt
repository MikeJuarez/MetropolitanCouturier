package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_retailitems.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.RetailItemViewPagerAdapter
import michaeljuarez.com.metropolitancouturier.mvp.retail_items.RetailItemPresenter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity

class RetailItemsActivity : MvpBaseActivity<RetailItemPresenter>() {


    private lateinit var  mViewPagerAdapter : RetailItemViewPagerAdapter

    override fun createPresenter(): RetailItemPresenter {
        return RetailItemPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retailitems)
        retrieveRetailItemList()
    }

    private fun retrieveRetailItemList() {
        mvpPresenter.retrieveRetailItemList()
    }

    fun itemListRetrieved(retailItemList : ArrayList<RetailItem>) {
        mViewPagerAdapter = RetailItemViewPagerAdapter(supportFragmentManager, retailItemList)
        retail_items_viewpager.adapter = mViewPagerAdapter
    }



}