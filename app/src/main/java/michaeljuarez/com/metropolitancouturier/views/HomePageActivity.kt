package michaeljuarez.com.metropolitancouturier.views

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu

import michaeljuarez.com.metropolitancouturier.mvp.home_page.HomePagePresenter
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.HomePageAdapter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.CategoryItem
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.metropolitancouturier.utility.Constants

class HomePageActivity : MvpBaseActivity<HomePagePresenter>()  {

    lateinit private var mAdapter : HomePageAdapter
    lateinit private var mLinearLayoutManager : LinearLayoutManager

    override fun createPresenter(): HomePagePresenter {
        return HomePagePresenter(this);
    }

    interface HomePageItemClickListener {
        fun itemClicked(homePageItem : HomePageItem)
    }

    // Implementation of HomePageItemClickListener.  Called once list item is clicked
    var mHomePageItemClickListener : HomePageItemClickListener = object : HomePageItemClickListener {
        override fun itemClicked(homePageItem: HomePageItem) {

            var homePageItemKey : HomePageItem.HomePageItem? = HomePageItem.HomePageItem.WOMEN

            when (homePageItem.title) {
                "Women's \u2192" -> homePageItemKey = HomePageItem.HomePageItem.WOMEN
                "Men's \u2192" -> homePageItemKey = HomePageItem.HomePageItem.MEN
                "Home \u2192"-> homePageItemKey = HomePageItem.HomePageItem.HOME
                "Lifestyle \u2192" -> homePageItemKey = HomePageItem.HomePageItem.LIFESTYLE
                "Beauty \u2192" -> homePageItemKey = HomePageItem.HomePageItem.BEAUTY
                "Sale \u2192" -> homePageItemKey = HomePageItem.HomePageItem.SALE
                "Gift Cards \u2192" -> homePageItemKey = HomePageItem.HomePageItem.GIFT_CARDS
            }

            val intent = Intent(this@HomePageActivity, CategoryActivity::class.java)
            intent.putExtra(Constants.HOME_PAGE_TYPE_KEY, homePageItemKey.toString())
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.setTitle(R.string.shop)
        setSupportActionBar(toolbar)

        var toggle = ActionBarDrawerToggle(
            this, home_drawer_layout, toolbar, R.string.shop, R.string.shop)

        home_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        // Retrieve the list
        getHomePageItemList()
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (home_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            home_drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun getHomePageItemList() {
        mvpPresenter.getHomePageItemList()
    }

    fun homePageItemsCallback(homePageItemList : List<HomePageItem>?) {
        mAdapter = HomePageAdapter(homePageItemList, mHomePageItemClickListener)
        mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = mLinearLayoutManager
    }

    fun categoryItemsCallback(category : HomePageItem.HomePageItem, categoryItemList : ArrayList<CategoryItem>?) {



    }



}
