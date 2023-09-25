package sid.org.sportmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sid.org.sportmanager.DBConnexion.DBHandler;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane fg_loginForm;

    @FXML
    private Button fg_retour_changeBtn;

    @FXML
    private Button fp_proceedBtn;

    @FXML
    private ComboBox<?> fp_question;

    @FXML
    private TextField fp_reponse;
    @FXML
    private TextField fp_username;

    @FXML
    private Button fp_retourBtn;

    @FXML
    private Button np_changePasswordBtn;

    @FXML
    private AnchorPane np_loginForm;

    @FXML
    private PasswordField np_passworConfirm;

    @FXML
    private PasswordField np_password;

    @FXML
    private Hyperlink si_forgot;

    @FXML
    private Button si_loginBtn;

    @FXML
    private AnchorPane si_loginForm;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    private  Alert alert;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String[] questionList = {"Quelle est un ton couleur prefere ?","Quelle est votre plat prefere ?"," Quelle est le nom de votre chien ?"};
    public void reqQuestionList(){
        List<String> listQ = new ArrayList<>();
        for (String q:questionList){
            listQ.add(q);
        }

        ObservableList listData = FXCollections.observableArrayList(listQ);
        fp_question.setItems(listData);
    }

    public  void switchForgotPassword(){
        fg_loginForm.setVisible(true);
        si_loginForm.setVisible(false);
        reqQuestionList();

    }

    public  void proceedBtn(){
        if (fp_username.getText().isEmpty() || fp_question.getSelectionModel().getSelectedItem()==null || fp_reponse.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Veillez remplir tous les champ svp  ");
            alert.showAndWait();
        } else {
            String selectData = "SELECT username, password FROM utilisateur WHERE username = ? and question=  ? and reponse=? ";

            connection = DBHandler.connectDB();
            try {
                preparedStatement = connection.prepareStatement(selectData);
                preparedStatement.setString(1, fp_username.getText());
                preparedStatement.setString(2, fp_question.getSelectionModel().getSelectedItem().toString());
                preparedStatement.setString(3,fp_reponse.getText());
                resultSet = preparedStatement.executeQuery();

                if (!resultSet.next()){
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect informations");
                    alert.showAndWait();
                }else {
                    np_loginForm.setVisible(true);
                    fg_loginForm.setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void changePassButtom() {
        if (np_password.getText().isEmpty() || np_passworConfirm.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Veillez remplir tous les champ svp  ");
            alert.showAndWait();
        }else if (!np_password.getText().equals(np_passworConfirm.getText())){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Le deux mots de passe sont different  ");
            alert.showAndWait();
        }else {

            String updatePass="UPDATE utilisateur SET username= '"+fp_username.getText()+"', question= '"
                    +fp_question.getSelectionModel().getSelectedItem()+"', reponse= '"+fp_reponse.getText()+"',password= '"+np_password.getText()
                    +"' WHERE username = '"+fp_username.getText()+"'";
            connection = DBHandler.connectDB();
            try {
                preparedStatement = connection.prepareStatement(updatePass);
                preparedStatement.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Mots de passe change avec success  ");
                alert.showAndWait();
                np_password.setText("");
                np_passworConfirm.setText("");

            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }



    public void signInBottomLogin(ActionEvent event) {
          String username = si_username.getText();
          String password = si_password.getText();

          if (username.isEmpty() || password.isEmpty()){
              alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error");
              alert.setHeaderText(null);
              alert.setContentText("Aucun champ ne peut etre vide ");
              alert.showAndWait();

          } else {
              String selectData = "SELECT username, password FROM utilisateur WHERE username = ? and password= ?";

              connection = DBHandler.connectDB();
              try {
                  preparedStatement = connection.prepareStatement(selectData);
                  preparedStatement.setString(1,username);
                  preparedStatement.setString(2,password);
                  resultSet = preparedStatement.executeQuery();

                  if(!resultSet.next()){
                      alert = new Alert(Alert.AlertType.WARNING);
                      alert.setTitle("Warning");
                      alert.setHeaderText(null);
                      alert.setContentText("Username/Password Incorrect ");
                      alert.showAndWait();
                  }else {
                      Data.username=si_username.getText();
                      System.out.println(Data.username);
                      alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Infos");
                      alert.setHeaderText(null);
                      alert.setContentText("Login successfull ");
                      alert.showAndWait();
                      Stage stage = new Stage();
                      Parent root = FXMLLoader.load(getClass().getResource("mainForm.fxml"));
                      Scene scene = new Scene(root);
                      stage.setTitle("Gestion du salle de sport et de bien etre");
                      stage.setMinHeight(1090);
                      stage.setMinWidth(650);
                      stage.setScene(scene);
                      stage.show();
                      si_loginBtn.getScene().getWindow().hide();
                      si_username.setText("");
                      si_password.setText("");
                  }


              }catch (Exception exception){
                  exception.printStackTrace();

              }

          }
    }

    public void  retourButtom(){
        si_loginForm.setVisible(true);
        np_loginForm.setVisible(false);
    }

    public void questionButtomRetour(){
        si_loginForm.setVisible(true);
        fg_loginForm.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}