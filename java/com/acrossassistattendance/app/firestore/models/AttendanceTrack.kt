package com.acrossassistattendance.app.firestore.models

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.PropertyName
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmField

public class AttendanceTrack {
  @JvmField
  @PropertyName("Name")
  public var name: String? = null

  @JvmField
  @PropertyName("MobileNumber")
  public var mobileNumber: Int? = null

  @JvmField
  @PropertyName("Checkin")
  public var checkin: Timestamp? = null

  @JvmField
  @PropertyName("LongandLan")
  public var longandLan: GeoPoint? = null
}
