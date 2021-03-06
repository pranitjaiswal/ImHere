package fr.launcher.ImHere.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.widget.Toast;

import fr.launcher.ImHere.ImHereApplication;
import fr.launcher.ImHere.R;
import fr.launcher.ImHere.db.DB;

public class ResetPreference extends DialogPreference {

    public ResetPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        super.onClick(dialog, which);
        if (which == DialogInterface.BUTTON_POSITIVE) {
            getContext().deleteDatabase(DB.DB_NAME);
            ImHereApplication.getDataHandler(getContext()).reloadAll();
            PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                    .putBoolean("layout-updated", true).apply();

            Toast.makeText(getContext(), R.string.history_erased, Toast.LENGTH_LONG).show();
        }

    }

}
