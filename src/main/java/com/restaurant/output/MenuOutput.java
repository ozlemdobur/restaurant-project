package com.restaurant.output;


public class MenuOutput {
    private Long id;
    private String menuName;
    private String menuType;
    private String imagePath;
    private String productNames;

    public MenuOutput() {
    }

    public MenuOutput(Long id, String menuName, String menuType, String imagePath, String productNames) {
        this.id = id;
        this.menuName = menuName;
        this.menuType = menuType;
        this.imagePath = imagePath;
        this.productNames = productNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    @Override
    public String toString() {
        return "MenuOutput{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuType='" + menuType + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", productNames='" + productNames + '\'' +
                '}';
    }
}
