package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.R.id
import michaeljuarez.com.metropolitancouturier.adapters.CategoryAdapter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.CategoryItem
import michaeljuarez.com.metropolitancouturier.utility.Constants
import michaeljuarez.com.metropolitancouturier.utility.Constants.Companion.CATEGORIES_KEY

class CategoryActivity : AppCompatActivity() {

    private lateinit var mCategories : ArrayList<CategoryItem>
    private lateinit var mCategoryType : String

    private val mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_category)


        mCategories = intent.getParcelableArrayListExtra<CategoryItem>(Constants.CATEGORIES_KEY)
        mCategoryType = intent.getStringExtra(Constants.CATEGORY_TYPE_KEY)

        toolbar.setTitle(mCategoryType)
        setSupportActionBar(toolbar)

        var toggle = ActionBarDrawerToggle(
            this, category_home_drawer_layout, toolbar, R.string.shop, R.string.shop)

        category_home_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        setupViews()
    }

    fun setupViews() {
        mRecyclerView = category_recyclerview
        mAdapter = CategoryAdapter(mCategories)

        mRecyclerView.layoutManager = mLinearLayoutManager
        mRecyclerView.adapter = mAdapter

        mRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}