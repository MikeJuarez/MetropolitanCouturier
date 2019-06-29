package michaeljuarez.com.metropolitancouturier

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import michaeljuarez.com.metropolitancouturier.mvp.login.LoginPresenter
import michaeljuarez.com.mvpmodulekotlin.MvpBaseActivity
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Attach a new presenter
        attachPresenter(LoginPresenter(this))

        buttonClick.setOnClickListener(View.OnClickListener {
            showToast("Showing toast")
        })
    }
}
