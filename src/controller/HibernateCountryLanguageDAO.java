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
import model.CountrylanguageId;
import model.Countrylanguage;
import controller.HibernateDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateCountryLanguageDAO {
    Countrylanguage CountryLanguage;
    CountrylanguageId id;
    Transaction transaction;
    
    public boolean addCountryLanguage (Countrylanguage CountryLanguage){
        HibernateDAO dao = new HibernateDAO();
        try {
            
            dao.save(CountryLanguage);
            transaction = dao.getSession().beginTransaction();
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
    
    public boolean deleteCountryLanguage (Countrylanguage CountryLanguage, CountrylanguageId id){
        HibernateDAO dao = new HibernateDAO();
        try {
            transaction = dao.getSession().beginTransaction();
            dao.load(CountryLanguage, id);
            dao.delete(CountryLanguage);
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
    
    // Think the update can be improvements in the future, its basic 
    public boolean updateCountryLanguage (Countrylanguage countryLanguage, CountrylanguageId id, Countrylanguage newLanguage){
        HibernateDAO dao = new HibernateDAO();
        try {
            transaction = dao.getSession().beginTransaction();
            dao.load(countryLanguage, id);
            if(newLanguage.getCountry() != null)
            countryLanguage.setCountry(newLanguage.getCountry()); 
            if(newLanguage.getId() != null)
            countryLanguage.setId(newLanguage.getId());
            if(newLanguage.getPercentage() != 0.0)
            countryLanguage.setPercentage(newLanguage.getPercentage());
            dao.update(countryLanguage);
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
     
}

