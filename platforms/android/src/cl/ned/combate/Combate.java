/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package cl.ned.combate;

import android.os.Bundle;
import org.apache.cordova.*;

import com.parse.*;

public class Combate extends CordovaActivity 
{
	private static Combate instance = new Combate();
	
	public Combate() {
        instance = this;
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {	
    	
        super.onCreate(savedInstanceState);
        super.init();
        // Set by <content src="index.html" /> in config.xml
        super.setIntegerProperty("loadUrlTimeoutValue", 60000);
        super.loadUrl(Config.getStartUrl());
        //super.loadUrl("file:///android_asset/www/index.html");
        
        
        Parse.initialize(Combate.this, "HEiWxABjPDZEfbTJ8UTQGfQBa8Lz94psDwy9Q2CQ", "GvIK0BPxf0N10hKiNuRQsELTuqdRFnaMirQ7vuOJ");
        PushService.setDefaultPushCallback(this, Combate.class);
        PushService.subscribe(this, "Combate", Combate.class);
        
    	//ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseAnalytics.trackAppOpened(getIntent());
    }
}
 

