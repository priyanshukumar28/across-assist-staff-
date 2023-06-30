package com.acrossassistattendance.app.modules.acrossappattendancewindow.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acrossassistattendance.app.modules.acrossappattendancewindow.`data`.model.AcrossAppAttendanceWindowModel
import org.koin.core.KoinComponent

class AcrossAppAttendanceWindowVM : ViewModel(), KoinComponent {
  val acrossAppAttendanceWindowModel: MutableLiveData<AcrossAppAttendanceWindowModel> =
      MutableLiveData(AcrossAppAttendanceWindowModel())

  var navArguments: Bundle? = null
}
