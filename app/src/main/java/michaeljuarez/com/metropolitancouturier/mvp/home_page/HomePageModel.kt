package michaeljuarez.com.metropolitancouturier.mvp.home_page

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import michaeljuarez.com.metropolitancouturier.restful_api_structures.ApiHomePage
import michaeljuarez.com.metropolitancouturier.restful_api_structures.CategoryItem
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.mvpmodulekotlin.MvpModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.function.Function
import java.util.stream.Collectors.toList

class HomePageModel(presenter : HomePagePresenter) : MvpModel<HomePagePresenter>() {

    init {
        attachPresenter(presenter)
    }

    interface LoadHomePageItemsCallback {
        fun onSuccess(homePageItemList : List<HomePageItem>?)
    }

    @SuppressLint("CheckResult")
    fun loadHomePageItems(homePageCallback : LoadHomePageItemsCallback) {

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://metropolitancouturier.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiHomePageItems = retrofit.create(ApiHomePage::class.java)

        apiHomePageItems.getHomePageItems()
            .map { addRightArrows(it) }
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                homePageCallback.onSuccess(it)
            },{
                Log.d("error", it.message)
            })
    }

    // Private function that adds right arrows to the titles of home page items
    private fun addRightArrows(list : List<HomePageItem>) : List<HomePageItem> {

        list.forEach {
            it.title += " \u2192"
        }

        return list
    }

}