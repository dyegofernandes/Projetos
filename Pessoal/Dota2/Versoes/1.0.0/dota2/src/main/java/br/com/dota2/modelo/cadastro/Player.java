/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dota2.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */

@Entity
public class Player implements Serializable {

    @Id
    @SequenceGenerator(name = "Player", sequenceName = "seq_player")
    @GeneratedValue(generator = "Player")
    private Long id;

    @Size(max = 50)
    @NotBlank(message = "Apelido é obrigatório!")
    private String personAName;
    
    @Size(max = 255)
    @NotBlank(message = "Apelido é obrigatório!")
    private String name;
    
    private int cheese;
    
    @Size(max = 255)
    @NotBlank(message = "Apelido é obrigatório!")
    private String steamId;
    
    private String avatar;
    
    private String avatarMedium;
    
    private String avatarFull;
    
    private String profileUrl;
    
    private Date last_login;
    
    private String locCountryCode;
    
}
