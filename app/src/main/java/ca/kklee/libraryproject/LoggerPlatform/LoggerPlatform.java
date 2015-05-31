package ca.kklee.libraryproject.LoggerPlatform;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kklee.utilities.Logger.Logger;

import ca.kklee.libraryproject.BuildConfig;
import ca.kklee.libraryproject.R;

/**
 * Created by Keith on 29/05/2015.
 */
public class LoggerPlatform extends Activity {

    private Button verbose, debug, info, warning, error, wtf, viewLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);

        verbose = (Button) findViewById(R.id.test_v);
        debug = (Button) findViewById(R.id.test_d);
        info = (Button) findViewById(R.id.test_i);
        warning = (Button) findViewById(R.id.test_w);
        error = (Button) findViewById(R.id.test_e);
        wtf = (Button) findViewById(R.id.test_wtf);
        viewLog = (Button) findViewById(R.id.view_log_button);

        //initLogger
        Logger.setIsLogging(BuildConfig.DEBUG);
        Logger.setLogToFile(getApplicationContext());

        final Activity activity = this;
        viewLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.showDialog(activity);
            }
        });

        createOnClickListener(verbose, "testing log verbose");
        createOnClickListener(debug, "testing log debug");
        createOnClickListener(info, "testing log info");
        createOnClickListener(warning, "testing log warning");
        createOnClickListener(error, "testing log error");
        createOnClickListener(wtf, "testing log wtf");
    }

    private void createOnClickListener(final Button button, final String message) {
        if (button == null) {
            return;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (button.getId()) {
                    case R.id.test_v:
                        Logger.v(message);
                        break;
                    case R.id.test_d:
                        Logger.d(message);
                        break;
                    case R.id.test_i:
                        Logger.i(message);
                        break;
                    case R.id.test_w:
                        Logger.w(message);
                        break;
                    case R.id.test_e:
                        TestException e = new TestException("testing exception");
                        Logger.e(message, e);
                        break;
                    default:
                        Logger.wtf(message);
                        break;
                }

            }
        });

    }
}
