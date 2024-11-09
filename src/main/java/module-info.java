module ch.hftm.algorithmen {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens ch.hftm.algorithmen to javafx.fxml;
    exports ch.hftm.algorithmen;
}
