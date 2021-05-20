package com.example.admin.busbooking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by on 16/02/16.
 */
public class WSsignup {
    private Context context;
    private String message;
    private boolean success;
    public String jid,cid;

    public WSsignup(final Context context) {
        this.context = context;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Method to execute service and parse response.
     */
    public void executeService(final String username,final String pass,final String repass, final String first_name, final String last_name, final String gender, final String mobile_no) {
        final String url = WSConstants.BASE_URL + WSConstants.SIGNUP;
        final String response = new WSUtil().callServiceHttpPost(url, generateLoginRequest(username,pass,repass,first_name,last_name,gender,mobile_no));
        parseResponse(response);
    }

    /* Parse the json response in string.
      *
      * @param response
      */
    private void parseResponse(final String response) {
        if (response != null && response.trim().length() > 0) {
            try {
                final JSONObject jsonObject = new JSONObject(response);
                final WSConstants wsConstants = new WSConstants();
                if (jsonObject != null && jsonObject.length() > 0) {
                    success = jsonObject.optBoolean(wsConstants.PARAMS_SUCCESS);
                    message = jsonObject.optString(wsConstants.PARAMS_RESPONSE);
                    if (success) {
                        //final JSONObject jsonObjectData = jsonObject.optJSONObject(response);
                        if (jsonObject != null && jsonObject.length() > 0) {

                        }
                    }
                    else
                    {
                        message = jsonObject.optString(wsConstants.PARAMS_RESPONSE);
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Generate RequestBody.
     */
    @NonNull
    private RequestBody generateLoginRequest(final String username, final String pass, final String repass, final String first_name, final String last_name, final String gender, final String mobile_no) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_PASSWORD, pass);
        formEncodingBuilder.add(wsConstants.PARAMS_REPASSWORD, repass);
        formEncodingBuilder.add(wsConstants.PARAMS_FIRST_NAME, first_name);
        formEncodingBuilder.add(wsConstants.PARAMS_LAST_NAME, last_name);
        formEncodingBuilder.add(wsConstants.PARAMS_USERNAME, username);
        formEncodingBuilder.add(wsConstants.PARAMS_GENDER, gender);
        formEncodingBuilder.add(wsConstants.PARAMS_MOBILE_NO, mobile_no);
        return formEncodingBuilder.build();
    }

}
