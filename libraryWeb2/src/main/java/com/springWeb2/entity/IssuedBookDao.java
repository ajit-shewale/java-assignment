package com.springWeb2.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

    @Entity
    @Table(name = "issued_books_table")
    public class IssuedBookDao {
        @Id
        @Column(name = "Book_id")
        private int id;
        @Column(name = "Title")
        private String title;
        @Column(name = "Author")
        private String author;
        @Column(name = "Cost") 
        private double cost;
        @Column(name = "Issued_date")
        private LocalDate issuedDate;
        @Column(name = "Return_date")
        private LocalDate returnDate;
        @Column(name="issuedfor")
        private String issuedFor;

        public IssuedBookDao() {
            super();
        }

        public IssuedBookDao(int id, String title, String author, double cost, LocalDate issuedDate,
                LocalDate returnDate, String issuedFor) {
            super();
            this.id = id;
            this.title = title;
            this.author = author;
            this.cost = cost;
            this.issuedDate = issuedDate;
            this.returnDate = returnDate;
            this.issuedFor = issuedFor;
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

        public LocalDate getIssuedDate() {
            return issuedDate;
        }

        public void setIssuedDate(LocalDate issuedDate) {
            this.issuedDate = issuedDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }

        public String getIssuedFor() {
            return issuedFor;
        }

        public void setIssuedFor(String issuedFor) {
            this.issuedFor = issuedFor;
        }

        @Override
        public String toString() {
            return "IssuedBookDao [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost
                    + ", issuedDate=" + issuedDate + ", returnDate=" + returnDate + ", issuedFor=" + issuedFor + "]";
        }
        
    }
