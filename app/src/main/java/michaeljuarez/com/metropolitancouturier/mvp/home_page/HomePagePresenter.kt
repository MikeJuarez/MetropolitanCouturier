package michaeljuarez.com.metropolitancouturier.mvp.home_page

import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.metropolitancouturier.views.HomePageActivity
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter

class HomePagePresenter(view : HomePageActivity) : MvpPresenter<HomePageActivity, HomePageModel>(){

    init {
        attachView(view)
        attachModel(HomePageModel(this))
    }

    fun getHomePageItemList(){
        mvpModel.loadHomePageItems()
    }

    fun getHomePageItemListCallback(homePageItemList : List<HomePageItem>?) {
        mvpView.homePageItemsCallback(homePageItemList)
    }

    fun getMessage() : String {
        return mvpModel.getMessage()
    }

}