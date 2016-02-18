package com.smartdatainc.managers;

import android.content.Context;

import com.smartdatainc.interfaces.CallBack;
import com.smartdatainc.async.GetWebServiceData;


/**
 * Created by Anurag Sethi
 * This class will be responsible for the communication and will be used to call the webservice requests
 */
public class CommunicationManager {

    private Context context;

    /**
     * Constructor
     * @param contextObj  The Context from where the method is called
     * @return none
     */

    public CommunicationManager(Context contextObj) {
        this.context = contextObj;
    }

    /**
     * Call the required web service based on the URL
     * @param contextObj The Context from where the method is called
     * @param Url Web Service URL to be called
     * @param listnerObj object of interface CallBack
     * @param jsonString the JSON sting of posting data to the web service
     * @param tasksID the ID to differential multiple webservice calls
     * @return none
     */
    public void CallWebService(Context contextObj, String Url, CallBack listnerObj, String jsonString, int tasksID)
    {
        GetWebServiceData gwsdObj = new GetWebServiceData(contextObj, Url, listnerObj, jsonString, tasksID);
        gwsdObj.execute();
    }
    
    
}
