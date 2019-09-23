/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.HibernateCityDAO;
import model.City;
import view.HomeScreen;

/**
 *
 * @author Gabriel Mouallem
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HomeScreen home = new HomeScreen();
        home.dispose();
        home.setUndecorated(true);
        home.setVisible(true);
        
        City city = new City (9992, "Cidade Hibernate2", "AFG", "Hibernata", 99999);
        HibernateCityDAO dao = new HibernateCityDAO();
        dao.addCity(city);
        
    }
    
}
