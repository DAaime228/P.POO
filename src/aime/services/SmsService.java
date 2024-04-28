/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aime.services;

import aime.entities.Sms;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SmsService {
   void ajouterSms(Sms sms);
    Sms trouverSmsParId(int id);
    void mettreAJourSms(Sms sms);
    void supprimerSms(int id);
    List<Sms> obtenirTousLesSms(); 
}
