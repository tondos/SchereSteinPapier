package de.jess.christof.jan.scheresteinpapier.gamevalues;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.jess.christof.jan.scheresteinpapier.R;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.GameValue;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Paper;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Scissors;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Stone;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ScissorsTest {

    @Test
    public void testGetValue() {
        GameValue scissors = new Scissors();
        String value = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.game_value_scissors);
        assertEquals(scissors.getValue(), value);
    }

    @Test
    public void testCompareTo() {
        GameValue scissors = new Scissors();
        GameValue paper = new Paper();
        GameValue stone = new Stone();

        assertEquals(-1, scissors.compareTo(stone));
        assertEquals(1, scissors.compareTo(paper));
        assertEquals(0, scissors.compareTo(scissors));
    }
}
