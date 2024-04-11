module JanielMarkJavier_COMP228Lab6 {
	requires javafx.controls;
	requires java.desktop;
	requires java.base;
	requires javafx.graphics;
	
	opens exercise1 to javafx.graphics, javafx.fxml;
}
