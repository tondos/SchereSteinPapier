package de.jess.christof.jan.scheresteinpapier.model.gamevalues;

import android.content.Context;
import android.support.annotation.NonNull;

import de.jess.christof.jan.scheresteinpapier.R;
import de.jess.christof.jan.scheresteinpapier.SchereSteinPapierApp;

public class Scissors implements GameValue {

    private String value;

    public Scissors() {
        Context context = SchereSteinPapierApp.getContext();
        this.value = context.getString(R.string.game_value_scissors);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public int compareTo(@NonNull GameValue o) {
        if (o instanceof Stone) {
            return -1;
        } else if (o instanceof Paper) {
            return 1;
        } else if (o instanceof Scissors) {
            return 0;
        }
        return 0;
    }
}
