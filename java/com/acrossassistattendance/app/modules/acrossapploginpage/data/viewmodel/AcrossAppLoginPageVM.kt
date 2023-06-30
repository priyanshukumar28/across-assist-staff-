package com.acrossassistattendance.app.modules.acrossapploginpage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acrossassistattendance.app.appcomponents.utility.PreferenceHelper
import com.acrossassistattendance.app.modules.acrossapploginpage.`data`.model.AcrossAppLoginPageModel
import com.acrossassistattendance.app.network.models.createlogin.CreateLoginRequest
import com.acrossassistattendance.app.network.models.createlogin.CreateLoginResponse
import com.acrossassistattendance.app.network.repository.NetworkRepository
import com.acrossassistattendance.app.network.resources.Response
import kotlin.Boolean
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AcrossAppLoginPageVM : ViewModel(), KoinComponent {
  val acrossAppLoginPageModel: MutableLiveData<AcrossAppLoginPageModel> =
      MutableLiveData(AcrossAppLoginPageModel())


  var navArguments: Bundle? = null


  val progressLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

  private val networkRepository: NetworkRepository by inject()

  val createLoginLiveData: MutableLiveData<Response<CreateLoginResponse>> =
      MutableLiveData<Response<CreateLoginResponse>>()

  private val prefs: PreferenceHelper by inject()

  fun callCreateLoginApi() {
    viewModelScope.launch {
      progressLiveData.postValue(true)
      createLoginLiveData.postValue(
      networkRepository.createLogin(
      contentType = """application/json""",
          createLoginRequest = CreateLoginRequest(
          password = acrossAppLoginPageModel.value?.etRectangleTenValue,
          username = acrossAppLoginPageModel.value?.etRectangleNineValue)
      )
      )
      progressLiveData.postValue(false)
    }
  }

  fun bindCreateLoginResponse(response: CreateLoginResponse) {
    val acrossAppLoginPageModelValue = acrossAppLoginPageModel.value ?:AcrossAppLoginPageModel()
    prefs.setName(response.data?.name)
    acrossAppLoginPageModel.value = acrossAppLoginPageModelValue
  }
}
