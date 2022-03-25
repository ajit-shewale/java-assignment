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
    @Table(name = "issue_requests")
    public class IssueRequestDao {
        @Id
        @Column(name = "Book_id")
        private int id;
        @Column(name = "Title")
        private String title;
        @Column(name = "Author")
        private String author;
        @Column(name = "Cost") 
        private double cost;
        @Column(name="issuedfor")
        private String issuedFor;
        
        
        public IssueRequestDao() {
            super();
            // TODO Auto-generated constructor stub
        }

        public IssueRequestDao(int id, String title, String author, double cost, String issuedFor) {
            super();
            this.id = id;
            this.title = title;
            this.author = author;
            this.cost = cost;
            this.issuedFor = issuedFor;
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

        public String getIssuedFor() {
            return issuedFor;
        }

        public void setIssuedFor(String issuedFor) {
            this.issuedFor = issuedFor;
        }

        @Override
        public String toString() {
            return "IssueRequestDao [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost
                    + ", issuedFor=" + issuedFor + "]";
        }

    }
