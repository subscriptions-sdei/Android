package com.smartdatainc.utils;

/**
 * Created by Anurag Sethi
 * The class handles the constants used in the application
 */
public class Constants {

    /**
     * Handles the SplashScreen constants
     */
    public static class SplashScreen {
        /**
         * The parameter is used to manage the splash screen delay
         */
        public  static int SPLASH_DELAY_LENGTH = 3000;
    }


    /**
     * Handles webservice constants
     */
    public static class WebServices {

        public static String WS_BASE_URL = "";
        public static String WS_USER_AUTHENTICATION = WS_BASE_URL + "/users/users/login";
        
        
        
    }

    /**
     * Handles the TaskIDs so as to differentiate the web service return values
     */

    public static class TaskID {
        public static int LOGIN_TASK_ID = 100;
        public static int FORGOT_PASSWORD_TASK_ID = 101;
        
        
        
    }

    /**
     * Handles the ButtonTags so as to differentiate them in showAlertDialog()
     */

    public static class ButtonTags {

        public static String TAG_NETWORK_SERVICE_ENABLE = "network services";
        
    }

    /**
     * Handles the JSON Parsing
     */             
    public static class JsonParsing {
        public static int PARSING_JSON_FOR_MESSAGE_ID = 1;
        public static int PARSING_JSON_FOR_RESULT = 2;
    }
    
    /**
     * Handles the Bugsense Key
     */
    public static class BugSenseConstants {
        public static String SPLUNK_API_KEY = "3456798c";
    }

    /**
     * Handles the DebugLog constants
     */
    public static class DebugLog {
        /**
         * Will be the name of the project
         */
        public static String APP_TAG = "facebooksso";
        /**
         * APP_MODE = 1 means Debug Mode
         * APP_MODE = 0 means Live Mode
         * Must change to 0 when going live
         */
        public static int APP_MODE = 1;
        /**
         * Name of the directory in which log file needs to be saved
         */
        public static String APP_ERROR_DIR_NAME = "facebooksso"; 
        /**
         * Name of the log file
         */
        public static String APP_ERROR_LOG_FILE_NAME = "log.txt";
    }
    
    /**
     * Handles the constant for Google Play Services
     */
    public static class GooglePlayService {
        public final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    }
    
    /**
     * Handles the requestCodes
     */
    public static class RequestCodes {
    
        
    }

    
    
    
}
