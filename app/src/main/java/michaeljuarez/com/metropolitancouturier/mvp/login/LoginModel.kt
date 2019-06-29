package michaeljuarez.com.metropolitancouturier.mvp.login

import michaeljuarez.com.mvpmodulekotlin.MvpModel
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter

class LoginModel() : MvpModel() {

    fun getMessage() : String {
       return "Hello World"
    }

}