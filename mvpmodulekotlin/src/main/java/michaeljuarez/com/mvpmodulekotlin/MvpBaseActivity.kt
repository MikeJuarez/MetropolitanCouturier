package michaeljuarez.com.mvpmodulekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class MvpBaseActivity<P : Any> : AppCompatActivity(), MvpBaseView {

    protected var mvpPresenter : P
    protected abstract fun createPresenter() : P;

    init {
        mvpPresenter = createPresenter()
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAlertDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}