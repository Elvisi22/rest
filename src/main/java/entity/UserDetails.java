package entity;

import jakarta.persistence.*;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

