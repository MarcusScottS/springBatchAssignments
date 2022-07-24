package com.smoothstack.JDBCCursorItemReader.model;

import javax.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    private String date;

    @Column
    private String county;

    @Column
    private String area;

    @Column
    private String number;

    @Column
    private String totalArea;

    @Column
    private String averageArea;

    @Column
    private String totalTransactionAmount;

    @Column
    private String minimumTransactionAmount;

    @Column
    private String maximumTransactionAmount;

    @Column
    private String unitPriceMinimum;

    @Column
    private String unitPriceMaximum;

    @Column
    private String unitPriceMedian;

    @Column
    private String unitPriceAverage;

    @Column
    private String unitPriceStandardDeviation;

    @Column
    private String month;

    @Column
    private String year;

    @Column
    private String indx;

    public Transaction() {
    }

    public Transaction(String date, String county, String area, String number, String totalArea, String averageArea, String totalTransactionAmount, String minimumTransactionAmount, String maximumTransactionAmount, String unitPriceMinimum, String unitPriceMaximum, String unitPriceMedian, String unitPriceAverage, String unitPriceStandardDeviation, String month, String year, String indx) {
        this.date = date;
        this.county = county;
        this.area = area;
        this.number = number;
        this.totalArea = totalArea;
        this.averageArea = averageArea;
        this.totalTransactionAmount = totalTransactionAmount;
        this.minimumTransactionAmount = minimumTransactionAmount;
        this.maximumTransactionAmount = maximumTransactionAmount;
        this.unitPriceMinimum = unitPriceMinimum;
        this.unitPriceMaximum = unitPriceMaximum;
        this.unitPriceMedian = unitPriceMedian;
        this.unitPriceAverage = unitPriceAverage;
        this.unitPriceStandardDeviation = unitPriceStandardDeviation;
        this.month = month;
        this.year = year;
        this.indx = indx;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }

    public String getAverageArea() {
        return averageArea;
    }

    public void setAverageArea(String averageArea) {
        this.averageArea = averageArea;
    }

    public String getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public void setTotalTransactionAmount(String totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
    }

    public String getMinimumTransactionAmount() {
        return minimumTransactionAmount;
    }

    public void setMinimumTransactionAmount(String minimumTransactionAmount) {
        this.minimumTransactionAmount = minimumTransactionAmount;
    }

    public String getMaximumTransactionAmount() {
        return maximumTransactionAmount;
    }

    public void setMaximumTransactionAmount(String maximumTransactionAmount) {
        this.maximumTransactionAmount = maximumTransactionAmount;
    }

    public String getUnitPriceMinimum() {
        return unitPriceMinimum;
    }

    public void setUnitPriceMinimum(String unitPriceMinimum) {
        this.unitPriceMinimum = unitPriceMinimum;
    }

    public String getUnitPriceMaximum() {
        return unitPriceMaximum;
    }

    public void setUnitPriceMaximum(String unitPriceMaximum) {
        this.unitPriceMaximum = unitPriceMaximum;
    }

    public String getUnitPriceMedian() {
        return unitPriceMedian;
    }

    public void setUnitPriceMedian(String unitPriceMedian) {
        this.unitPriceMedian = unitPriceMedian;
    }

    public String getUnitPriceAverage() {
        return unitPriceAverage;
    }

    public void setUnitPriceAverage(String unitPriceAverage) {
        this.unitPriceAverage = unitPriceAverage;
    }

    public String getUnitPriceStandardDeviation() {
        return unitPriceStandardDeviation;
    }

    public void setUnitPriceStandardDeviation(String unitPriceStandardDeviation) {
        this.unitPriceStandardDeviation = unitPriceStandardDeviation;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIndx() {
        return indx;
    }

    public void setIndx(String indx) {
        this.indx = indx;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", county='" + county + '\'' +
                ", area='" + area + '\'' +
                ", number='" + number + '\'' +
                ", totalArea='" + totalArea + '\'' +
                ", averageArea='" + averageArea + '\'' +
                ", totalTransactionAmount='" + totalTransactionAmount + '\'' +
                ", minimumTransactionAmount='" + minimumTransactionAmount + '\'' +
                ", maximumTransactionAmount='" + maximumTransactionAmount + '\'' +
                ", unitPriceMinimum='" + unitPriceMinimum + '\'' +
                ", unitPriceMaximum='" + unitPriceMaximum + '\'' +
                ", unitPriceMedian='" + unitPriceMedian + '\'' +
                ", unitPriceAverage='" + unitPriceAverage + '\'' +
                ", unitPriceStandardDeviation='" + unitPriceStandardDeviation + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", indx='" + indx + '\'' +
                '}';
    }
}