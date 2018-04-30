package de.jess.christof.jan.scheresteinpapier.model.gamevalues;

import android.content.Context;
import android.support.annotation.NonNull;


import de.jess.christof.jan.scheresteinpapier.R;
import de.jess.christof.jan.scheresteinpapier.SchereSteinPapierApp;

public class Paper implements GameValue {
    private final String value;

    public Paper() {
        Context context = SchereSteinPapierApp.getContext();
        this.value = context.getString(R.string.game_value_paper);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(@NonNull GameValue o) {
        if (o instanceof Stone) {
            return 1;
        } else if (o instanceof Scissors) {
            return -1;
        } else if (o instanceof Paper) {
            return 0;
        }
        return 0;
    }
}
