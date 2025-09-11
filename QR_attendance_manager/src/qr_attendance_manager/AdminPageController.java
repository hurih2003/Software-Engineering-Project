package qr_attendance_manager;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class AdminPageController {

    @FXML
    private void openManageAccounts(ActionEvent event) {
        // TODO: افتحي واجهة Manage Accounts
        System.out.println("Manage Accounts button clicked!");
    }

    @FXML
    private void openManageQr(ActionEvent event) {
        // TODO: افتحي واجهة Manage QR
        System.out.println("Manage QR button clicked!");
    }

    @FXML
    private void openReports(ActionEvent event) {
        // TODO: افتحي واجهة View Reports
        System.out.println("View Reports button clicked!");
    }

    @FXML
    private void openWarnings(ActionEvent event) {
        // TODO: افتحي واجهة Warnings
        System.out.println("Warnings button clicked!");
    }
}
