package com.acrossassistattendance.app.modules.acrossapploginpage.ui

import android.content.Intent
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.base.BaseActivity
import com.acrossassistattendance.app.appcomponents.di.MyApp
import com.acrossassistattendance.app.databinding.ActivityAcrossAppLoginPageBinding
import com.acrossassistattendance.app.extensions.NoInternetConnection
import com.acrossassistattendance.app.extensions.alert
import com.acrossassistattendance.app.extensions.hideKeyboard
import com.acrossassistattendance.app.extensions.isJSONObject
import com.acrossassistattendance.app.extensions.isText
import com.acrossassistattendance.app.extensions.isValidPassword
import com.acrossassistattendance.app.extensions.neutralButton
import com.acrossassistattendance.app.extensions.showProgressDialog
import com.acrossassistattendance.app.modules.acrossappleaveapplicationprogress.ui.AcrossAppLeaveApplicationProgressActivity
import com.acrossassistattendance.app.modules.acrossapploginpage.`data`.viewmodel.AcrossAppLoginPageVM
import com.acrossassistattendance.app.network.models.createlogin.CreateLoginResponse
import com.acrossassistattendance.app.network.resources.ErrorResponse
import com.acrossassistattendance.app.network.resources.SuccessResponse
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import kotlin.String
import kotlin.Unit
import org.json.JSONObject
import retrofit2.HttpException

class AcrossAppLoginPageActivity :
    BaseActivity<ActivityAcrossAppLoginPageBinding>(R.layout.activity_across_app_login_page) {
  private val viewModel: AcrossAppLoginPageVM by viewModels<AcrossAppLoginPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.acrossAppLoginPageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnLogIn.setOnClickListener {
      if(
          viewModel.acrossAppLoginPageModel.value?.etRectangleNineValue.
      isText(true)
          && viewModel.acrossAppLoginPageModel.value?.etRectangleTenValue.
      isValidPassword(true)) {
        this@AcrossAppLoginPageActivity.hideKeyboard()
        viewModel.callCreateLoginApi()
      }
    }
  }

  override fun addObservers() {
    var progressDialog : AlertDialog? = null
    viewModel.progressLiveData.observe(this@AcrossAppLoginPageActivity) {
      if(it) {
        progressDialog?.dismiss()
        progressDialog = null
        progressDialog = this@AcrossAppLoginPageActivity.showProgressDialog()
      } else  {
        progressDialog?.dismiss()
      }
    }
    viewModel.createLoginLiveData.observe(this@AcrossAppLoginPageActivity) {
      if(it is SuccessResponse) {
        val response = it.getContentIfNotHandled()
        onSuccessCreateLogin(it)
      } else if(it is ErrorResponse)  {
        onErrorCreateLogin(it.data ?:Exception())
      }
    }
  }

  private fun onSuccessCreateLogin(response: SuccessResponse<CreateLoginResponse>) {
    viewModel.bindCreateLoginResponse(response.data)
    val destIntent = AcrossAppLeaveApplicationProgressActivity.getIntent(this, null)
    destIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    startActivity(destIntent)
  }

  private fun onErrorCreateLogin(exception: Exception) {
    when(exception) {
      is NoInternetConnection -> {
        Snackbar.make(binding.root, exception.message?:"", Snackbar.LENGTH_LONG).show()
      }
      is HttpException -> {
        val errorBody = exception.response()?.errorBody()?.string()
        val errorObject = if (errorBody != null  && errorBody.isJSONObject()) JSONObject(errorBody)
            else JSONObject()
        val errMessage =
            MyApp.getInstance().getString(R.string.msg_ops_we_en_an_er_pl_try_again_in_few_mi)
        this@AcrossAppLoginPageActivity.alert(MyApp.getInstance().getString(R.string.msg_ops_we_en_an_er_pl_try_again_in_few_mi),errMessage) {
          neutralButton {
          }
        }
      }
    }
  }

  companion object {
    const val TAG: String = "ACROSS_APP_LOGIN_PAGE_ACTIVITY"

  }
}
