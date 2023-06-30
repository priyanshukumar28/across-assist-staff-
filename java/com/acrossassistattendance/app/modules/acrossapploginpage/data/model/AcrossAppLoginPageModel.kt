package com.acrossassistattendance.app.modules.acrossapploginpage.`data`.model

import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.di.MyApp
import kotlin.String

data class AcrossAppLoginPageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEmployeesAtten: String? =
      MyApp.getInstance().resources.getString(R.string.msg_employees_atten)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLogintoyoura: String? =
      MyApp.getInstance().resources.getString(R.string.msg_login_to_your_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmployeeID: String? = MyApp.getInstance().resources.getString(R.string.lbl_employee_id)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPassword: String? = MyApp.getInstance().resources.getString(R.string.lbl_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_don_t_have_an_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPleasecontact: String? =
      MyApp.getInstance().resources.getString(R.string.msg_please_contact)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etRectangleNineValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etRectangleTenValue: String? = null
)
