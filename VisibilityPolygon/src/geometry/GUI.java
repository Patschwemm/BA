package geometry;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;


public class GUI extends Application {

    public static Polygon polygon = new Polygon();
    public static Stage primary;
    public static Group pointscene = new Group();
    public static Group edgescene = new Group();


    public void start(Stage primaryStage) throws Exception {

        //set window sizes
        primary = primaryStage;
        primaryStage.setWidth(1200);
        primaryStage.setHeight(720);

        //root as parent group, others as subgroups
        StackPane root = new StackPane();
        BorderPane foreground = new BorderPane();
        BorderPane settinglayer = new BorderPane();
        BorderPane background = new BorderPane();



        //set scene to root
        primaryStage.setTitle("Visibility Polygon Applet");
        Scene scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());


        //create background for settings in foreground
        BackgroundFill greybg = new BackgroundFill(Color.rgb(200, 200, 200), CornerRadii.EMPTY, null);
        Region settings_background = new Region();
        settings_background.setPrefSize(Settings.get().getSettingsWidth(), 300);
        settings_background.setBackground(new Background(greybg));
        settings_background.toFront();
        foreground.setRight(settings_background);



        //create settings
        Node settings = Settings.get().createSettings();
        settings.toFront();
        settinglayer.setRight(settings);



        //on click insert nodes of polygon
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler());



        //add points to panel layer
        foreground.getChildren().add(this.pointscene);
        this.pointscene.toBack();
        foreground.getChildren().add(this.edgescene);
        this.edgescene.toBack();


        //add all layers to the scene
        root.getChildren().addAll(background, foreground, settinglayer);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}