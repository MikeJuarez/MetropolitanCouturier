package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import michaeljuarez.com.metropolitancouturier.mvp.home_page.HomePagePresenter
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.HomePageAdapter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem

class HomePageActivity : MvpBaseActivity<HomePagePresenter>()  {


    lateinit private var mAdapter : HomePageAdapter
    lateinit private var mLinearLayoutManager : LinearLayoutManager

    override fun createPresenter(): HomePagePresenter {
        return HomePagePresenter(this);
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
        mAdapter = HomePageAdapter(homePageItemList)
        mLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = mLinearLayoutManager
    }

}
