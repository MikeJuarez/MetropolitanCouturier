package michaeljuarez.com.metropolitancouturier.mvp.home_page

import android.os.Handler
import michaeljuarez.com.metropolitancouturier.restful_api_structures.CategoryItem
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.metropolitancouturier.views.HomePageActivity
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter

class HomePagePresenter(view : HomePageActivity) : MvpPresenter<HomePageActivity, HomePageModel>(){

    init {
        attachView(view)
        attachModel(HomePageModel(this))
    }

    // Retrieve the Home Page Item List
    fun getHomePageItemList(){

        // Create anonymous implementation of callback
        val callback = object : HomePageModel.LoadHomePageItemsCallback {
            override fun onSuccess(homePageItemList: List<HomePageItem>?) {
                mvpView.homePageItemsCallback(homePageItemList)
            }
        }

        mvpModel.loadHomePageItems(callback)
    }

    fun getCategoryList(homePageItem: HomePageItem.HomePageItem) {

        val callback = object : HomePageModel.GetCategoryItemsCallback {
            override fun getCategoryItems(categoryItemList : ArrayList<CategoryItem>?) {
                mvpView.categoryItemsCallback(homePageItem, categoryItemList)
            }
        }

        mvpModel.getCategoryItems(callback)
    }

}