/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button coaches_btn;

    @FXML
    private Button members_btn;

    @FXML
    private Button logout;

    @FXML
    private Button payment_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_NM;

    @FXML
    private Label dashboard_NC;

    @FXML
    private Label dashboard_TI;

    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;

    @FXML
    private AnchorPane coaches_form;

    @FXML
    private TextField coaches_coachID;

    @FXML
    private TextField coaches_name;

    @FXML
    private TextArea coaches_address;

    @FXML
    private ComboBox<?> coaches_gender;

    @FXML
    private TextField coaches_phoneNum;

    @FXML
    private Button coaches_addBtn;

    @FXML
    private Button coaches_updateBtn;

    @FXML
    private Button coaches_resetBtn;

    @FXML
    private Button coaches_deleteBtn;

    @FXML
    private ComboBox<?> coaches_status;

    @FXML
    private TableView<coachData> coaches_tableView;

    @FXML
    private TableColumn<coachData, String> coaches_col_coachID;

    @FXML
    private TableColumn<coachData, String> coaches_col_name;

    @FXML
    private TableColumn<coachData, String> coaches_col_address;

    @FXML
    private TableColumn<coachData, String> coaches_col_gender;

    @FXML
    private TableColumn<coachData, String> coaches_col_phoneNum;

    @FXML
    private TableColumn<coachData, String> coaches_col_status;
    
    @FXML
    private Button dietplans_btn;
    
    @FXML
    private AnchorPane dietplans_form;

    @FXML
    private AnchorPane members_form;

    @FXML
    private TextField members_customerId;

    @FXML
    private TextField members_name;

    @FXML
    private TextArea members_caddress;

    @FXML
    private TextField members_phoneNum;

    @FXML
    private ComboBox<?> members_gender;

    @FXML
    private ComboBox<?> members_schedule;

    @FXML
    private DatePicker members_startDate;

    @FXML
    private DatePicker members_endDate;

    @FXML
    private ComboBox<?> members_status;
    
    @FXML
    private ComboBox<?> members_vip;

    @FXML
    private Button members_addBtn;
    
     @FXML
    private Button members_searchBtn;

    @FXML
    private Button members_clearBtn;

    @FXML
    private Button members_updateBtn;

    @FXML
    private Button members_deleteBtn;

    @FXML
    private TableView<memberData> members_tableView;
    
    @FXML
    private TableColumn<memberData, String> members_col_daysrem;

    @FXML
    private TableColumn<memberData, String> members_col_customerID;

    @FXML
    private TableColumn<memberData, String> members_col_name;

    @FXML
    private TableColumn<memberData, String> members_col_address;

    @FXML
    private TableColumn<memberData, String> members_col_phoneNum;

    @FXML
    private TableColumn<memberData, String> members_col_gender;

    @FXML
    private TableColumn<memberData, String> members_col_schedule;

    @FXML
    private TableColumn<memberData, String> members_col_startDate;

    @FXML
    private TableColumn<memberData, String> members_col_endDate;

    @FXML
    private TableColumn<memberData, String> members_col_status;
    
    @FXML
    private TableColumn<memberData, String> members_col_vip;

    @FXML
    private AnchorPane payment_Form;

    @FXML
    private TableView<memberData> payment_tableView;

    @FXML
    private TableColumn<memberData, String> payment_col_customerID;

    @FXML
    private TableColumn<memberData, String> payment_col_name;

    @FXML
    private TableColumn<memberData, String> payment_col_startDate;

    @FXML
    private TableColumn<memberData, String> payment_col_endDate;

    @FXML
    private TableColumn<memberData, String> payment_col_status;

    @FXML
    private ComboBox<?> payment_customerID;

    @FXML
    private ComboBox<?> payment_name;

    @FXML
    private Label payment_total;

    @FXML
    private TextField payment_amount;

    @FXML
    private Label payment_change;

    @FXML
    private Button payment_payBtn;
    
    @FXML
    private TableColumn<memberData, String> vip_col_customerID;

    @FXML
    private TableColumn<memberData, String> vip_col_height;

    @FXML
    private TableColumn<memberData, String> vip_col_name;

    @FXML
    private TableColumn<memberData, String> vip_col_weight;
    
    @FXML
    private TableColumn<?, ?> vip_col_dietplans;
    
    @FXML
    private TableColumn<?,?> vip_col_coach;

    @FXML
    private ComboBox<?> vip_customerID;

    @FXML
    private ComboBox<?> vip_name;
    
    @FXML
    private TableView<memberData> vip_tableView;

    @FXML
    private Label username;
    
    @FXML
    private Button vipmembers_SearchBtn;

    @FXML
    private Button vipmembers_addBtn;

    @FXML
    private Button vipmembers_btn;

    @FXML
    private Button vipmembers_clearBtn;

    @FXML
    private TextField vipmembers_customerId;

    @FXML
    private Button vipmembers_deleteBtn;

    @FXML
    private AnchorPane vipmembers_form;

    @FXML
    private TextField vipmembers_height;

    @FXML
    private TextField vipmembers_name;

    @FXML
    private Button vipmembers_updateBtn;
    
    @FXML
    private ComboBox<?> vipmembers_dietplans;
    
    
    @FXML
    private TextField vipmembers_weight;
    
   
    @FXML
    private TableColumn<?, ?> vipmembers_col_customerID;
    
    @FXML
    private TableColumn<?, ?> vipmembers_col_dietplans;

    @FXML
    private TableColumn<?, ?> vipmembers_col_height;

    @FXML
    private TableColumn<?, ?> vipmembers_col_name;

    @FXML
    private TableColumn<?, ?> vipmembers_col_weight;
   
    
    @FXML
    private Button vip_heightBtn;
    
     @FXML
    private ComboBox<?> vip_coach;




    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    
    
        
    
    public void emptyFields() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all blank fields");
        alert.showAndWait();
    }

    public void dashboardNM() {

        String sql = "SELECT COUNT(memberId) FROM member WHERE status = 'Paid'";

        connect = database.connectDb();

        int nm = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                nm = result.getInt("COUNT(memberId)");
            }

            dashboard_NM.setText(String.valueOf(nm));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTC() {

        String sql = "SELECT COUNT(coachId) FROM coach WHERE status = 'Active'";

        connect = database.connectDb();

        int tc = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tc = result.getInt("COUNT(coachId)");
            }
            dashboard_NC.setText(String.valueOf(tc));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTI() {

        String sql = "SELECT SUM(price) FROM member WHERE status = 'Paid'";

        connect = database.connectDb();

        double ti = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                ti = result.getDouble("SUM(price)");
            }

            dashboard_TI.setText("$" + String.valueOf(ti));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardChart() {

        dashboard_incomeChart.getData().clear();

        String sql = "SELECT startDate, SUM(price) FROM member WHERE status = 'Paid' GROUP BY startDate ORDER BY TIMESTAMP(startDate) ASC LIMIT 10";

        connect = database.connectDb();

        XYChart.Series chart = new XYChart.Series();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getDouble(2)));
            }

            dashboard_incomeChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void coachesAddBtn() {

        String sql = "INSERT INTO coach (coachId, name, address, gender, phoneNum, status) "
                + "VALUES(?,?,?,?,?,?)";

        connect = database.connectDb();

        try {

            Alert alert;

            if (coaches_coachID.getText().isEmpty() || coaches_name.getText().isEmpty()
                    || coaches_address.getText().isEmpty()
                    || coaches_gender.getSelectionModel().getSelectedItem() == null
                    || coaches_phoneNum.getText().isEmpty()
                    || coaches_status.getSelectionModel().getSelectedItem() == null) {
                emptyFields();
            } else {

                String checkData = "SELECT coachId FROM coach WHERE coachId = '"
                        + coaches_coachID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Coach ID: " + coaches_coachID.getText() + " was already taken!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, coaches_coachID.getText());
                    prepare.setString(2, coaches_name.getText());
                    prepare.setString(3, coaches_address.getText());
                    prepare.setString(4, (String) coaches_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, coaches_phoneNum.getText());
                    prepare.setString(6, (String) coaches_status.getSelectionModel().getSelectedItem());

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    
                    prepare.executeUpdate();
                    
                    coachesShowData();
                    
                    coachesClearBtn();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void coachesUpdateBtn() {

        String sql = "UPDATE coach SET name = '"
                + coaches_name.getText() + "', address = '"
                + coaches_address.getText() + "', gender = '"
                + coaches_gender.getSelectionModel().getSelectedItem() + "', phoneNum = '"
                + coaches_phoneNum.getText() + "', status = '"
                + coaches_status.getSelectionModel().getSelectedItem() + "' WHERE coachId = '"
                + coaches_coachID.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (coaches_coachID.getText().isEmpty() || coaches_name.getText().isEmpty()
                    || coaches_address.getText().isEmpty()
                    || coaches_gender.getSelectionModel().getSelectedItem() == null
                    || coaches_phoneNum.getText().isEmpty()
                    || coaches_status.getSelectionModel().getSelectedItem() == null) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Coach ID: " + coaches_coachID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);

                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    coachesShowData();
                    
                    coachesClearBtn();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Update!");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void coachesDeleteBtn() {
        String sql = "DELETE FROM coach WHERE coachId = '"
                + coaches_coachID.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (coaches_coachID.getText().isEmpty() || coaches_name.getText().isEmpty()
                    || coaches_address.getText().isEmpty()
                    || coaches_gender.getSelectionModel().getSelectedItem() == null
                    || coaches_phoneNum.getText().isEmpty()
                    || coaches_status.getSelectionModel().getSelectedItem() == null) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Coach ID: " + coaches_coachID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);

                    
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    coachesShowData();
                    
                    coachesClearBtn();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Update!");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void coachesClearBtn() {
        coaches_coachID.setText("");
        coaches_name.setText("");
        coaches_address.setText("");
        coaches_gender.getSelectionModel().clearSelection();
        coaches_phoneNum.setText("");
        coaches_status.getSelectionModel().clearSelection();
    }

    public ObservableList<coachData> coachesDataList() {

        ObservableList<coachData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM coach";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            coachData cd;

            while (result.next()) {
                cd = new coachData(result.getString("coachId"),
                        result.getString("name"), result.getString("address"),
                        result.getString("gender"), result.getInt("phoneNum"),
                        result.getString("status"));

                listData.add(cd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<coachData> coachesListData;

    public void coachesShowData() {

        coachesListData = coachesDataList();

        coaches_col_coachID.setCellValueFactory(new PropertyValueFactory<>("coachId"));
        coaches_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        coaches_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        coaches_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        coaches_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        coaches_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        coaches_tableView.setItems(coachesListData);

    }

    public void coachesSelect() {
        coachData cd = coaches_tableView.getSelectionModel().getSelectedItem();
        int num = coaches_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        coaches_coachID.setText(cd.getCoachId());
        coaches_name.setText(cd.getName());
        coaches_address.setText(cd.getAddress());
        coaches_phoneNum.setText(String.valueOf(cd.getPhoneNum()));

    }

    private String gender[] = {"Male", "Female", "Others"};

    public void coachGenderList() {
        List<String> genderList = new ArrayList<>();

        for (String data : gender) {
            genderList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(genderList);
        coaches_gender.setItems(listData);
    }

    private String coachStatus[] = {"Active", "Inactive"};

    public void coachStatusList() {
        List<String> coachList = new ArrayList<>();

        for (String data : coachStatus) {
            coachList.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(coachList);
        coaches_status.setItems(listData);
    }

    private int totalDay;
    private double price;

    public void membersAddBtn() {

        String sql = "INSERT INTO member (memberId, name, address, phoneNum, vip, schedule, startDate, endDate, price, status) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (members_customerId.getText().isEmpty() || members_name.getText().isEmpty()
                    || members_phoneNum.getText().isEmpty() || members_caddress.getText().isEmpty()
                    || members_vip.getSelectionModel().getSelectedItem() == null
                    || members_schedule.getSelectionModel().getSelectedItem() == null
                    || members_startDate.getValue() == null
                    || members_endDate.getValue() == null) {
                emptyFields();
            } else {

                String checkData = "SELECT memberId FROM member WHERE memberId = '"
                        + members_customerId.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Member ID: " + members_customerId.getText() + " was already taken!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, members_customerId.getText());
                    prepare.setString(2, members_name.getText());
                    prepare.setString(4, members_phoneNum.getText());
                    prepare.setString(3, members_caddress.getText());
                    prepare.setString(5, (String) members_vip.getSelectionModel().getSelectedItem());
                    prepare.setString(6, (String) members_schedule.getSelectionModel().getSelectedItem());
                    prepare.setString(7, String.valueOf(members_startDate.getValue()));
                    prepare.setString(8, String.valueOf(members_endDate.getValue()));

                    totalDay = (int) ChronoUnit.DAYS.between(members_startDate.getValue(), members_endDate.getValue());

                    price = (totalDay * 50);

                    prepare.setString(9, String.valueOf(price));
                    prepare.setString(10, (String) members_status.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Added!");
                    alert.showAndWait();

                    membersShowData();
                    membersClear();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void membersSearchBtn() {
    ObservableList<memberData> searchData = FXCollections.observableArrayList();
    String sql = "SELECT * FROM member WHERE memberId LIKE ? OR name LIKE ?";
    connect = database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, "%" + members_customerId.getText() + "%"); 
        prepare.setString(2, "%" + members_name.getText() + "%");
        result = prepare.executeQuery();

        while (result.next()) {
            
            memberData md = new memberData(
                    result.getString("memberId"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getInt("phoneNum"),
                    result.getString("vip"),
                    result.getString("schedule"),
                    result.getDate("startDate"),
                    result.getDate("endDate"),
                    result.getDouble("price"),
                    result.getString("status"),
                    result.getInt("weight"),
                    result.getInt("height")
            
            );
            searchData.add(md);
        }

        
        members_tableView.setItems(searchData);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void membersUpdate() {

        totalDay = (int) ChronoUnit.DAYS.between(members_startDate.getValue(), members_endDate.getValue());
        price = (totalDay * 50);

        String sql = "UPDATE member SET name = '"
                + members_name.getText() + "', address = '"
                + members_caddress.getText() + "', phoneNum = '"
                + members_phoneNum.getText() + "', vip = '"
                + members_vip.getSelectionModel().getSelectedItem() + "', schedule = '"
                + members_schedule.getSelectionModel().getSelectedItem() + "', startDate = '"
                + members_startDate.getValue() + "', endDate = '"
                + members_endDate.getValue() + "', price = '"
                + String.valueOf(price) + "', status = '"
                + members_status.getSelectionModel().getSelectedItem() + "' WHERE memberId = '"
                + members_customerId.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (members_customerId.getText().isEmpty() || members_name.getText().isEmpty()
                    || members_phoneNum.getText().isEmpty() || members_caddress.getText().isEmpty()
                    || members_vip.getSelectionModel().getSelectedItem() == null
                    || members_schedule.getSelectionModel().getSelectedItem() == null
                    || members_startDate.getValue() == null
                    || members_endDate.getValue() == null) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Member ID: " + members_customerId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Updated!");
                    alert.showAndWait();

                    membersShowData();
                    membersClear();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Update!!");
                    alert.showAndWait();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void membersDelete() {

        String sql = "DELETE FROM member WHERE memberId = '"
                + members_customerId.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (members_customerId.getText().isEmpty() || members_name.getText().isEmpty()
                    || members_phoneNum.getText().isEmpty() || members_caddress.getText().isEmpty()
                    || members_vip.getSelectionModel().getSelectedItem() == null
                    || members_schedule.getSelectionModel().getSelectedItem() == null
                    || members_startDate.getValue() == null
                    || members_endDate.getValue() == null) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Member ID: " + members_customerId.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Deleted!");
                    alert.showAndWait();

                    membersShowData();
                    membersClear();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Delete!!");
                    alert.showAndWait();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void membersClear() {
        members_customerId.setText("");
        members_name.setText("");
        members_caddress.setText("");
        members_phoneNum.setText("");
        members_vip.getSelectionModel().clearSelection();
        members_schedule.getSelectionModel().clearSelection();
        members_startDate.setValue(null);
        members_endDate.setValue(null);
        members_status.getSelectionModel().clearSelection();
    }

    private String memberVip[] = {"YES", "NO"};

    public void membersVip() {

        List<String> ms = new ArrayList<>();

        for (String data : memberVip) {
            ms.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(memberVip);
        members_vip.setItems(listData);

    }

    private String[] scheduleList = {"9AM - 11AM", "11AM - 1PM", "1PM - 3PM", "3PM - 5PM", "5PM - 7PM"};

    public void membersSchedule() {

        List<String> sl = new ArrayList<>();

        for (String data : scheduleList) {
            sl.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(sl);
        members_schedule.setItems(listData);

    }

    private String memberStatus[] = {"Paid", "Unpaid"};

    public void membersStatus() {

        List<String> ms = new ArrayList<>();

        for (String data : memberStatus) {
            ms.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(memberStatus);
        members_status.setItems(listData);

    }

    public ObservableList<memberData> membersDataList() {

        ObservableList<memberData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM member";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            memberData md;

            while (result.next()) {
                md = new memberData(
                        result.getString("memberId"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getInt("phoneNum"),
                        result.getString("vip"),
                        result.getString("schedule"),
                        result.getDate("startDate"),
                        result.getDate("endDate"),
                        result.getDouble("price"),
                        result.getString("status"),
                        result.getInt("weight"),
                        result.getInt("height")
                
                );

                listData.add(md);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<memberData> membersListData;

    public void membersShowData() {
    membersListData = membersDataList();

    // Clear previous data from the table
    members_tableView.getItems().clear();

    // Set cell value factories
    members_col_customerID.setCellValueFactory(new PropertyValueFactory<>("memberId"));
    members_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    members_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
    members_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
    members_col_vip.setCellValueFactory(new PropertyValueFactory<>("vip"));
    members_col_schedule.setCellValueFactory(new PropertyValueFactory<>("schedule"));
    members_col_startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
    members_col_endDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    members_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
    members_col_daysrem.setCellValueFactory(cellData -> {
        memberData member = cellData.getValue();
        long daysRemaining = calculateDaysRemaining(member.getEndDate());
        return new SimpleStringProperty(String.valueOf(daysRemaining));
    });

    
    members_tableView.setItems(membersListData);

    
    members_tableView.setRowFactory(tv -> {
        return new TableRow<memberData>() {
            @Override
            protected void updateItem(memberData item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || item.getEndDate() == null) {
                    setStyle(""); // No style if the item is null or has no end date
                    return;
                }
                long daysRemaining = calculateDaysRemaining(item.getEndDate());
                if (daysRemaining <= 7) { // Highlight if membership is expiring in 7 days or less
                    setStyle("-fx-background-color: red;");
                } else {
                    setStyle(""); // No style otherwise
                }
            }
        };
    });
}

private long calculateDaysRemaining(Date endDate) {
    LocalDate currentDate = LocalDate.now();
    LocalDate endLocalDate = endDate.toLocalDate();
    long daysRemaining = ChronoUnit.DAYS.between(currentDate, endLocalDate);
    return daysRemaining;
}

    public void membersSelect() {

        memberData md = members_tableView.getSelectionModel().getSelectedItem();
        int num = members_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        members_customerId.setText(md.getMemberId());
        members_name.setText(md.getName());
        members_caddress.setText(md.getAddress());
        members_phoneNum.setText(String.valueOf(md.getPhoneNum()));
        members_startDate.setValue(LocalDate.parse(String.valueOf(md.getStartDate())));
        members_endDate.setValue(LocalDate.parse(String.valueOf(md.getEndDate())));

    }

    public void paymentMemberId() {

        String sql = "SELECT memberId FROM member WHERE status = 'Unpaid'";

        connect = database.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("memberId"));
            }
            payment_customerID.setItems(listData);

            paymentName();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paymentName() {

        String sql = "SELECT name FROM member WHERE memberId = '"
                + payment_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                listData.add(result.getString("name"));
            }
            payment_name.setItems(listData);

            paymentDisplayTotal();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private double totalP;

    public void displayTotal() {

        String sql = "SELECT price FROM member WHERE name = '"
                + payment_name.getSelectionModel().getSelectedItem() + "' and memberId = '"
                + payment_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                totalP = result.getDouble("price");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paymentDisplayTotal() {
        displayTotal();
        payment_total.setText("$" + String.valueOf(totalP));
    }

    private double amount;
    private double change;

    public void paymentAmount() {
        displayTotal();

        Alert alert;

        if (payment_amount.getText().isEmpty() || totalP == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid :3");
            alert.showAndWait();

            payment_amount.setText("");
        } else {
            amount = Double.parseDouble(payment_amount.getText());

            if (amount >= totalP) {
                change = (amount - totalP);
                payment_change.setText("$" + String.valueOf(change));
            } else {
                payment_amount.setText("");
                change = 0;
                amount = 0;
            }
        }
    }

    public void paymentPayBtn() {

        String sql = "UPDATE member SET status = 'Paid' WHERE memberId = '"
                + payment_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (totalP == 0 || change == 0 || payment_amount.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something Wrong :3");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();

                    paymentShowData();
                    paymentClear();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paymentClear() {
        payment_customerID.getSelectionModel().clearSelection();
        payment_name.getSelectionModel().clearSelection();
        payment_total.setText("$0.0");
        payment_amount.setText("");
        payment_change.setText("$0.0");

        amount = 0;
        change = 0;
        totalP = 0;
    }

    public ObservableList<memberData> paymentDataList() {

        ObservableList<memberData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM member";

        connect = database.connectDb();

        try {
            memberData md;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                md = new memberData(
                        result.getString("memberId"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getInt("phoneNum"),
                        result.getString("vip"),
                        result.getString("schedule"),
                        result.getDate("startDate"),
                        result.getDate("endDate"),
                        result.getDouble("price"),
                        result.getString("status"),
                        result.getInt("weight"),
                    result.getInt("height")
                
                );

                listData.add(md);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<memberData> paymentListData;

    public void paymentShowData() {

        paymentListData = paymentDataList();

        payment_col_customerID.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        payment_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        payment_col_startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        payment_col_endDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        payment_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        payment_tableView.setItems(paymentListData);

    }
    public void vipMemberId() {

        String sql = "SELECT memberId FROM member WHERE vip = 'YES'";

        connect = database.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("memberId"));
            }
            vip_customerID.setItems(listData);

            vipName();
            coachName();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void vipName() {

        String sql = "SELECT name FROM member WHERE memberId = '"
                + vip_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                listData.add(result.getString("name"));
            }
            vip_name.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void coachName() {

        String sql = "SELECT name FROM coach ";

        connect = database.connectDb();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("name"));
            }
            vip_coach.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void vipUpdate() {

        String sql = "UPDATE member SET weight = '"
                + vipmembers_weight.getText() + "', height = '"
                + vipmembers_height.getText() + "' WHERE memberId = '"
                + vip_customerID.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (members_customerId.getText().isEmpty() || vipmembers_weight.getText().isEmpty()
                    ) {
                emptyFields();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Member ID: " + vip_customerID.getSelectionModel().getSelectedItem() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfuly Updated!");
                    alert.showAndWait();

                    vipShowData();
                    vipMembersClear();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled Update!!");
                    alert.showAndWait();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    public void vipMembersClear() {
    vipmembers_weight.setText("");
    vipmembers_height.setText("");
}

public ObservableList<memberData> vipDataList() {
    ObservableList<memberData> listData = FXCollections.observableArrayList();

    String sql = "SELECT * FROM member WHERE vip = 'YES'";

    connect = database.connectDb();

    try {
        memberData md;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            int weight = result.getInt("weight");
            int height = result.getInt("height");

            String dietPlanType;
            if (weight < 50 && height < 160) {
                dietPlanType = "Type 1";
            } else if (weight >= 50 && weight <= 70 && height >= 160 && height <= 180) {
                dietPlanType = "Type 2";
            } else {
                dietPlanType = "Type 3";
            }

            md = new memberData(
                    result.getString("memberId"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getInt("phoneNum"),
                    result.getString("vip"),
                    result.getString("schedule"),
                    result.getDate("startDate"),
                    result.getDate("endDate"),
                    result.getDouble("price"),
                    result.getString("status"),
                    weight,
                    height
            );
            md.setDietPlanType(dietPlanType);

            listData.add(md);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return listData;
}

private ObservableList<memberData> vipListData;

    public void vipShowData() {

        vipListData = vipDataList();

        vip_col_customerID.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        vip_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        vip_col_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        vip_col_height.setCellValueFactory(new PropertyValueFactory<>("height"));
        vip_col_dietplans.setCellValueFactory(new PropertyValueFactory<>("dietPlanType"));
        

        vip_tableView.setItems(vipListData);

    }
    
    


    public void displayUsername() {

        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);

        username.setText(user);

    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {

            dashboard_form.setVisible(true);
            coaches_form.setVisible(false);
            members_form.setVisible(false);
            payment_Form.setVisible(false);
            vipmembers_form.setVisible(false);
            dietplans_form.setVisible(false);

            dashboardNM();
            dashboardTC();
            dashboardTI();
            dashboardChart();

        } else if (event.getSource() == coaches_btn) {

            dashboard_form.setVisible(false);
            coaches_form.setVisible(true);
            members_form.setVisible(false);
            payment_Form.setVisible(false);
            vipmembers_form.setVisible(false);
            dietplans_form.setVisible(false);

            
            coachGenderList();
            coachStatusList();
            coachesShowData();

        } else if (event.getSource() == members_btn) {

            dashboard_form.setVisible(false);
            coaches_form.setVisible(false);
            members_form.setVisible(true);
            payment_Form.setVisible(false);
            vipmembers_form.setVisible(false);
            dietplans_form.setVisible(false);

            membersShowData();
            membersVip();
            membersSchedule();
            membersStatus();

        } else if (event.getSource() == payment_btn) {

            dashboard_form.setVisible(false);
            coaches_form.setVisible(false);
            members_form.setVisible(false);
            payment_Form.setVisible(true);
            vipmembers_form.setVisible(false);
            dietplans_form.setVisible(false);

            paymentShowData();
            paymentMemberId();
            paymentName();

        }
        
        else if (event.getSource() == vipmembers_btn) {

            dashboard_form.setVisible(false);
            coaches_form.setVisible(false);
            members_form.setVisible(false);
            payment_Form.setVisible(false);
            vipmembers_form.setVisible(true);
            dietplans_form.setVisible(false);

            vipShowData();
            vipMemberId();
            vipName();

        }
        else if (event.getSource() == dietplans_btn) {

            dashboard_form.setVisible(false);
            coaches_form.setVisible(false);
            members_form.setVisible(false);
            payment_Form.setVisible(false);
            vipmembers_form.setVisible(false);
            dietplans_form.setVisible(true);

            

        }

    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                
                logout.getScene().getWindow().hide();

                
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void minimize() {

        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);

    }

    public void close() {

        javafx.application.Platform.exit();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();

        dashboardNM();
        dashboardTC();
        dashboardTI();
        dashboardChart();

        coachGenderList();
        coachStatusList();
        coachesShowData();

        membersShowData();
        membersVip();
        membersSchedule();
        membersStatus();
        
        vipShowData();
        vipMemberId();
        vipName();

        paymentMemberId();
        paymentName();
        paymentShowData();

    }

}
