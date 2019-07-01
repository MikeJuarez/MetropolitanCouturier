package michaeljuarez.com.metropolitancouturier.mvp.home_page

import android.util.Log
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import michaeljuarez.com.metropolitancouturier.restful_api_structures.ApiHomePage
import michaeljuarez.com.metropolitancouturier.restful_api_structures.HomePageItem
import michaeljuarez.com.mvpmodulekotlin.MvpModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HomePageModel(presenter : HomePagePresenter) : MvpModel<HomePagePresenter>() {

    private lateinit var database: DatabaseReference

    init {
        attachPresenter(presenter)
    }

    fun getMessage(): String {
        return "Hello World"
    }

    fun loadHomePageItems(): List<HomePageItem>? {

        //val retrofit = RetrofitClient.instance
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://metropolitancouturier.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        var apiHomePageItems = retrofit.create(ApiHomePage::class.java)

        apiHomePageItems.getHomePageItems()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mvpPresenter.getHomePageItemListCallback(it)
            },{
                Log.d("error", it.message)
            })
        return ArrayList()


    }

}