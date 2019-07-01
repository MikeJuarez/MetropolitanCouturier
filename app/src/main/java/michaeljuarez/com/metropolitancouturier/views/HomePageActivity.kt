package michaeljuarez.com.metropolitancouturier.views

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import michaeljuarez.com.metropolitancouturier.mvp.home_page.HomePagePresenter
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import michaeljuarez.com.metropolitancouturier.R
import michaeljuarez.com.metropolitancouturier.adapters.HomePageAdapter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem

class HomePageActivity : MvpBaseActivity<HomePagePresenter>() {

    lateinit private var mAdapter : HomePageAdapter
    lateinit private var mHomePageItemList : List<HomePageItem>

    override fun createPresenter(): HomePagePresenter {
        return HomePagePresenter(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve the list
        getHomePageItemList()

        // Setup recyclerview
        //setupViews()
    }

    private fun getHomePageItemList() {
        mvpPresenter.getHomePageItemList()
    }

//    private fun setupViews() {
//
//
//        var rightArrow = "\u2192"
////        var homePageList : ArrayList<HomePageItem> = ArrayList()
//
////        mHomePageItemList.forEach {
////            homePageList.add(HomePageItem(it.mBackgroundImagePath + " " + rightArrow , it.mTitle ))
////        }
//
//
////        homePageList.add(HomePageItem("https://melmagazine.com/wp-content/uploads/2018/08/1NPTw5uIT4COChKKS4_Bopg.png", "Women's " + rightArrow))
////        homePageList.add(HomePageItem("https://pmcwwd.files.wordpress.com/2019/01/shutterstock_1290020740.jpg?w=640&h=415&crop=1", "Men's " + rightArrow))
////        homePageList.add(HomePageItem("https://images-na.ssl-images-amazon.com/images/I/91OBAHrgZtL._SL1500_.jpg", "Home" + rightArrow))
////        homePageList.add(HomePageItem("https://my-live-01.slatic.net/p/bd317746ab99f1b9824a368eb8a366c2.jpg", "Lifestyle" + rightArrow))
////        homePageList.add(HomePageItem("https://www.shefinds.com/files/2017/09/urban-outfitters-products.jpg", "Beauty" + rightArrow))
////        homePageList.add(HomePageItem("https://s23527.pcdn.co/wp-content/uploads/2017/05/models-745x381.jpg", "Sale" + rightArrow))
////        homePageList.add(HomePageItem("https://i.pinimg.com/originals/a2/81/96/a281967e2b88f69c54087763af7599c6.jpg", "Gift Cards" + rightArrow))
//
//        // Set Adapter for RecyclerView
//        mAdapter = HomePageAdapter(homePageList)
//
//        // Linearlayout manager for recyclerview
//
//
//    }

    fun homePageItemsCallback(homePageItemList : List<HomePageItem>?) {
        mAdapter = HomePageAdapter(homePageItemList)

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = linearLayoutManager
    }

}
