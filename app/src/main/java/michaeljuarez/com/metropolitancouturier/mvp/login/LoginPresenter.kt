package michaeljuarez.com.metropolitancouturier.mvp.login

import android.util.Log
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity
import michaeljuarez.com.mvpmodulekotlin.MvpBaseView
import michaeljuarez.com.mvpmodulekotlin.MvpModel
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter

class LoginPresenter(mvpViewParameter : MvpBaseView) : MvpPresenter(mvpViewParameter) {


    init {
        mvpModel = LoginModel()
        attachModel(mvpModel)
    }

    fun getMessage() : String {
        if (mvpModel is LoginModel)
            return mvpModel.getMessage()
    }

}