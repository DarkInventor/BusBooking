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
public class WSbook {
    private Context context;
    private String message;
    private boolean success;

    public WSbook(final Context context) {
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
    public void executeService(final String name,final String email_id,final String mobile_no, final String source, final String destination, final String date, final String seat, final String agency) {
        final String url = WSConstants.BASE_URL + WSConstants.BOOKING;
        final String response = new WSUtil().callServiceHttpPost(url, generateLoginRequest(name,email_id,mobile_no,source,destination,date,seat,agency));
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
    private RequestBody generateLoginRequest(final String name,final String email_id,final String mobile_no, final String source, final String destination, final String date, final String seat, final String agency) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_NAME, name);
        formEncodingBuilder.add(wsConstants.PARAMS_EMAIL_ID, email_id);
        formEncodingBuilder.add(wsConstants.PARAMS_MOBILE_NO_BOOK, mobile_no);
        formEncodingBuilder.add(wsConstants.PARAMS_SOURCE, source);
        formEncodingBuilder.add(wsConstants.PARAMS_DESTINATIONBOOK, destination);
        formEncodingBuilder.add(wsConstants.PARAMS_DATE, date);
        formEncodingBuilder.add(wsConstants.PARAMS_SEAT, seat);
        formEncodingBuilder.add(wsConstants.PARAMS_AGENCY, agency);
        return formEncodingBuilder.build();
    }

}
