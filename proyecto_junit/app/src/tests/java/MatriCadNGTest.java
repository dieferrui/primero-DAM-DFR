public class MatriCadNGTest {
    
    public MatriCadNGTest() {
    }
    @BeforeClass
    public static void setUpClass() throws Exception { 	// s’executa una única vegada a l’inici de la prova
    }
    @AfterClass
    public static void tearDownClass() throws Exception { 	// s’executa una única vegada al final de la prova
    }
    @BeforeMethod
    public void setUpMethod() throws Exception { 	// s’executa cada vegada a l’inici del mètode
    }
    @AfterMethod
    public void tearDownMethod() throws Exception { 	// s’executa cada vegada al final del mètode
    }
    /**
     * Test of getMaxCad method, of class MatriCad.
     */
    @Test
    public void testGetMaxCad() {
        System.out.println("getMaxCad");
        MatriCad instance = null;
        String expResult = "";
        String result = instance.getMaxCad();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumaCaracters method, of class MatriCad.
     */
    @Test
    public void testGetSumaCaracters() {
        System.out.println("getSumaCaracters");
        MatriCad instance = null;
        int expResult = 0;
        int result = instance.getSumaCaracters();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of getIndexDe method, of class MatriCad.
     */
    @Test
    public void testGetIndexDe() {
        System.out.println("getIndexDe");
        String unaCadena = "";
        MatriCad instance = null;
        int expResult = 0;
        int result = instance.getIndexDe(unaCadena);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
