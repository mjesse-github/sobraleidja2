package com.example.terminalitinder;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application extends javafx.application.Application {

    //määrame tüübid
    private final Andmebaas andmed = new Andmebaas();
    private final TextField nimiField = new TextField();
    private final TextField vanusField = new TextField();
    private final ComboBox<String> kokkamineKoristamineBox = new ComboBox<>();
    private final ComboBox<String> muusikaBox = new ComboBox<>();
    private final ComboBox<String> müslisuppBox = new ComboBox<>();
    private final ComboBox<Integer> raudVõiSulgBox = new ComboBox<>();
    private final ComboBox<String> jalutuskäikBox = new ComboBox<>();
    private final ComboBox<String> pitsaBox = new ComboBox<>();
    private final TextField lemmiknumberField = new TextField();
    private final Label sõbradLabel = new Label();
    private final Label soovitusLabel = new Label();
    private Label errorLabel = new Label();


    @Override
    public void start(Stage primaryStage) throws Exception {
        failistLugemine("src/andmebaas.txt", andmed);

        //graafika
        //loome gridi
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        //loome vastavad sisestuskassid

        gridPane.add(new Label("Nimi:"), 0, 0);
        gridPane.add(nimiField, 1, 0);
        gridPane.add(new Label("Vanus:"), 0, 1);
        gridPane.add(vanusField, 1, 1);
        gridPane.add(new Label("Kas sulle meeldib kokata ja koristada?"), 0, 2);
        //valikud!!
        kokkamineKoristamineBox.getItems().addAll("jah", "ei");
        gridPane.add(kokkamineKoristamineBox, 1, 2);
        gridPane.add(new Label("Mis muusikat sa kuulad?"), 0, 3);
        muusikaBox.getItems().addAll("koit toome", "liis lemsalu", "5 miiiinust", "genialistid", "ruja");
        gridPane.add(muusikaBox, 1, 3);
        gridPane.add(new Label("Kas müsli on supp?"), 0, 4);
        müslisuppBox.getItems().addAll("jah", "ei");
        gridPane.add(müslisuppBox, 1, 4);
        gridPane.add(new Label("Kumb on raskem, kas kilo rauda või kilo sulgi?"), 0, 5);
        raudVõiSulgBox.getItems().addAll(1, 2, 3, 4);
        gridPane.add(raudVõiSulgBox, 1, 5);
        gridPane.add(new Label("Kas nautled pikki jalutuskäike rannas?"), 0, 6);
        jalutuskäikBox.getItems().addAll("jah", "ei");
        gridPane.add(jalutuskäikBox, 1, 6);
        gridPane.add(new Label("Kumb on õige? pitsa ananassi peal või ananass pitsapeal?"), 0, 7);
        pitsaBox.getItems().addAll("pitsa ananassi peal", "ananass pitsapeal");
        gridPane.add(pitsaBox, 1, 7);
        gridPane.add(new Label("Lemmiknumber:"), 0, 8);
        gridPane.add(lemmiknumberField, 1, 8);
        //nupp mis otsib sarnaseid
        Button otsiButton = new Button("Otsi sarnaseid");
        otsiButton.setOnAction(this::handleOtsiButtonClick);


        HBox nupudHBox = new HBox(10, otsiButton);
        VBox vBox = new VBox(10, gridPane, nupudHBox, errorLabel, sõbradLabel, soovitusLabel);
        Scene scene = new Scene(vBox, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static List<Isik> leiaMatchid(Isik otsivIsik, int lubatudVead, Andmebaas andmed) throws IOException {
        List<Isik> matchid = new ArrayList<>();
        for (Isik isik : andmed.getAndmed()) {
            int counter = 0;

            if (!isik.getMeeldibKokataJaKoristada().contains(otsivIsik.getMeeldibKokataJaKoristada())) {
                counter += 1;
            }
            if (!isik.getMuusikamaitse().contains(otsivIsik.getMuusikamaitse())) {
                counter += 1;
            }
            if (!isik.getKasMüsliOnSupp().contains(otsivIsik.getKasMüsliOnSupp())) {
                counter += 1;
            }
            if (!isik.getMeeldivadPikadJalutuskäigudRannas().contains(otsivIsik.getMeeldivadPikadJalutuskäigudRannas())) {
                counter += 1;
            }
            if (!isik.getLemmiknumber().contains(otsivIsik.getLemmiknumber())) {
                counter += 1;
            }
            if (!isik.getKasAnanassPitsal().contains(otsivIsik.getKasAnanassPitsal())) {
                counter += 1;
            }
            if (isik.getRaudVõiSulg() != otsivIsik.getRaudVõiSulg()) {
                counter += 1;
            }
            if (counter <= lubatudVead) {
                matchid.add(isik);
            }
        }
        return matchid;
    }
    //loeb olemasolevast failist sisse andmed millega kasutajat
    public static void failistLugemine(String failinimi, Andmebaas andmed) throws IOException {
        File fail = new File(failinimi);

        try (Scanner scanner = new Scanner(fail, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] osad = rida.split(";");
                andmed.lisaIsik(new Isik(osad[0], Integer.parseInt(osad[1]), osad[2], osad[3], osad[4],
                        Integer.parseInt(osad[5]), osad[6], osad[7], osad[8]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //kirjutab uue info faili
    public static void failiKirjutamine(String sõne, String failinimi) throws IOException {
        Files.write(Path.of(failinimi), (sõne + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    //erind
    private int parseVanus(String vanusText) throws VanuseErind {
        try {
            return Integer.parseInt(vanusText);
        } catch (NumberFormatException e) {
            throw new VanuseErind("Vanus must be a numeric value");
        }
    }

    private void handleOtsiButtonClick(ActionEvent event) {
        String validationError = validateInputs();
        if (validationError != null) {
            errorLabel.setText(validationError);
            errorLabel.setTextFill(Color.RED);
            return;
        }

        try {
            int vanus = parseVanus(vanusField.getText());

            Isik uuritav = new Isik(nimiField.getText(), Integer.parseInt(vanusField.getText()),
                    kokkamineKoristamineBox.getValue(), muusikaBox.getValue(), müslisuppBox.getValue(),
                    raudVõiSulgBox.getValue(), jalutuskäikBox.getValue(), pitsaBox.getValue(),
                    lemmiknumberField.getText());

            List<Isik> sõbrad = new ArrayList<>();
            int erinevused = 0;
            while (sõbrad.size() == 0) {
                try {
                    sõbrad = leiaMatchid(uuritav, erinevused, andmed);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (sõbrad.size() != 0) {
                    break;
                } else {
                    erinevused++;
                }
            }
            StringBuilder sõbradStringBuilder = new StringBuilder();
            for (Isik sõber : sõbrad) {
                sõbradStringBuilder.append(sõber.toString()).append("\n");
            }
            sõbradLabel.setText("Meie andmebaasis sulle sarnased inimesed: " + sõbradStringBuilder.toString());

            int soovitus = (int) (Math.random() * 40);
            soovitusLabel.setText("Soovitame sul ruletis panustada kogu oma raha numbrile " + soovitus);

        } catch (VanuseErind e) { //kui vanus ei ole number
            errorLabel.setText(e.getMessage());
            errorLabel.setTextFill(Color.RED);
        }
    }

    //juhuks kui kastid on tühjaks jäetud
    private String validateInputs() {
        if (nimiField.getText().isEmpty()) {
            return "Palun sisesta oma nimi.";
        }
        if (vanusField.getText().isEmpty()) {
            return "Palun sisesta oma vanus";
        }
        if (kokkamineKoristamineBox.getValue() == null) {
            return "Palun valige kas teile meeldib kokata ja koristada.";
        }
        if (muusikaBox.getValue() == null) {
            return "Palun vali oma lemmikmuusik.";
        }
        if (müslisuppBox.getValue() == null) {
            return "Palun vali kas müsli on supp või ei.";
        }
        if (raudVõiSulgBox.getValue() == null) {
            return "Palun vasta raua ja sulgede küsimusele.";
        }
        if (jalutuskäikBox.getValue() == null) {
            return "Palun vali oma eelistus rannajalutuskäikude osas";
        }
        if (pitsaBox.getValue() == null) {
            return "Palun vali oma pitsaeelistus.";
        }
        if (lemmiknumberField.getText().isEmpty()) {
            return "Palun sisesta oma lemmiknumber.";
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }

}