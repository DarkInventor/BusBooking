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
public class WSoutsearch {
    private Context context;
    private String message;
    private boolean success;
    public String jid,cid;

    public WSoutsearch(final Context context) {
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
    public void executeService(final String fromhere, final String tothere,final String forpickup) {
        final String url = WSConstants.BASE_URL + WSConstants.OUTCITY;
        final String response = new WSUtil().callServiceHttpPost(url, generateLoginRequest(fromhere,tothere,forpickup));
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
    private RequestBody generateLoginRequest(final String fromhere,final String tothere,final String forpickup) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_FROMHERE, fromhere);
        formEncodingBuilder.add(wsConstants.PARAMS_TOTHERE, tothere);
        formEncodingBuilder.add(wsConstants.PARAMS_FORPICKUP, forpickup);
        return formEncodingBuilder.build();
    }

}
