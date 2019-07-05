package michaeljuarez.com.metropolitancouturier.mvp.retail_items

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import michaeljuarez.com.metropolitancouturier.callbacks.RetrieveRetailItemCallback
import michaeljuarez.com.metropolitancouturier.restful_api_structures.ApiHomePage
import michaeljuarez.com.mvpmodulekotlin.MvpModel
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetailItemModel(presenter: RetailItemPresenter) : MvpModel<RetailItemPresenter>() {

    init {
        attachPresenter(presenter)
    }

    @SuppressLint("CheckResult")
    fun retrieveRetailItemList(retrieveRetailItemCallback : RetrieveRetailItemCallback) {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://metropolitancouturier.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiRetailItems = retrofit.create(ApiHomePage::class.java)

        apiRetailItems.getCategoriesWomenNewRetailItems()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                retrieveRetailItemCallback.getRetailItemList(it)
                //mvpPresenter.getHomePageItemListCallback(it)
            },{
                Log.d("error", it.message)
            })
    }



}