module rey.angel.ProyectoFinal_Concesionario {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires java.sql;
	requires javafx.graphics;
	requires transitive java.desktop;
	requires javafx.base;
	requires com.gluonhq.charm.glisten;

    opens rey.angel.ProyectoFinal_Concesionario to javafx.fxml;
    opens rey.angel.ProyectoFinal_Concesionario.utils to java.xml.bind;
    exports rey.angel.ProyectoFinal_Concesionario;
}
