package michaeljuarez.com.mvpmodulekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import javax.xml.transform.Templates

open class MvpBaseActivity : AppCompatActivity(), MvpBaseView {

    protected lateinit var mvpPresenter : MvpPresenter

    fun attachPresenter(mvpPresenter: MvpPresenter) {
        this.mvpPresenter = mvpPresenter
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