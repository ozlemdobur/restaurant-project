package com.restaurant.authorization;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ViewResolver {
    private static final Map<String, String> roleViews = new HashMap<>();

    static {
        roleViews.put(Session.ADMIN, "personnel;product;menu;reservationAdministration;tables");
        roleViews.put(Session.CHEF, "menu");
        roleViews.put(Session.HEADWAITER, "product");
        roleViews.put(Session.WAITER, "tables");
    }

    public static String getRequestedView(String view) {
        if(!Session.personnelLoggedIn()) return "redirect:/index";
        String role = Session.getRole();
        String views = roleViews.get(role);
        if(views.contains(view)) return view;
        return "redirect:/index";
    }

    public static String getMainView() {
        if(!Session.personnelLoggedIn()) return "redirect:/index";
        String role = Session.getRole();
        String views = roleViews.get(role);
        return views.split(";")[0];
    }
}

