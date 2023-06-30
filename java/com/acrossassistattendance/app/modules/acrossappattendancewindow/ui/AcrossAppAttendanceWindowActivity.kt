package com.acrossassistattendance.app.modules.acrossappattendancewindow.ui

import androidx.activity.viewModels
import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.base.BaseActivity
import com.acrossassistattendance.app.databinding.ActivityAcrossAppAttendanceWindowBinding
import com.acrossassistattendance.app.modules.acrossappattendancewindow.`data`.viewmodel.AcrossAppAttendanceWindowVM
import kotlin.String
import kotlin.Unit

class AcrossAppAttendanceWindowActivity :
    BaseActivity<ActivityAcrossAppAttendanceWindowBinding>(R.layout.activity_across_app_attendance_window)
    {
  private val viewModel: AcrossAppAttendanceWindowVM by viewModels<AcrossAppAttendanceWindowVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.acrossAppAttendanceWindowVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ACROSS_APP_ATTENDANCE_WINDOW_ACTIVITY"

  }
}
