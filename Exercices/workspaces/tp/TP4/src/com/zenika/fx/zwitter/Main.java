package com.zenika.fx.zwitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private MainController controller;

	@Override
	public void start(final Stage primaryStage) {
		final FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("MainScreen.fxml"));
		try {
			final BorderPane root = fxmlLoader.load();
			controller = fxmlLoader.getController();

			final Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Zwitter");
			primaryStage.show();

			primaryStage.setOnCloseRequest(event -> {
				controller.stop();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		launch(args);
	}

}
