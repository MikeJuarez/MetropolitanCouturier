package michaeljuarez.com.metropolitancouturier.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import michaeljuarez.com.metropolitancouturier.R

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        launchLoginActivity()
    }

    /**
     *  Pause for 3 seconds, then launch HomeResponse page
     */
    private fun launchLoginActivity() {
        Handler().postDelayed( {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
            finish()
        }, 3000)
    }


}