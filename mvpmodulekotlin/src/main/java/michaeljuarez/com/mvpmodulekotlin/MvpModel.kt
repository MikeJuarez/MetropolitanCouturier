package michaeljuarez.com.mvpmodulekotlin

abstract class MvpModel<P : Any>() {

    protected lateinit var mvpPresenter: P

    protected fun attachPresenter(mvpPresenterParameter : P) {
        mvpPresenter = mvpPresenterParameter
    }

}