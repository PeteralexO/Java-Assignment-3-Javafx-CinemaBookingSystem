package com.exemple.main;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.scene.layout.GridPane;

/**
 * <h1>Biosystem</h1>
 * Detta är ett Biosystem som är gjort i JavaFX.
 * Den har två olika scener än där du gör beställning och en som vissar resultatet av beställningen.
 * @author  Alexander Olsson
 *
 */


public class Main extends Application {

    Label response, response2, filmText, biljett, response3, welcome;
    Button button;
    Button button2;
    TextField text;
    Scene scene1;
    Scene scene2;
    Boolean filmer = false;

    /**
     * Startar JavaX
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Själva stagen och scenen som inhåller alla funktioner i programmet.
     * @param myStage
     * @throws Exception
     */
    public void start(Stage myStage) throws Exception {
        filmer = false;
        myStage.setTitle("Biograf");


        // Buttons

        button = new Button("Beställ");
        button.setId("button1");
        button.setOnAction((ae) -> {
                    if (filmer == true) {
                        myStage.setScene(scene2);
                        response2.setText("Du har beställt " + text.getText() + " biljetter till filmen " +
                                response.getText());
                    } else if (filmer == false) {
                        response3.setText("Måste välja film");
                    }
                }
        );

        button2 = new Button("Tillbaka");
        button2.setId("button1");
        button2.setOnAction((ae) ->
                myStage.setScene(scene1)
        );


        //Labals en Texfilds

        text = new TextField();
        text.setPromptText("2");

        response = new Label("");
        response.setId("label2");

        welcome = new Label("Välkommen till\n Olssons bio! ");
        welcome.setId("label5");

        response2 = new Label();
        response2.setId("label3");

        response3 = new Label("");
        response3.setId("label4");

        filmText = new Label("Film val:");
        filmText.setId("label1");

        biljett = new Label("Antal biljetter:");
        biljett.setId("label1");

        ///ArrayLIst
        ObservableList<String> computerTypes =
                FXCollections.observableArrayList("Walle", "ET", "Godzilla",
                        "Avengers", "Hot fuzz", "Fight Club");

        ListView<String> lvComputers = new ListView<String>(computerTypes);
        lvComputers.setPrefSize(150, 150);
        MultipleSelectionModel<String> lvSelModel =
                lvComputers.getSelectionModel();
        lvSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> changed,
                                        String oldVal, String newVal) {
                        response.setText(newVal);
                        filmer = true;
                    }
                });

        // Second Scene
        FlowPane rootNode2 = new FlowPane(10, 10);
        rootNode2.setAlignment(Pos.CENTER);
        rootNode2.getChildren().addAll(response2, button2);
        scene2 = new Scene(rootNode2, 500, 400);
        scene2.getStylesheets().add("stylesheet.css");


        //Main Scene
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(20);
        GridPane.setConstraints(welcome, 0, 0);
        GridPane.setConstraints(lvComputers, 0, 1);
        GridPane.setConstraints(filmText, 0, 2);
        GridPane.setConstraints(response, 1, 2);
        GridPane.setConstraints(biljett, 0, 3);
        GridPane.setConstraints(text, 1, 3);
        GridPane.setConstraints(button, 0, 4);
        GridPane.setConstraints(response3, 1, 4);

        grid.getChildren().addAll(welcome, lvComputers, filmText, response, biljett, text, button, response3);

        scene1 = new Scene(grid, 500, 400);
        scene1.getStylesheets().add("Stylesheet.css");
        grid.setAlignment(Pos.CENTER);
        myStage.setScene(scene1);


        myStage.show();
    }
}