package com.edev.broadcastreceivertelephony

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import android.util.Log

class PhoneCallReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent != null) {
            if (intent.getStringExtra(TelephonyManager.EXTRA_STATE)== TelephonyManager.EXTRA_STATE_OFFHOOK){
                Log.d("BROADCAST_PHONE", "onReceive: OFFHOOK")
            }
            if (
                intent.getStringExtra(TelephonyManager.EXTRA_STATE)== TelephonyManager.EXTRA_STATE_IDLE){
                Log.d("BROADCAST_PHONE", "onReceive: IDLE")
                var smsManager: SmsManager =SmsManager.getDefault()
                smsManager.sendTextMessage("+524451415132",null,"Disculpa ahora no puedo contestar, en breve me comunico contigo",null,null)
                Log.d("BROADCAST_PHONE", "sendSMS: ")
            }
            if (
                intent.getStringExtra(TelephonyManager.EXTRA_STATE)== TelephonyManager.EXTRA_STATE_RINGING){
                Log.d("BROADCAST_PHONE", "onReceive: RINGING")
            }
        }
    }
}