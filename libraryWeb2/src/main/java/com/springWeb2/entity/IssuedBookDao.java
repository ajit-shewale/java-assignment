package com.springWeb2.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "issued_books_table")
    public class IssuedBookDao {
        @Id
        @Column(name = "Book_Id")
        private int id;
        @Column(name = "Title")
        private String title;
        @Column(name = "Author")
        private String author;
        @Column(name = "Cost")
        private double cost;
        @Column(name = "Issued_date")
        private LocalDate issued_date;
        @Column(name = "Return_date")
        private LocalDate return_date;

        public IssuedBookDao() {
            super();
        }

        public IssuedBookDao(int id, String title, String author, double cost, LocalDate issued_date, LocalDate return_date) {
            super();
            this.id = id;
            this.title = title;
            this.author = author;
            this.cost = cost;
            this.issued_date = issued_date;
            this.return_date = return_date;
        }

        public IssuedBookDao(int id2, String title2, String author2, double cost2) {
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

        public LocalDate getIssued_date() {
            return issued_date;
        }

        public void setIssued_date(LocalDate issued_date) {
            this.issued_date = issued_date;
        }

        public LocalDate getReturn_date() {
            return return_date;
        }

        public void setReturn_date(LocalDate return_date) {
            this.return_date = return_date;
        }

        @Override
        public String toString() {
            return "IssuedBookDao [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost
                    + ", issued_date=" + issued_date + ", return_date=" + return_date + "]";
        }
    }
