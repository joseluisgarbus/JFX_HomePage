package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

	/**
	 * 
	 * Creación de las variables de todos los elementos que aparecen en la interfaz
	 */
	
	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;
	
	@FXML
	private ImageView drawerImage;
	
	@FXML
	private Pane opacityPane;
	
	@FXML
	private Pane drawerPane;
//	@FXML
//	private URL location;
//	
//	@FXML
//	private ResourceBundle resources;

	public void initialize() {

		/**
		 * 
		 * carrusel de imagenes de fondo de la interfaz
		 */
		
		pane1.setStyle("-fx-background-image: url('application/11.jpg')");
		pane2.setStyle("-fx-background-image: url('application/12.jpeg')");
		pane3.setStyle("-fx-background-image: url('application/13.jpeg')");
		pane4.setStyle("-fx-background-image: url('application/14.jpg')");

		backgroundAnimation();
		
		/**
		 * 
		 * El carrusel irá cambiando las imagenes de fondo cada 0.5seg
		 */
		
		TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),drawerPane);
        translateTransition.setByX(-200);
        translateTransition.play();

		opacityPane.setVisible(false);
		
		drawerImage.setOnMouseClicked(event -> {

            opacityPane.setVisible(true);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),opacityPane);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.3);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),drawerPane);
            translateTransition1.setByX(200);
            translateTransition1.play();
        });

        opacityPane.setOnMouseClicked(event -> {

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),opacityPane);
            fadeTransition1.setFromValue(0.3);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                opacityPane.setVisible(false);
            });

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),drawerPane);
            translateTransition1.setByX(-200);
            translateTransition1.play();
        });

    }
		
	
	

//	public void cambiarHomePage() {
//		try {
//			Stage primaryStage = new Stage();
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista.fxml"));
//			// BorderPane root = new BorderPane();
//			AnchorPane root = (AnchorPane) loader.load();
//			Scene scene = new Scene(root,700,700);
//			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//	}

	
	/**
	 * 
	 * Transiciones del fondo, mostrando cada imagen dentro de un pane diferente
	 */
	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {

			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition0.setFromValue(0);
					fadeTransition0.setToValue(1);
					fadeTransition0.play();

					fadeTransition0.setOnFinished(event3 -> {

						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);

						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {

							FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3), pane4);

							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {

								backgroundAnimation();
							});

						});

					});

				});
			});

		});

	}
}