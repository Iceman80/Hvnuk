public class Main {
    public static void main(String[] args) throws Exception {
        Test1Page page1 = new Test1Page();
        Test2Page page2 = new Test2Page();
        Test3Page page3 = new Test3Page();
        Test4Page page4 = new Test4Page();

        page1.setUp();
        page1.test1Page();
        page1.tearDown();
        page2.setUp();
        page2.test2Page();
        page2.tearDown();
        page3.setUp();
        page3.test3Page();
        page3.tearDown();
        page4.setUp();
        page4.test4Page();
        page4.tearDown();

    }
}
