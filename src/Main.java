import gamelogic.SoundEffect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("menu/Menu.fxml")));
        Scene scene = new Scene(root, 838, 612);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.getIcons().add(new Image("/icon_titlebar.png"));
        stage.setTitle("BOMBERMAN");
        stage.setScene(scene);
        stage.show();
        SoundEffect.BACKGROUND.play(true);
    }
}