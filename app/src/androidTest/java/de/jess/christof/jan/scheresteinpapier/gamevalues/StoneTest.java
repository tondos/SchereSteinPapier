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
public class StoneTest {

    @Test
    public void testGetValue() {
        GameValue stone = new Stone();
        String value = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.game_value_stone);
        assertEquals(stone.getValue(), value);
    }

    @Test
    public void testCompareTo() {
        GameValue stone = new Stone();
        GameValue scissors = new Scissors();
        GameValue paper = new Paper();

        assertEquals(-1, stone.compareTo(paper));
        assertEquals(1, stone.compareTo(scissors));
        assertEquals(0, stone.compareTo(stone));
    }
}
