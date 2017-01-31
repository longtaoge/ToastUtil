# ToastUtil
custom style  Toast


 自定义 吐丝
 
[![](https://jitpack.io/v/longtaoge/ToastUtil.svg)](https://jitpack.io/#longtaoge/ToastUtil)
 
 
![](https://github.com/longtaoge/ToastUtil/blob/be4bb53c3c5d167c41e3460df8bdbe99abdf0ab6/app/arts/Toast.gif)






## How to use 




To get a Git project into your build:

### Step 1. Add the JitPack repository to your build file 


allprojects {

		repositories {
		
			...
			maven { url 'https://jitpack.io' }
			
			
		}



### Step 2. Add the dependency


	
	    dependencies {
	    
	          compile 'com.github.longtaoge:ToastUtil:v0.9'
	}





### Step 3. init 
          
          
           ToastUtils.init(getApplicationContext());



### Step 4.  use
  
  
  
             ToastUtils.i("提示信息").show();




License
--------

    Copyright (C) 2017, longtaoge

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


