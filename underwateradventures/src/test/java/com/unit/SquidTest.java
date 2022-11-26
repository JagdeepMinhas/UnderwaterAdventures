package com.unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.Entity.*;

public class SquidTest {
    @Test 
    public void testSetSquid()
    {
        Squid squidTest = new Squid(40,40);
        assertEquals(squidTest.getxPosition(), 40);
        assertEquals(squidTest.getyPosition(), 40);
        
    }

    @Test
    public void testSetTouched()
    {
        Squid squidTest = new Squid(40,40);
        squidTest.setTouched(true);
        assertEquals(true, squidTest.touched);
    }

    @Test
    public void testSetSquidController()
    {
        SquidController squidContTest = new SquidController();
        Squid squid1 = squidContTest.squidList.get(0);
        Squid squid2 = squidContTest.squidList.get(1);

        assertEquals(squid1.getxPosition(), 160);
        assertEquals(squid1.getyPosition(), 200);

        assertEquals(squid2.getxPosition(), 800);
        assertEquals(squid2.getyPosition(), 480);
    }

    @Test
    public void testAddSquidToList()
    {
        SquidController squidContTest = new SquidController();
        Squid squid3 = new Squid(40,40);
        squidContTest.addSquid(squid3);

        Squid checkSquid = squidContTest.squidList.get(2);
        assertEquals(checkSquid.getxPosition(), 40);
        assertEquals(checkSquid.getyPosition(), 40);
    }

    @Test 
    public void testSquidFromListTouched()
    {
        SquidController squidContTest = new SquidController();
        Squid squid3 = new Squid(40,40);
        squidContTest.addSquid(squid3);
        squidContTest.squidTouched(true,squid3.getyPosition());

        assertEquals(true, squid3.touched);

    }

}
