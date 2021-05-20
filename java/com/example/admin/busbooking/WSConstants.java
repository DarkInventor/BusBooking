package com.example.admin.busbooking;


import okhttp3.MediaType;

/**
 * Created by on 11/01/16.
 */
public class WSConstants {

    //public final static String BASE_URL = "http://103.238.104.154/fwdapi/";
    //public final static String BASE_URL = "http://104.20.68.46/members/website/busbookingapp/ftp-redirect/public_html/fwdapi";
   // public final static String BASE_URL = "http://192.168.2.7/fwd
    // dapi/";
    //public final static String BASE_URL = "http://192.168.2.5/fwdapi/";

    public final static String BASE_URL = "http://192.168.43.62/fwdapi/";

    //public final static String BASE_URL = "http://192.168.2.4/fwdapi/";

    public final static int CONNECTION_TIMEOUT = 30;
    public final static int SUCCESS_1 = 1;
    public final static int SUCCESS_2 = 2;
    public final static int SUCCESS_100 = 100;

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    public final String DEVICE_TYPE = "ANDROID";
    public final String DEVICE_TYPE_ANDROID = "android";
    public final String PARAMS_RESPONSE = "response";
    public final String PARAMS_SUCCESS = "success";
    public final String PARAMS_NEXT_PAGE = "next_page";
    public final String PARAMS_RESULT = "query";
    public final String PARAMS_QUESTION_MARK = "?";
    public final String PARAMS_AND = "&";
    public final String PARAMS_EQUAL = "=";
    public final String PARAMS_SPACE = "%20";

    public enum Language {
        EN,
        NL,
    }

    /**
     * Settings Name
     */
    public final String PARAMS_SETTINGS = "settings";

    /**
     * Methods Name
     */
    public final static String LOGIN = "login.php";
    public final static String SIGNUP= "user.php";
    public final static String CITY= "city.php";
    public final static String LOCALCITY= "localcity.php";
    public final static String OUTCITY= "outcity.php";
    public final static String BOOKING="booking.php";
    public final static String LOCALBOOKING="hire.php";


    /**
     * Parameters Name
     */
    public final String PARAMS_USERNAME = "username";
    public final String PARAMS_PASSWORD = "pass";
    public final String PARAMS_REPASSWORD = "repass";
    public final String PARAMS_FIRST_NAME = "first_name";
    public final String PARAMS_LAST_NAME = "last_name";
    public final String PARAMS_GENDER= "gender";
    public final String PARAMS_MOBILE_NO="mobile_no";
    public final String PARAMS_CITY_NAME="city_name";
    public final String PARAMS_CITY_OF_HIRE="city_of_hire";
    public final String PARAMS_PICK_UP_POINT="pick_up_point";
    public final String PARAMS_DESTINATION="destination";
    public final String PARAMS_FROMHERE="fromhere";
    public final String PARAMS_TOTHERE="tothere";
    public final String PARAMS_FORPICKUP="forpickup";
    public final String PARAMS_NAME="name";
    public final String PARAMS_EMAIL_ID="email_id";
    public final String PARAMS_MOBILE_NO_BOOK="mobile_no";
    public final String PARAMS_SOURCE="source";
    public final String PARAMS_DESTINATIONBOOK="destination";
    public final String PARAMS_DATE="date";
    public final String PARAMS_SEAT="seat";
    public final String PARAMS_AGENCY="agency";
    public final String PARAMS_NO_OF_PERSON="no_of_person";
    public final String PARAMS_PICKUP_DATE="pickup_date";
    public final String PARAMS_DROP_DATE="drop_date";
    public final String PARAMS_LOCALNAME="localname";
    public final String PARAMS_EMAIL="email";
    //public final String PARAMS_MOBILE_NO="mobile_no";
    public final String PARAMS_LOCALCITY_OF_HIRE="localcity_of_hire";
    public final String PARAMS_PICKUP_POINT="pickup_point";
    public final String PARAMS_DESTINATION_IN_CITY="destination_in_city";

}
