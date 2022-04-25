module rey.angel.ProyectoFinal_Concesionario {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires java.sql;
	requires javafx.graphics;
	requires transitive java.desktop;
	requires javafx.base;

    opens rey.angel.ProyectoFinal_Concesionario to javafx.fxml;
    exports rey.angel.ProyectoFinal_Concesionario;
}
