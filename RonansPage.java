/******
 * Application Name - F13K Cancer
 * Created by - Ronan Sneddon B00694513
 * Date Created - 5/4/16
 * Description - Contact Page for F13K Cancer Android Application
 * Date Edited - 19/4/15
 ******/

package com.example.GroupAndroidApp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RonansPage extends Activity

{
   Spinner spinnerMenu;
   ArrayAdapter menu_array;
   /**
    * Called when the activity is first created.
    */
   @Override


   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.ronan);

      //Dropdown Menu
      spinnerMenu = (Spinner) findViewById(R.id.spinnerMenu);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu_array, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerMenu.setAdapter(adapter);

      spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
         {
            String s = ((TextView) view).getText().toString();
            if (s.equals("Shop"))
               startActivity(new Intent(view.getContext(), MyActivity.class));
            else if (s.equals("Marie Curie"))
               startActivity(new Intent(view.getContext(), ReubensPage.class));
            else if (s.equals("About The Charity"))
               startActivity(new Intent(view.getContext(), NeilsPage.class));
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent)
         {

         }
      });
   }

   //Methods for button clicks linking to websites
   public void openWebsite(View view)
   {
      Intent openWebsiteIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://f13kcancer.com/"));
      startActivity(openWebsiteIntent);
   }

   public void openTwitter(View view)
   {
      Intent openTwitterIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/f13kcancer"));
      startActivity(openTwitterIntent);
   }

   public void openFacebook(View view)
   {
      Intent openFacebookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/leejohnstonracing"));
      startActivity(openFacebookIntent);
   }

   public void openInstagram(View view)
   {
      Intent openInstagramIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/little_general_lee"));
      startActivity(openInstagramIntent);
   }
}