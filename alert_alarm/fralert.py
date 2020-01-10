#!/usr/bin/env python3
import frida
import sys

def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
    else:
        print(message)

jscode = """
console.log("Loading script");
Java.perform(function () {
    var WelcomeActivity = Java.use("air.se.detectlarm.AlertAlarm.core.activities.WelcomeActivity");
    WelcomeActivity.onCreate.implementation = function(x) {
        console.log("Clicked");
        this.onCreate(x);
    }});

Java.perform(function () {
    var Activity = Java.use("android.app.Activity");
    Activity.onResume.implementation = function () {
        send("onResume() got called! Let\'s call the original implementation");
        this.onResume();
    }});
"""

device = frida.get_usb_device()
session = device.attach("air.se.detectlarm.AlertAlarm")
script = session.create_script(jscode)
script.on('message', on_message)
script.load()
sys.stdin.read()
