package air.se.detectlarm.AlertAlarm.core.activities;

import air.se.detectlarm.AlertAlarm.R;
import air.se.detectlarm.AlertAlarm.firebase.EventHelper;
import air.se.detectlarm.AlertAlarm.firebase.Screen;
import air.se.detectlarm.AlertAlarm.wizard.WizardActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_welcome);
        final Intent intent = new Intent(this, WizardActivity.class);
        ((Button) findViewById(R.id.begin_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WelcomeActivity.this.startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        EventHelper.INSTANCE.logCurrentScreen(getAnalytics(), (FragmentActivity) this, Screen.WIZARD_WELCOME);
    }
}
