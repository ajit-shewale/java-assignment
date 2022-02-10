package com.springWeb2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class IssuedBookDao {
    @Entity
    @Table(name = "issued_books_table")
    public class BookDao {
        @Id
        @Column(name = "Book_Id")
        private int id;
        @Column(name = "Title")
        private String title;
        @Column(name = "Author")
        private String author;
        @Column(name = "Cost")
        private double cost;

        public BookDao() {
            super();
        }

        public BookDao(int id, String title, String author, double cost) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.cost = cost;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost + "]";
        }
    }
}
