package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;

public class ServiceProduit implements IServiceProduit {

    private Connection cnx;

    public ServiceProduit() {
        cnx = SingletonConnection.getInstance();
    }

    @Override
    public void addProduct(Produit p) {

        String sql = "INSERT INTO produit (nom, prix, quantite) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());

            ps.executeUpdate();

            System.out.println("Produit ajouté avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {

        String sql = "DELETE FROM produit WHERE id = ?";

        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Produit supprimé avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(int id, Produit p) {

        String sql = "UPDATE produit SET nom = ?, prix = ?, quantite = ? WHERE id = ?";

        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Produit modifié avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produit getProduct(int id) {

        String sql = "SELECT * FROM produit WHERE id = ?";

        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Produit(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getDouble("prix"),
                    rs.getInt("quantite")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Produit> getAllProducts() {
        List<Produit> l=new ArrayList<Produit>();
        PreparedStatement ps;
        try {
            ps = cnx.prepareStatement("select * from produit");
            ResultSet rs=ps.executeQuery();
            while (rs.next())
                l.add(new Produit(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4)));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public List<Produit> getProductsByMC(String mc) {
        List<Produit> l=new ArrayList<Produit>();
        PreparedStatement ps;
        try {
            ps = cnx.prepareStatement("select * from produit where nom like ?");
            ps.setString(1,"%"+mc+"%");
            ResultSet rs=ps.executeQuery();
            while (rs.next())
                l.add(new Produit(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4)));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return l;
    }
}