package com.smartdatainc.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smartdatainc.media.R;
import com.smartdatainc.utils.Constants;
import com.smartdatainc.utils.Utility;



/**
 * Created by Anurag Sethi
 */
public class DashboardActivity extends Activity {

    private Utility utilObj;
    private Button btnLogoutObj;
    
    private Button btnChoosePhotoObj;
    
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        initData();
        bindControls();
        
        

    }

    /**
     * Default method of activity life cycle to handle the actions required once the activity starts
     * checks if the network is available or not
     * @return none
     */

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

         
       
    }

    /**
     * Initializes the objects
     * @return none
     */
    private void initData() {
        utilObj = new Utility(this);
        btnLogoutObj = (Button) findViewById(R.id.btnLogout);
         
         btnChoosePhotoObj = (Button) findViewById(R.id.btnChoosePhoto);
         
         
         
    }

    /**
     * Binds the UI controls
     * @return none
     */
    private void bindControls() {

        //logout
        btnLogoutObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilObj.removeKeyFromSharedPreferences("Users", DashboardActivity.MODE_PRIVATE, "userID", true);
                Intent intentObj = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intentObj);
            }
        });
        
        
        //choose photo
        btnChoosePhotoObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj = new Intent(DashboardActivity.this, ChoosePhotoActivity.class);
                startActivity(intentObj);
            }
        });
        
        
        

    }
}
