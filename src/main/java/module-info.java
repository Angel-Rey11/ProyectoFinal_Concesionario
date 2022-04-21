module rey.angel.ProyectoFinal_Concesionario {
    requires javafx.controls;
    requires javafx.fxml;

    opens rey.angel.ProyectoFinal_Concesionario to javafx.fxml;
    exports rey.angel.ProyectoFinal_Concesionario;
}
