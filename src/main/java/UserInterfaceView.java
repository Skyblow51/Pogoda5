import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Введите опцию: 1 - получить текущую погоду, 0 - получить" + "прогногз погоды на 5 дней");
            String cammand = scanner.nextLine();

            try {
                controller.getWeather(cammand, city);

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
