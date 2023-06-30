package com.acrossassistattendance.app.modules.acrossappleaveapplicationprogress.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.base.BaseActivity
import com.acrossassistattendance.app.databinding.ActivityAcrossAppLeaveApplicationProgressBinding
import com.acrossassistattendance.app.modules.acrossappleaveapplicationprogress.`data`.viewmodel.AcrossAppLeaveApplicationProgressVM
import kotlin.String
import kotlin.Unit

class AcrossAppLeaveApplicationProgressActivity :
    BaseActivity<ActivityAcrossAppLeaveApplicationProgressBinding>(R.layout.activity_across_app_leave_application_progress)
    {
  private val viewModel: AcrossAppLeaveApplicationProgressVM by
      viewModels<AcrossAppLeaveApplicationProgressVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.acrossAppLeaveApplicationProgressVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ACROSS_APP_LEAVE_APPLICATION_PROGRESS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AcrossAppLeaveApplicationProgressActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
