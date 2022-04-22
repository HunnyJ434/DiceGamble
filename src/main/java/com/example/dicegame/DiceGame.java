package com.example.dicegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Random;


import java.io.IOException;

public class DiceGame extends Application {
    private BorderPane pane = new BorderPane();
    private TextField BetTextField = new TextField();
    private TextField ProfitTextField = new TextField();
    private TextField LostTextField = new TextField();
    private ImageView imageView1 = new ImageView();
    private ImageView imageView2 = new ImageView();
    private Text t = new Text("Get total of 7 or 11 to win three times the bet!");
    private Integer profit = 0;
    private Integer lost = 0;
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button EnterBet = new Button("Enter Bet.");
        EnterBet.setOnAction(new EnterBetHandler());
        BetTextField.setOnAction(new EnterBetHandler());
        hBox.getChildren().addAll(BetTextField, EnterBet);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox, Pos.CENTER);
        Image image = new Image("http://clipart-library.com/images/qcBX8Xp8i.gif");
        imageView1.setImage(image);
        imageView1.setFitHeight(200);
        imageView1.setFitWidth(200);
        borderPane.setLeft(imageView1);
        imageView2.setImage(image);
        imageView2.setFitHeight(200);
        imageView2.setFitWidth(200);
        borderPane.setRight(imageView2);
        t.setFont(new Font(20));
        borderPane.setCenter(t);
        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);
        ProfitTextField.setPrefColumnCount(6);
        LostTextField.setPrefColumnCount(6);
        Label label1 = new Label("Profit");
        label1.setTextFill(Color.GREEN);
        Label label2 = new Label("Lost");
        label2.setTextFill(Color.RED);
        hBox1.getChildren().addAll(label1,ProfitTextField,label2,LostTextField);
        pane.setLeft(new Label("The Dice Game"));
        pane.setRight(hBox1);
        pane.setPadding(new Insets(10));
        borderPane.setTop(pane);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    class EnterBetHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(Integer.valueOf(BetTextField.getText()) < 1){
                String str = new String("Enter Appropriate Amount");
                t.setText(str);
            }
            else {
                Random rand = new Random();
                Image image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/1.png");
                Image image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/1.png");
                int i = rand.nextInt(6) + 1;
                int j = rand.nextInt(6) + 1;
                int num = Integer.valueOf(BetTextField.getText());
                switch (i) {
                    case 1:
                        image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/1.png");
                        break;
                    case 2:
                        image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/2.png");
                        break;
                    case 3:
                        image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/3.png");
                        break;
                    case 4:
                        image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/4.png");
                        break;
                    case 5:
                        image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/5.png");
                        break;
                    case 6:
                        image1 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/6.png");
                        break;
                }
                switch (j) {
                    case 1:
                        image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/1.png");
                        break;
                    case 2:
                        image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/2.png");
                        break;
                    case 3:
                        image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/3.png");
                        break;
                    case 4:
                        image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/4.png");
                        break;
                    case 5:
                        image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/5.png");
                        break;
                    case 6:
                        image2 = new Image("https://raw.githubusercontent.com/HunnyJ434/DiceGamble/master/images/6.png");
                        break;
                }
                ;
                imageView1.setImage(image1);
                imageView2.setImage(image2);
                String str = "Your Numbers are " + i + " and " + j + "\n";
                if (i + j == 7 || i + j == 11) {
                    str += "YOU WON!! :) \n Re-Enter Bet to Play Again.";
                    String randStr = new String();
                    profit += 3 * num;
                    randStr = profit.toString() + "$";
                    ProfitTextField.setText(randStr);
                } else {
                    str += "You Lose :( \n Re-Enter Bet to Play Again.";
                    String randStr = new String();
                    lost += num;
                    randStr = lost.toString() + "$";
                    LostTextField.setText(randStr);
                }
                t.setText(str);
            }
        }
    }
    public static void main(String[] args) {
        launch();
    }
}

