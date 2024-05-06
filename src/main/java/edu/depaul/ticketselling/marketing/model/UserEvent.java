package edu.depaul.ticketselling.marketing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private bUser user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private bEvent event;

    // 생성자, 게터, 세터 등 필요한 메서드 추가
        // 생성자
        public UserEvent() {
        }
    
        public UserEvent(bUser user, bEvent event) {
            this.user = user;
            this.event = event;
        }
    
        // 게터 및 세터
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public bUser getUser() {
            return user;
        }
    
        public void setUser(bUser user) {
            this.user = user;
        }
    
        public bEvent getEvent() {
            return event;
        }
    
        public void setEvent(bEvent event) {
            this.event = event;
        }
    
}
