package michaeljuarez.com.mvpmodulekotlin

interface MvpBaseView {
    fun showLoading()
    fun hideLoading()
    fun showAlertDialog()
    fun showToast(message : String)
}