package com.acrossassistattendance.app.modules.acrossappattendancewindow.`data`.model

import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.di.MyApp
import kotlin.String

data class AcrossAppAttendanceWindowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAttendanceWind: String? =
      MyApp.getInstance().resources.getString(R.string.msg_attendance_wind)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPleasefillall: String? =
      MyApp.getInstance().resources.getString(R.string.msg_please_fill_all)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCheckIn: String? = MyApp.getInstance().resources.getString(R.string.lbl_check_in)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDate: String? = MyApp.getInstance().resources.getString(R.string.lbl_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHourMinutes: String? = MyApp.getInstance().resources.getString(R.string.lbl_hour_minutes)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGeolocation: String? = MyApp.getInstance().resources.getString(R.string.lbl_geolocation)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPleaseClickYo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_please_click_yo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etRectangleTwentyOneValue: String? = null
)
