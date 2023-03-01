module com.agenda.agenda_v1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.agenda.agenda_v1 to javafx.fxml;
    exports com.agenda.agenda_v1;
}
