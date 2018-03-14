package com.github.gibbrich.githubclient.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.Button
import com.github.gibbrich.githubclient.R
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), ILoginContract.View
{
    @Inject
    lateinit var presenter: LoginPresenter

    private lateinit var loginEditText: TextInputEditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // todo inject dependencies
        var disposable: Disposable

        loginEditText = findViewById(R.id.loginEditText)
        disposable = RxTextView.textChanges(loginEditText)
                .skip(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { presenter.onLoginChanged(it.toString()) }
        presenter.addDisposable(disposable)

        loginButton = findViewById(R.id.loginButton)
        disposable = RxView.clicks(loginButton)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { presenter.onLogin() }
        presenter.addDisposable(disposable)
    }

    override fun setButtonEnabled(isEnabled: Boolean)
    {
        loginButton.isEnabled = isEnabled
    }

    override fun showRepositories()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
