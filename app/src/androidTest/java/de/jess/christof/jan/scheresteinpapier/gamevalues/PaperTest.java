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
public class PaperTest {

    @Test
    public void testGetValue() {
        GameValue paper = new Paper();
        String value = InstrumentationRegistry.getTargetContext().getResources().getString(R.string.game_value_paper);
        assertEquals(paper.getValue(), value);
    }

    @Test
    public void testCompareTo() {
        GameValue paper = new Paper();
        GameValue scissors = new Scissors();
        GameValue stone = new Stone();

        assertEquals(-1, paper.compareTo(scissors));
        assertEquals(1, paper.compareTo(stone));
        assertEquals(0, paper.compareTo(paper));
    }

}
