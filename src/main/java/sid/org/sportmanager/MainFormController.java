package sid.org.sportmanager;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sid.org.sportmanager.DBConnexion.DBHandler;
import sid.org.sportmanager.entities.Produit;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    @FXML
    private Button abonnesBtn;

    @FXML
    private Button aboutBtn;

    @FXML
    private TextField fp_produitId;

    @FXML
    private TextField fp_produitName;

    @FXML
    private TextField fp_produitPrice;


    @FXML
    private TextField fp_produitStock;

    @FXML
    private ComboBox<?> fp_produitType;
    @FXML
    private ComboBox<?> fp_produitStatus;

    @FXML
    private ImageView fp_produit_imageView;

    @FXML
    private Button homeBtn;

    @FXML
    private TableColumn<?, ?> product_col_status;

    @FXML
    private Button produitBtn;

    @FXML
    private Button produit_ajouterBtn;

    @FXML
    private Button produit_effacerBtn;

    @FXML
    private Button produit_importBtn;

    @FXML
    private Button produit_modifierBtn;

    @FXML
    private Button produit_supprimerBtn;

    @FXML
    private TableColumn<?, ?> produt__colprice;

    @FXML
    private TableColumn<?, ?> produt_col_date;

    @FXML
    private TableColumn<?, ?> produt_col_id;

    @FXML
    private TableColumn<?, ?> produt_col_name;

    @FXML
    private TableColumn<?, ?> produt_col_stock;

    @FXML
    private TableColumn<?, ?> produt_col_type;

    @FXML
    private Button questionBtn;

    @FXML
    private Button quitterBtn;

    @FXML
    private Button secretereBtn;

    @FXML
    private Button statistiqueBtn;

    @FXML
    private Button venteBtn;
    @FXML
    private Label currentUser;

    private Alert alert;

    private Connection connection;
    private PreparedStatement preparedStatement;
    Statement statement;
    private ResultSet resultSet;

    public  ObservableList<Produit> produitObservableList(){
        ObservableList<Produit> produitsData=FXCollections.observableArrayList();
        String sql="SELECT * FROM produit";
        connection = DBHandler.connectDB();
        try {
            preparedStatement= connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            Produit produit;
            if (resultSet.next()){
                produit=new Produit(null,
                        resultSet.getString("produit_id"),
                        resultSet.getString("produit_name"),
                        resultSet.getString("produit_type"),
                        resultSet.getInt("produit_stock"),
                        resultSet.getFloat("produit_price"),
                        resultSet.getString("prduit_status"),
                        resultSet.getDate("produit_date"),
                        resultSet.getString("produit_image")
                        );
                produitsData.add(produit);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  produitsData;
    }

    private String[] types={"Alimentations","Materiels"};

    public void produitTypeList(){
        ArrayList<String> typeL = new ArrayList<>();
        for (String t: types){
            typeL.add(t);
        }
        ObservableList listData = FXCollections.observableArrayList(typeL);
        fp_produitType.setItems(listData);
    }

    private  String[] status = {"Disponible","En rupture"};
    public void produitStatusList(){
        ArrayList<String> statusL = new ArrayList<>();
        for (String t: status){
            statusL.add(t);
        }
        ObservableList listData = FXCollections.observableArrayList(statusL);
        fp_produitStatus.setItems(listData);
    }


    public void logout(){
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Etes vous sure de vouloir quitter ?");
            Optional<ButtonType> optional = alert.showAndWait();
            if (optional.get().equals(ButtonType.OK)){
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Gestion du salle de sport et de bien etre");
                stage.setScene(scene);
                stage.show();
                quitterBtn.getScene().getWindow().hide();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void displayUser(){
        currentUser.setText(Data.username.toUpperCase());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUser();
        produitTypeList();
        produitStatusList();

    }
}
