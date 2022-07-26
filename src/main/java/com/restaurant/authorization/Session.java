package com.restaurant.authorization;

import com.restaurant.model.Personnel;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Session {

    private static Personnel personnel = null;

    // All roles
    public static final String VISITOR = "Visitor";
    public static final String ADMIN = "Admin";
    public static final String CHEF = "Chef";
    public static final String HEADWAITER = "Headwaiter";
    public static final String WAITER = "Waiter";


    private static Map<String, String> roles = new HashMap<>();

    // connect personnel to role
    // Role VISITOR is used when not logged in
    static {
        roles.put("akarabas", WAITER);
        roles.put("odobur", CHEF);
        roles.put("nbayram", HEADWAITER);
        roles.put("witt", ADMIN);

    }

    public static void addUser(String username, String role) { roles.put(username, role); }

    public static void createSession( Personnel personnel){
        Session.personnel = personnel;
    }

    public static void invalidateSession(){
        personnel = null;
    }

    public static boolean personnelLoggedIn(){
        return personnel != null;
    }

    public static String getRole(){
        if( !personnelLoggedIn())return Session.VISITOR;
        return roles.get(personnel.getUsername());
    }

    public static String getPersonnelRole(String username){
        return roles.get(username);
    }
}

