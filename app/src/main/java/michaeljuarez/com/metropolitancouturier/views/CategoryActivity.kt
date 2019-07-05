package michaeljuarez.com.metropolitancouturier.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.toolbar.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.CategoryAdapter
import michaeljuarez.com.metropolitancouturier.callbacks.CategoryClickCallback
import michaeljuarez.com.metropolitancouturier.restful_api_structures.CategoryItem
import michaeljuarez.com.metropolitancouturier.utility.Constants

class CategoryActivity : AppCompatActivity() {

    private lateinit var mHomePageType : String

    private val mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_category)

        // Set toolbar and toolbar title
        mHomePageType = intent.getStringExtra(Constants.HOME_PAGE_TYPE_KEY)
        toolbar.setTitle(mHomePageType)
        setSupportActionBar(toolbar)

        // Set up Navigation Drawer Layout
        var toggle = ActionBarDrawerToggle(this, category_home_drawer_layout, toolbar, R.string.shop, R.string.shop)
        category_home_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        // Set up recyclerviews
        setupViews()
    }

    /**
     * Set up RecyclerView
     */
    fun setupViews() {
        mRecyclerView = category_recyclerview
        mAdapter = CategoryAdapter(getCategoryList(), mCategoryClickCallbackClicked)

        mRecyclerView.layoutManager = mLinearLayoutManager
        mRecyclerView.adapter = mAdapter

        mRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    /**
     *  Retrieve list of Categories
     */
    fun getCategoryList() : ArrayList<String>? {
        var categoryList  = ArrayList<String>()

        categoryList.add(getString(R.string.category_new))
        categoryList.add(getString(R.string.category_dresses_rompers))
        categoryList.add(getString(R.string.category_tops))
        categoryList.add(getString(R.string.category_jackets))
        categoryList.add(getString(R.string.category_bottoms))
        categoryList.add(getString(R.string.category_intimates))
        categoryList.add(getString(R.string.category_swim))
        categoryList.add(getString(R.string.category_vintage))
        categoryList.add(getString(R.string.category_beauty))
        categoryList.add(getString(R.string.category_shoes))
        categoryList.add(getString(R.string.category_brands))
        categoryList.add(getString(R.string.category_sale))

        return categoryList
    }

    var mCategoryClickCallbackClicked : CategoryClickCallback = object : CategoryClickCallback {
        override fun newCategoryClicked() {
            val intent = Intent(this@CategoryActivity, RetailItemsActivity::class.java)
            intent.putExtra(Constants.HOME_PAGE_TYPE_KEY, mHomePageType)
            startActivity(intent)
        }
    }

}