/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Gabriel Mouallem
 * @author Gabriel Zanon
 * @author Breno Nesto
 */
import model.City;
import controller.HibernateDAO;
import javax.swing.JOptionPane;
import org.hibernate.Transaction;

public class HibernateCityDAO {
    City city;
    Transaction transaction;
    
    public boolean addCity (City city){
        HibernateDAO dao = new HibernateDAO();
        try {
            transaction = dao.getSession().beginTransaction();
            dao.save(city);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            dao.closeSession();
        }
    }
    
    public boolean deleteCity (City city, int id){
        HibernateDAO dao = new HibernateDAO();
        try {
            transaction = dao.getSession().beginTransaction();
            dao.load(city, id);
            dao.delete(city);
            transaction.commit();
            return true;
        } 
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            dao.closeSession();
        }
    }
    
    // Think the update can be improvements in the future, its basic 
    public boolean updateCity (City city, int id, City newCity){
        HibernateDAO dao = new HibernateDAO();
        try {
            transaction = dao.getSession().beginTransaction();
            dao.load(city, id);
            
            if(newCity.getName()!= null)
            city.setName(newCity.getName()); 
            else if(newCity.getId() != 0)
            city.setId(newCity.getId());
            else if(newCity.getCountrycode()!= null)
            city.setCountrycode(newCity.getCountrycode());
            else if(newCity.getDistrict()!= null)
            city.setDistrict(newCity.getDistrict());
            else if(newCity.getPopulation()!= 0)
            city.setPopulation(newCity.getPopulation());
            
            dao.update(city);
            transaction.commit();
            return true;
        } 
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            dao.closeSession();
        }
    }
}

