

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class mTEST.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class mTEST
{
    /**
     * Default constructor for test class mTEST
     */
    public mTEST()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void member()
    {
        MEMBER mEMBER1 = new MEMBER();
        mEMBER1.readMemberDetails("Jo,Johns,70,145,SF1001,R");
    }
}

