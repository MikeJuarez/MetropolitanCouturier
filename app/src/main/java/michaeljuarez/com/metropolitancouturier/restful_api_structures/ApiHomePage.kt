package michaeljuarez.com.metropolitancouturier.restful_api_structures

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiHomePage {

    @GET("/Home.json")
    fun getHomePageItems() : Observable<List<HomePageItem>>

    @GET("/Categories/Women/New.json")
    fun getCategoriesWomenNewRetailItems() : Observable<ArrayList<RetailItem>>

}