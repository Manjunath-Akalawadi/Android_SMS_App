package com.demo.manju.sms_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");
        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[0]);

        Intent sintent = new Intent(context,MainActivity.class);
        sintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sintent.putExtra("number",smsMessage.getDisplayOriginatingAddress());
        sintent.putExtra("message",smsMessage.getMessageBody());
        context.startActivity(sintent);

        Toast.makeText(context,"SMS Recived from: "+smsMessage.getOriginatingAddress(),Toast.LENGTH_LONG).show();

    }
}
