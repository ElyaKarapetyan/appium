import argparse
import xml.etree.ElementTree as xmlParser
import subprocess as terminal
import platform
import os
import json
#TODO add RMDC user
#user = ''

#PATH CONSTANTS
ROOT_DIR = os.path.dirname(os.path.abspath(__file__))
DEFAULT_APK_DIRECTORY = ROOT_DIR + '/src/main/resources/apkIpaFile/'
DEFAULT_CONFIG_DIRECTORY = ROOT_DIR + '/src/main/resources/config/'
TESTNG_XML_PATH = "/src/main/java/testNG.xml"
CLASS_NAME_PREFIX = "com.news_app.mobile.test."
CLASS_NAME_PATH_PREFIX = "/src/main/java/com/news_app/mobile/test/"
DEFAULT_APK_FILE_NAME = 'app-release.apk'
DEFAULT_LOCAL_CONFIG_FILE_NAME = 'devicesConfig.json'

PYTHON_VERSION = platform.python_version()

if "3." in PYTHON_VERSION:
    from bs4 import BeautifulSoup

parser = argparse.ArgumentParser(description="Run NewsApp Mobile UI tests",
                                 formatter_class=argparse.ArgumentDefaultsHelpFormatter)

parser.add_argument("-c", "--className", nargs='+',
                    choices=("LoginPageTest", "CreateAccountPageTest"),
                    help="Reporting to run",
                    default="LoginPageTests")

parser.add_argument("--testName",
                    default="AppTest")
parser.add_argument("--appPath",
                    default=DEFAULT_APK_DIRECTORY + DEFAULT_APK_FILE_NAME, help="file path to APK binary")
parser.add_argument("--platformName",
                    default="Android")
parser.add_argument("--deviceName",
                    default="")
parser.add_argument("--osVersion",
                    default="")
parser.add_argument("--deviceID",
                    default="")

args = parser.parse_args()

#ERROR MESSAGE CONSTANTS
ERROR_INCORRECT_CLASS_NAME = "ERROR: Incorrect class name argument.\n"
ERROR_INCORRECT_RMDC_ARGUMENT = "ERROR: Incorrect RMDC argument.\n"

PARAMETERS = {}
DEVICES = []

TESTNG_XML = xmlParser.Element('suite', name=args.testName)

def generate_testngxml_file():
    """
    Creates TestNG.xml file
    """
    file = open(ROOT_DIR + TESTNG_XML_PATH,"w")
    print("INFO: PYTHON VERSION: " + PYTHON_VERSION)
    if "3." in PYTHON_VERSION:
        bs = BeautifulSoup(xmlParser.tostring(TESTNG_XML), 'xml')
        file.write(str(bs.prettify()).replace('<?xml version="1.0" encoding="utf-8"?>','<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">'))
    else:
        file.write('<?xml version="1.0" encoding="UTF-8"?>\n' + '<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">\n' + str(xmlParser.tostring(TESTNG_XML)))
    file.close()

def generate_parameters():
    """
    Creates XML for TestNG parameters
    """
    for name,value in PARAMETERS.items():
        parameter = xmlParser.Element('parameter', name=name, value=value)
        TESTNG_XML.append(parameter)

def generate_test(platform_name, device_name, os_version, device_id, app_path):
    """
    Creates XML for TestNG tests
    """
    if args.className != None:
        test = xmlParser.Element('test', name='TestsFor-' + platform_name + '-' + device_name)
        platform_parameter = xmlParser.Element('parameter', name='platformName', value=platform_name)
        device_parameter = xmlParser.Element('parameter', name='deviceName', value=device_name)
        os_version_parameter = xmlParser.Element('parameter', name='osVersion', value=os_version)
        device_id_parameter = xmlParser.Element('parameter', name='deviceID', value=device_id)
        app_path_parameter = xmlParser.Element('parameter', name='appPath', value=app_path)
        test.append(os_version_parameter)
        test.append(app_path_parameter)
        test.append(platform_parameter)
        test.append(device_parameter)
        test.append(device_id_parameter)
        test.append(create_classes())
        return test

def create_classes():
    """
    Creates XML for TestNG classes
    """
    classes = xmlParser.Element('classes')
    current_work_dir = os.getcwd()
    for next_class in args.className:
        newClassName = CLASS_NAME_PREFIX + next_class
        test_file = current_work_dir + CLASS_NAME_PATH_PREFIX + next_class + ".java"
        if os.path.isfile(test_file) == False:
            return False
        else:
            class_xmp = xmlParser.Element('class', name=newClassName)
            classes.append(class_xmp)
    return classes

def generate_testng():
    """
    Add test tags in TestNG XML
    """
    TESTNG_XML.append(generate_test(args.platformName, args.deviceName.replace('_', ' '), args.osVersion, args.deviceID, args.appPath))

def main():

    generate_parameters()

    generate_testng()

    generate_testngxml_file()

    print ('java -cp ' + ROOT_DIR + '/target/news_app-1.0-SNAPSHOT.jar org.testng.TestNG ' + ROOT_DIR + '/src/main/java/testNG.xml')
    terminal.run(["appium"])
    terminal.call(["java", "-cp","target/news_app-1.0-SNAPSHOT-jar-with-dependencies.jar","org.testng.TestNG","src/main/java/testNG.xml"])

if __name__ == '__main__':
    main()

