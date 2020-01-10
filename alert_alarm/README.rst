Alert Alarm frida.re scripts
############################

fralert.py
**********

.. literalinclude:: fralert.py
   :language: python

To test in Android Studio using emulator.

1. Create a virtual device: "Pixel 2 API 29 2", Target: Android 10.0 (Google
   APIs), CPU/ABI x86_64.

2. ``$ adb devices``

3. ``$ adb root``

4. Download and extract ``frida-server-12.8.6-android-x86_64.xz``
   (https://github.com/frida/frida/releases)

5. ``$ adb push frida-server-12.8.6-android-x86_64 /data/local/tmp/frida-server``

6. ``$ adb root``
   
7. ``cd /data/local/tmp/ && ./frida-server``

8. Install and start the Alert Alarm apk, either from Android Studio (using run)
   or adb push it and run it.

.. code-block:: bash

    adb install apk/alert_alarm_air.se.detectlarm.AlertAlarm.apk


9. ``$ ./fralert.py``

10. When you press first "Let's begin" green button and then "Cancel" you will
    see the message "Clicked" from Frida.

11. What happened was that we hooked the ``onCreate()`` function in ``class
    WelcomeActivity()`` and just add a print and then call the original
    function. We've also hooked the ``onResume()`` function in
    ``android.app.Activity`` and we can see that being called when giving the
    app focus etc.


loaded.js
*********

Shows all classes loaded under ``air.se.detectlarm.AlertAlarm.core``. As pre
requsite, you have to load it into the device/emulator as described in the
``fralert.py`` section.

.. code-block:: bash

    $ frida -U -l loaded_objs.js air.se.detectlarm.AlertAlarm
