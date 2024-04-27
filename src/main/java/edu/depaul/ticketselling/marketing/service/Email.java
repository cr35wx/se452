package edu.depaul.ticketselling.marketing.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * @author Suhwan Kim
 */

 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 public class Email {
    
     private String recipient;
     private String subject;
     private String body;
 }
 