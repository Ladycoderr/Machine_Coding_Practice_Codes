package com.example.Library.management.System.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String userId;
    private String username;
    private UserProfile user;
    private Map<String, LocalDateTime> borrowedBooks = new HashMap<>();
}
