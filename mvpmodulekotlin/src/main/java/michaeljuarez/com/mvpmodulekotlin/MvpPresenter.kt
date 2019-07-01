package michaeljuarez.com.mvpmodulekotlin

public abstract class MvpPresenter<V : Any, M : Any>() {

    protected lateinit var mvpView : V
    protected lateinit var mvpModel : M

    protected fun attachView(mvpViewParameter : V) {
        mvpView = mvpViewParameter
    }

    protected fun attachModel(mvpModelParameter: M) {
        mvpModel = mvpModelParameter
    }
}