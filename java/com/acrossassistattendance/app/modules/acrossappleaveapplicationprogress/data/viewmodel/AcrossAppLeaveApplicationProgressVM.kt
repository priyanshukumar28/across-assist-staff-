package com.acrossassistattendance.app.modules.acrossappleaveapplicationprogress.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acrossassistattendance.app.modules.acrossappleaveapplicationprogress.`data`.model.AcrossAppLeaveApplicationProgressModel
import org.koin.core.KoinComponent

class AcrossAppLeaveApplicationProgressVM : ViewModel(), KoinComponent {
  val acrossAppLeaveApplicationProgressModel:
      MutableLiveData<AcrossAppLeaveApplicationProgressModel> =
      MutableLiveData(AcrossAppLeaveApplicationProgressModel())

  var navArguments: Bundle? = null
}
