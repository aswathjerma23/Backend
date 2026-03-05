package com.sicky.Backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users",
uniqueConstraints = {
@UniqueConstraint(columnNames = "email"),
@UniqueConstraint(columnNames = "phone_number"),
@UniqueConstraint(columnNames = "user_id")})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id",columnDefinition = "uuid", nullable = false)
    private UUID userId;

    @Column(name = "password_hash",nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "address")
    private String address;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "state")
    private String state;

    @Column(name = "post_code")
    private String postCode; 

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean isActive = true;

    @Column(name = "is_deleted", nullable = false)
    @Builder.Default
    private boolean isDeleted = false; 

    @Column(name = "is_signup_confirmed",nullable = false)
    private boolean isSignupConfirmed;

    @Column(name = "is_phone_verified", nullable = false)
    private boolean isPhoneverified;

    @Column(name = "is_email_verified", nullable = false)
    private boolean isEmailVerified;

    @Column(name = "confirm_code_hash")
    private String confirmCodeHash;

    @Column(name = "registration_ids",columnDefinition = "json")
    private String registrationIds;

    @Column(name = "current_ip")
    private String  currentIp;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "push_notification")
    private boolean pushNotification;

    @Column(name = "sms_alert")
    private boolean smsAlert;

    @Version
    @Column(name = "version",nullable = false)
    private Long version;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
