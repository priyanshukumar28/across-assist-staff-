package com.acrossassistattendance.app.network.repository

import com.acrossassistattendance.app.R
import com.acrossassistattendance.app.appcomponents.di.MyApp
import com.acrossassistattendance.app.extensions.NoInternetConnection
import com.acrossassistattendance.app.extensions.isOnline
import com.acrossassistattendance.app.network.RetrofitServices
import com.acrossassistattendance.app.network.models.createlogin.CreateLoginRequest
import com.acrossassistattendance.app.network.models.createlogin.CreateLoginResponse
import com.acrossassistattendance.app.network.resources.ErrorResponse
import com.acrossassistattendance.app.network.resources.Response
import com.acrossassistattendance.app.network.resources.SuccessResponse
import java.lang.Exception
import kotlin.String
import org.koin.core.KoinComponent
import org.koin.core.inject

class NetworkRepository : KoinComponent {
  private val retrofitServices: RetrofitServices by inject()

  private val errorMessage: String = "Something went wrong."

  suspend fun createLogin(contentType: String?, createLoginRequest: CreateLoginRequest?):
      Response<CreateLoginResponse> = try {
    val isOnline = MyApp.getInstance().isOnline()
    if(isOnline) {
      SuccessResponse(retrofitServices.createLogin(contentType, createLoginRequest))
    } else {
      val internetException =
          NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
      ErrorResponse(internetException.message ?:errorMessage, internetException)
    }
  } catch(e:Exception) {
    e.printStackTrace()
    ErrorResponse(e.message ?:errorMessage, e)
  }
}
