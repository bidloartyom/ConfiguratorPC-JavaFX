package example.co;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PCConfiguratorApp extends Application {

    private PCConfiguratorController controller;

    @Override
    public void start(Stage primaryStage) {
        // Tworzenie instancji kontrolera
        controller = new PCConfiguratorController();

        // Tworzenie instancji interfejsu użytkownika
        PCConfiguratorUI ui = new PCConfiguratorUI(controller);

        // Tworzenie sceny z głównym węzłem z interfejsu użytkownika
        Scene scene = new Scene(ui.getRootPane(), 600, 600);

        // Dodanie arkusza stylów do sceny
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        // Konfiguracja głównego okna aplikacji
        primaryStage.setTitle("Konfigurator PC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Uruchamianie aplikacji
        launch(args);
    }
}


