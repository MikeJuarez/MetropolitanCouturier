package michaeljuarez.com.metropolitancouturier.restful_api_structures

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiHomePage {

    @GET("/home.json")
    fun getHomePageItems() : Observable<List<HomePageItem>>

}