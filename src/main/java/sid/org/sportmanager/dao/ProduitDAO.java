package sid.org.sportmanager.dao;

import sid.org.sportmanager.DBConnexion.DBHandler;
import sid.org.sportmanager.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProduitDAO {

    // Méthode pour créer un produit
    public static void createProduit(Produit produit) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "INSERT INTO produit (produitID, produitName, produitType, produitStock, produitPrice, produitStatus, produitDate, produitImage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, produit.getProduitID());
                preparedStatement.setString(2, produit.getProduitName());
                preparedStatement.setString(3, produit.getProduitType());
                preparedStatement.setInt(4, produit.getProduitStock());
                preparedStatement.setFloat(5, produit.getProduitPrice());
                preparedStatement.setString(6, produit.getProduitStatus());
                preparedStatement.setDate(7, new java.sql.Date(produit.getProduitDate().getTime()));
                preparedStatement.setString(8, produit.getProduitImage());
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

    // Méthode pour lire un produit par son ID
    public static Produit readProduitById(Integer id) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM produit WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return mapResultSetToProduit(resultSet);
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

    // Méthode pour lire tous les produits
    public static List<Produit> readAllProduits() {
        List<Produit> produits = new ArrayList<>();
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                String query = "SELECT * FROM produit";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    produits.add(mapResultSetToProduit(resultSet));
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

        return produits;
    }

    // Méthode pour mettre à jour un produit par son ID
    public static void updateProduit(int id, Produit produit) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "UPDATE produit SET produitID=?, produitName=?, produitType=?, produitStock=?, produitPrice=?, produitStatus=?, produitDate=?, produitImage=? WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, produit.getProduitID());
                preparedStatement.setString(2, produit.getProduitName());
                preparedStatement.setString(3, produit.getProduitType());
                preparedStatement.setInt(4, produit.getProduitStock());
                preparedStatement.setFloat(5, produit.getProduitPrice());
                preparedStatement.setString(6, produit.getProduitStatus());
                preparedStatement.setDate(7, new java.sql.Date(produit.getProduitDate().getTime()));
                preparedStatement.setString(8, produit.getProduitImage());
                preparedStatement.setInt(9, id); // ID du produit à mettre à jour
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


    // Méthode pour supprimer un produit par son ID
    public static void deleteProduit(Integer id) {
        Connection connection = DBHandler.connectDB();

        if (connection != null) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "DELETE FROM produit WHERE id=?";
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

    // Méthode utilitaire pour mapper un résultat de requête à un objet Produit
    private static Produit mapResultSetToProduit(ResultSet resultSet) throws SQLException {
        Produit produit = new Produit();
        produit.setId(resultSet.getInt("id"));
        produit.setProduitID(resultSet.getString("produitID"));
        produit.setProduitName(resultSet.getString("produitName"));
        produit.setProduitType(resultSet.getString("produitType"));
        produit.setProduitStock(resultSet.getInt("produitStock"));
        produit.setProduitPrice(resultSet.getFloat("produitPrice"));
        produit.setProduitStatus(resultSet.getString("produitStatus"));
        produit.setProduitDate(resultSet.getDate("produitDate"));
        produit.setProduitImage(resultSet.getString("produitImage"));
        return produit;
    }
}

