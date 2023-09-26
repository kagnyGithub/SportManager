package sid.org.sportmanager.dao;

import sid.org.sportmanager.DBConnexion.DBHandler;
import sid.org.sportmanager.entities.Membre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembreDAO {

    // Méthode pour créer un membre
    public static void createMembre(Membre membre) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "INSERT INTO membre (nom, prenom, adresse, telephone, dateNaissance, dateInscription, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, membre.getNom());
                preparedStatement.setString(2, membre.getPrenom());
                preparedStatement.setString(3, membre.getAdresse());
                preparedStatement.setString(4, membre.getTelephone());
                preparedStatement.setDate(5, new java.sql.Date(membre.getDateNaissance().getTime()));
                preparedStatement.setDate(6, new java.sql.Date(membre.getDateInscription().getTime()));
                preparedStatement.setInt(7, membre.getStatus());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Gérer les erreurs de la base de données
            } finally {
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Méthode pour lire un membre par son ID
    public static Membre readMembreById(Integer id) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM membre WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Créez un objet Membre à partir des données de la base de données
                    Membre membre = new Membre();
                    membre.setId(resultSet.getInt("id"));
                    membre.setNom(resultSet.getString("nom"));
                    membre.setPrenom(resultSet.getString("prenom"));
                    membre.setAdresse(resultSet.getString("adresse"));
                    membre.setTelephone(resultSet.getString("telephone"));
                    membre.setDateNaissance(resultSet.getDate("dateNaissance"));
                    membre.setDateInscription(resultSet.getDate("dateInscription"));
                    membre.setStatus(resultSet.getInt("status"));
                    return membre;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Gérer les erreurs de la base de données
            } finally {
                try {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    // Méthode pour lire tous les membres
    public static List<Membre> readAllMembres() {
        Connection connection = DBHandler.connectDB();
        List<Membre> membres = new ArrayList<>();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM membre";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    // Créez un objet Membre pour chaque ligne de la base de données
                    Membre membre = new Membre();
                    membre.setId(resultSet.getInt("id"));
                    membre.setNom(resultSet.getString("nom"));
                    membre.setPrenom(resultSet.getString("prenom"));
                    membre.setAdresse(resultSet.getString("adresse"));
                    membre.setTelephone(resultSet.getString("telephone"));
                    membre.setDateNaissance(resultSet.getDate("dateNaissance"));
                    membre.setDateInscription(resultSet.getDate("dateInscription"));
                    membre.setStatus(resultSet.getInt("status"));
                    membres.add(membre);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Gérer les erreurs de la base de données
            } finally {
                try {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return membres;
    }

    // Méthode pour mettre à jour un membre
    public static void updateMembre(Integer id, Membre membre) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "UPDATE membre SET nom=?, prenom=?, adresse=?, telephone=?, dateNaissance=?, dateInscription=?, status=? WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, membre.getNom());
                preparedStatement.setString(2, membre.getPrenom());
                preparedStatement.setString(3, membre.getAdresse());
                preparedStatement.setString(4, membre.getTelephone());
                preparedStatement.setDate(5, new java.sql.Date(membre.getDateNaissance().getTime()));
                preparedStatement.setDate(6, new java.sql.Date(membre.getDateInscription().getTime()));
                preparedStatement.setInt(7, membre.getStatus());
                preparedStatement.setInt(8, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Gérer les erreurs de la base de données
            } finally {
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Méthode pour supprimer un membre par son ID
    public static void deleteMembre(Integer id) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "DELETE FROM membre WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Gérer les erreurs de la base de données
            } finally {
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

