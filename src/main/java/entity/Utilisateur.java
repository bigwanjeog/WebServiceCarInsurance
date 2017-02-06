/**
 * This file was generated by the JPA Modeler
 */ 

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author  RENAUD
 */

@Entity
@XmlRootElement
public class Utilisateur implements Serializable { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    private String nom;

    @Basic
    private String prenom;

    @Basic
    private String adresse;

    @Basic
    private String ville;

    @Basic
    private String cp;

    @Basic
    private String dateNaissance;

    @Basic
    private String email;

    @Basic
    private String password;

    @Basic
    private String fonction;

    @Basic
    private double prix;

    @ManyToOne(targetEntity = Voiture.class)
    private Voiture voiture;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return this.cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFonction() {
        return this.fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Voiture getVoiture() {
        return this.voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

}
