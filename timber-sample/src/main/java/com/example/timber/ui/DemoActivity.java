package com.example.timber.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.timber.R;

import java.util.HashMap;

import timber.log.Event;
import timber.log.Timber;

import static android.widget.Toast.LENGTH_SHORT;

public class DemoActivity extends Activity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.demo_activity);
    ButterKnife.bind(this);
    Timber.tag("LifeCycles");
    Timber.d("Activity Created");
  }

  @OnClick({ R.id.hello, R.id.hey, R.id.hi })
  public void greetingClicked(Button button) {
    Timber.i("A button with ID %s was clicked to say '%s'.", button.getId(), button.getText());
    Toast.makeText(this, "Check logcat for a greeting!", LENGTH_SHORT).show();

    HashMap params = new <String, Object>HashMap();
    params.put("userId", 2233);

    Timber.logEvent(
            new Event(
                    "Click",
                    params,
                    "A button was clicked"
            )
    );
  }
}
