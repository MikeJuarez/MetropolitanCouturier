package michaeljuarez.com.mvpmodulekotlin

abstract class MvpPresenter(mvpViewParameter : MvpBaseView) {

    protected var mvpView : MvpBaseView
    protected lateinit var mvpModel : MvpModel

    init {
        mvpView = mvpViewParameter
    }

    fun attachModel(mvpModelParameter : MvpModel) {
        this.mvpModel = mvpModelParameter
    }
}