package com.smartdatainc.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.smartdatainc.dataobject.AppInstance;
import com.smartdatainc.helpers.TransparentProgressDialog;
import org.json.JSONArray;
import org.json.JSONException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.view.inputmethod.InputMethodManager;
import java.text.DecimalFormat;

import com.smartdatainc.facebooksso.R;




/**
 * Created by Anurag Sethi
 * This class is used to define the common functions to be used in the application
 */
public class Utility {

    Context context;
    TransparentProgressDialog progressDialogObj;

    /**
     * Constructor
     * @param contextObj  The Context from where the method is called
     * @return none
     */

    public Utility(Context contextObj) {
        context = contextObj;
    }


    /**
     * The method validates email address
     * @param email email address to validate
     * @return true if the email entered is valid
     */
     public boolean checkEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * This method will convert object to Json String
     * @param obj Object whose data needs to be converted into JSON String
     * @return object data in JSONString
     */
    public String convertObjectToJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }


    /**
     * The method will start the loader till the AsynTask completes the assigned task
     * @since 2014-08-20
     * @param context The Context from where the method is called
     * @param image_for_rotation_resource_id resourceID of the image to be displayed as loader
     * @return none
     */
    public void startLoader(Context context, int image_for_rotation_resource_id) {
        progressDialogObj = new TransparentProgressDialog(this.context, image_for_rotation_resource_id);
        AppInstance.logObj.printLog("startLoader=" + progressDialogObj);
        progressDialogObj.show();
    }

    /**
     * The method will start the loader till the AsynTask completes the assigned task
     * @since 2014-08-20
     * @return none
     */
    public void stopLoader() {
        AppInstance.logObj.printLog("stopLoader=" + progressDialogObj);
        progressDialogObj.dismiss();
    }


    /**
     * The method will create an alertDialog box
     * @param context The Context from where the method is called
     * @param title  of the dialog box
     * @param msgToShow message to be shown in the dialog box
     * @param positiveBtnText text to be shown in the positive button
     * @param negativeBtnText text to be shown in the negative button
     * @param btnTagName to differentiate the action on the displayed activity
     * @param data to be posted on click of a button
     * @return none
     */
    public void showAlertDialog(final Context context, String title, String msgToShow, String positiveBtnText, String negativeBtnText, final String btnTagName, final int data) {

        AlertDialog.Builder dialogObj = new AlertDialog.Builder(context);
        dialogObj.setIcon(android.R.drawable.ic_dialog_alert);
        dialogObj.setTitle(title);
        dialogObj.setMessage(msgToShow);
        dialogObj.setPositiveButton(positiveBtnText, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                // TODO Auto-generated method stub
                // Show location settings when the user acknowledges the alert dialog
               if(btnTagName.equalsIgnoreCase("network services")) {
                    Intent intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                    context.startActivity(intent);
                }

                

            }

        });

        if(negativeBtnText != null) {
            dialogObj.setNegativeButton(negativeBtnText, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub

                }
            });
        }

        dialogObj.show();

    }

    /**
     * The method will return the date and time in requested format
     * @param selectedDateTime to be converted to requested format
     * @param requestedFormat  the format in which the provided datetime needs to be changed
     * @param formatString differentiate parameter to format date or time
     * @return formated date or time
     */
    public String formatDateTime(String selectedDateTime, String requestedFormat, String formatString) {

        if(formatString.equalsIgnoreCase("time")) {
            SimpleDateFormat ft = new SimpleDateFormat ("hh:mm");
            Date dateObj = null;

            try {
                dateObj = ft.parse(selectedDateTime);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            long millis = dateObj.getTime();
            SimpleDateFormat simpleDateFormatObj = new SimpleDateFormat (requestedFormat);
            return simpleDateFormatObj.format(millis);

        }//if
        else if(formatString.equalsIgnoreCase("date")) {
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-mm-dd");
            Date dateObj = null;

            try {
                dateObj = ft.parse(selectedDateTime);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            SimpleDateFormat simpleDateFormatObj = new SimpleDateFormat (requestedFormat);
            return simpleDateFormatObj.format(dateObj);


        }
        return null;

    }

    /**
     * The method will return current time
     * @return current time
     */
    public String getCurrentTime() {
        String am_pm = "";
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        if(minutes < 12) {
            String modifiedMinutes = "0" + minutes;
            minutes = Integer.parseInt(modifiedMinutes);
        }
        AppInstance.logObj.printLog("minutes=" + minutes);

        if(c.get(Calendar.AM_PM) == Calendar.AM) {
            am_pm = "AM";
        }
        else if(c.get(Calendar.AM_PM) == Calendar.PM) {
            am_pm = "PM";
        }

        String currentTime = Integer.toString(hour) + ":" + Integer.toString(minutes) + " " + am_pm;
        return currentTime;
    }

    /**
     * The method will return current date
     * @return current date
     */
    public String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        String currentDate = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);
        return currentDate;
    }

    /**
     * The method show the error
     * @param contextObj context of the activity from where the method is called
     * @param message message to be displayed
     * @param textViewObj object of the textView where the error message will be shown
     * @param editTextObj object of the editText containing the error
     */
    public void showError(Context contextObj, String message, TextView textViewObj, EditText editTextObj) {
        if(message == null || message.equalsIgnoreCase("")) {
            textViewObj.setVisibility(View.GONE);
        }
        else {
            textViewObj.setVisibility(View.VISIBLE);
            textViewObj.setText(message);
            textViewObj.setTextColor(contextObj.getResources().getColor(R.color.error_text_color));
        }

    }

    /**
     * This method will convert json String to ArrayList
     * @since 2014-08-13
     * @param jsonString string which needs to be converted to ArrayList
     * @return ArrayList of type String
     * @throws JSONException
     */
    private ArrayList<String> convertJsonStringToArray(String jsonString) throws JSONException {

        ArrayList<String> stringArray = new ArrayList<String>();

        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray.add(jsonArray.getString(i));
        }

        return stringArray;
    }


    /**
     * The method will save the data in shared preferences defined by "sharedPrefName" and the key provided by "key" parameter
     * @since 2014-08-13
     * @param sharedPrefName name of the container
     * @param mode private
     * @param key name of the key in which values are saved
     * @param value data to be saved associated to the particular key
     * @return none
     */

    public void saveDataInSharedPreferences(String sharedPrefName, int mode, String key, String value){
        SharedPreferences prefsObj = context.getSharedPreferences(sharedPrefName, mode);
        SharedPreferences.Editor editorObj = prefsObj.edit();
        editorObj.putString(key, value);
        editorObj.commit();
    }

    /**
     * The method will read the data in shared preferences defined by "sharedPrefName" and the key provided by "key" parameter
     * @param sharedPrefName name of the container
     * @param mode private
     * @param key name of the key in which values are saved
     * @return String
     */

    public String readDataInSharedPreferences(String sharedPrefName, int mode, String key) {
        SharedPreferences prefsObj = context.getSharedPreferences(sharedPrefName, mode);
        return prefsObj.getString(key, "");
    }

    /**
     * The method will remove the data stored in shared preferences defined by "sharedPrefName" and the key provided by "key" parameter
     * @param sharedPrefName name of the container
     * @param mode private
     * @param key name of the key in which values are saved
     * @param removeAll if true will remove all the values stored in shared preferences else remove as specified by key
     */
    public void removeKeyFromSharedPreferences(String sharedPrefName, int mode, String key, boolean removeAll) {

        SharedPreferences prefsObj = context.getSharedPreferences(sharedPrefName, mode);
        SharedPreferences.Editor editorObj = prefsObj.edit();
        if(removeAll) {
            editorObj.clear();
        }
        else {
            editorObj.remove(key);
        }
        editorObj.commit();
    }
    
    /**
     * show message to user using showToast
     *
     * @param mContext contains context of application
     * @param message  contains text/message to show
     * @param durationForMessageToAppear 1 will show the message for short duration else long duration
     */
    public void showToast(Context mContext, String message, int durationForMessageToAppear) {
        if(durationForMessageToAppear == 1) {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }

    }

    /**
     * This method will hide virtual keyboard if opened
     *
     * @param mContext contains context of application
     */
    public void hideVirtualKeyboard(Context mContext) {

        try {

            IBinder binder = ((Activity) mContext).getWindow().getCurrentFocus()
                    .getWindowToken();

            if (binder != null) {
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(binder, 0);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * This method will show virtual keyboard where ever required
     *
     * @param mContext contains context of application
     */
    public void showVirtualKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    /**
     * Format value up to 2 decimal places
     * @param num - number to be formatted
     */
    public float formatValueUpTo2Decimals(double num) {

        try {

            DecimalFormat df = new DecimalFormat("#.##");

            String value = df.format(num);
            String decimalPlace = ",";

            if (value.contains(decimalPlace)) {
                value = value.replace(decimalPlace, ".");
            }

            return Float.parseFloat(value);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (float) num;

    }
    
    
    
}
