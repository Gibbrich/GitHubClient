package com.github.gibbrich.githubclient.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.github.gibbrich.githubclient.GitHubClientApplication
import com.github.gibbrich.githubclient.R
import com.github.gibbrich.githubclient.base.BaseActivity
import com.github.gibbrich.githubclient.login.di.LoginModule
import com.github.gibbrich.githubclient.repositories.RepositoriesActivity
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class LoginActivity : BaseActivity<ILoginContract.Presenter>(), ILoginContract.View
{
    @Inject override lateinit var presenter: ILoginContract.Presenter
    @BindView(R.id.loginEditText) lateinit var loginEditText: TextInputEditText
    @BindView(R.id.loginButton) lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ButterKnife.bind(this)

        GitHubClientApplication
                .INSTANCE
                .appComponent
                .plusLoginComponent(LoginModule(this))
                .inject(this)
    }

    override fun onResume()
    {
        super.onResume()

        var disposable: Disposable

        disposable = RxView.clicks(loginButton)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { presenter.onLogin() }
        presenter.addDisposable(disposable)

        disposable = RxTextView.textChanges(loginEditText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { presenter.onLoginChanged(it.toString()) }
        presenter.addDisposable(disposable)
    }

    override fun setButtonEnabled(isEnabled: Boolean)
    {
        loginButton.isEnabled = isEnabled
    }

    override fun showRepositories()
    {
        val intent = RepositoriesActivity.getInstance(this, loginEditText.text.toString())
        startActivity(intent)
    }

    override fun showLoginError()
    {
        Toast.makeText(this, "Error occurred during login", Toast.LENGTH_SHORT).show()
    }
}
