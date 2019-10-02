# This repository contains appium automaton for News App

To run test cases follow the steps mentioned bellow

1. Install appium from this link(s)

 For Linux
  - https://confusedcoders.com/general-programming/mobile/how-to-install-appium-in-ubuntu
  
 For MacOS
  - https://stackoverflow.com/questions/24813589/how-to-setup-appium-on-mac-os-to-run-automated-tests-from-java-classes-on-androi
 
 Note: You can use Appium Desktop tool instead of 'appium' command line tool.
 
 2. Run command
 
  - python3 run.py --appPath <android apk file path>\
                   --platformName <current platform name(currently support only Android)>\
                   --deviceName <device name (e.g Samsung_Galaxy_S8)>\
                   --osVersion <device OS version>\
                   --className <class name to run(e.g LoginPageTest)>\
                   --testName <test name from test class>\
                   
  Simple run command 
  - python3 run.py ----deviceName Google_Pixel_2 --osVersion 9.0 --deviceID <device_id>
