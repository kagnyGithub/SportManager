module sid.org.sportmanager {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;

    opens sid.org.sportmanager to javafx.fxml;
    exports sid.org.sportmanager;
}