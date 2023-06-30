package com.acrossassistattendance.app.modules.acrossappleaveapplicationprogress.`data`.model

import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.di.MyApp
import kotlin.String

data class AcrossAppLeaveApplicationProgressModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtThankYou: String? = MyApp.getInstance().resources.getString(R.string.lbl_thank_you)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_attendance)

)
