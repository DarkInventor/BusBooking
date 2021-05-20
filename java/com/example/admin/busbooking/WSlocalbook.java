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
public class WSlocalbook {
    private Context context;
    private String message;
    private boolean success;

    public WSlocalbook(final Context context) {
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

    public void executeService(final String name,final String email,final String mobile_no, final String city_of_hire, final String pickup_point, final String destination_in_city, final String no_of_person, final String pickup_date, final String drop_date) {
        final String url = WSConstants.BASE_URL + WSConstants.LOCALBOOKING;
        final String response = new WSUtil().callServiceHttpPost(url, generateLoginRequest(name,email,mobile_no,city_of_hire,pickup_point,destination_in_city,no_of_person,pickup_date,drop_date));
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
    private RequestBody generateLoginRequest(final String name,final String email,final String mobile_no, final String city_of_hire, final String pickup_point, final String destination_in_city, final String no_of_person, final String pickup_date, final String drop_date) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_NAME, name);
        formEncodingBuilder.add(wsConstants.PARAMS_EMAIL, email);
        formEncodingBuilder.add(wsConstants.PARAMS_MOBILE_NO, mobile_no);
        formEncodingBuilder.add(wsConstants.PARAMS_CITY_OF_HIRE, city_of_hire);
        formEncodingBuilder.add(wsConstants.PARAMS_PICKUP_POINT, pickup_point);
        formEncodingBuilder.add(wsConstants.PARAMS_DESTINATION_IN_CITY, destination_in_city);
        formEncodingBuilder.add(wsConstants.PARAMS_NO_OF_PERSON, no_of_person);
        formEncodingBuilder.add(wsConstants.PARAMS_PICKUP_DATE, pickup_date);
        formEncodingBuilder.add(wsConstants.PARAMS_DROP_DATE, drop_date);
        return formEncodingBuilder.build();
    }

}
