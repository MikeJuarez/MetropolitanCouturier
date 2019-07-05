package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_retailitems.*
import kotlinx.android.synthetic.main.toolbar.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.RetailItemViewPagerAdapter
import michaeljuarez.com.metropolitancouturier.mvp.retail_items.RetailItemPresenter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.Constants
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity

class RetailItemsActivity : MvpBaseActivity<RetailItemPresenter>() {

    private lateinit var  mViewPagerAdapter : RetailItemViewPagerAdapter
    private lateinit var mHomePageType : String

    override fun createPresenter(): RetailItemPresenter {
        return RetailItemPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHomePageType = intent!!.getStringExtra(Constants.HOME_PAGE_TYPE_KEY)
        setContentView(R.layout.activity_retailitems)

        // Set up toolbar
        toolbar.setTitle(mHomePageType)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        retrieveRetailItemList()
    }

    private fun retrieveRetailItemList() {
        mvpPresenter.retrieveRetailItemList()
    }

    fun itemListRetrieved(retailItemList : ArrayList<RetailItem>) {
        mViewPagerAdapter = RetailItemViewPagerAdapter(supportFragmentManager, retailItemList)
        retail_items_viewpager.adapter = mViewPagerAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}