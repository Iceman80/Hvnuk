public class Main {
    public static void main(String[] args) throws Exception {
        int p = 10;//ко-во повторов
        Loop test = new Loop();

        for (int x = 1; x <= p; x++) {
            test.hvNuk();
            test.gileya();
            System.out.println("Выполнен тестовый проход № "+x);
        }

    }

}
