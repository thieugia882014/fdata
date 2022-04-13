package com.example.fdata.entity;



import java.util.HashMap;
import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int amount;
    private double price;
    private int status;

    public Product() {
    }

    public Product(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product(int id, String name, int amount, double price, int status) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = status;
    }
    public void checkValid(){
        this.error = new HashMap<>();
        if (this.name==null||this.name.length()==0){
            this.error.put("name","name requied");
        }
        if (this.price==0){
            this.error.put("price","price requied");
        }
    }
    public HashMap<String,String>error;
    public HashMap<String,String>getErrors(){
        checkValid();
        return error;
    }

    public boolean isvalid(){
        checkValid();
        return error ==null||error.size()==0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
