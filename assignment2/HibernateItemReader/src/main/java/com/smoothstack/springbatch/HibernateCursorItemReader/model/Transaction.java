package com.smoothstack.springbatch.HibernateCursorItemReader.model;
import javax.persistence.*;

/*
    CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(256) NOT NULL,
  `county` varchar(256) NOT NULL,
  `area` varchar(256) NOT NULL,
  `number` varchar(256) NOT NULL,
  `totalArea` varchar(256) NOT NULL,
  `averageArea` varchar(256) NOT NULL,
  `totalTransactionAmount` varchar(256) NOT NULL,
  `minimumTransactionAmount` varchar(256) NOT NULL,
  `maximumTransactionAmount` varchar(256) NOT NULL,
  `unitPriceMinimum` varchar(256) NOT NULL,
  `unitPriceMaximum` varchar(256) NOT NULL,
  `unitPriceMedian` varchar(256) NOT NULL,
  `unitPriceAverage` varchar(256) NOT NULL,
  `unitPriceStandardDeviation` varchar(256) NOT NULL,
  `month` varchar(256) NOT NULL,
  `year` varchar(256) NOT NULL,
  `indx` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2036 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM hb_student_tracker.transactions;

*/

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "county")
    private String county;

    @Column(name = "area")
    private String area;

    @Column(name = "number")
    private String number;

    @Column(name = "totalArea")
    private String totalArea;

    @Column(name = "averageArea")
    private String averageArea;

    @Column(name = "totalTransactionAmount")
    private String totalTransactionAmount;

    @Column(name = "minimumTransactionAmoun")
    private String minimumTransactionAmount;

    @Column(name = "maximumTransactionAmount")
    private String maximumTransactionAmount;

    @Column(name = "unitPriceMinimum")
    private String unitPriceMinimum;

    @Column(name = "unitPriceMaximum")
    private String unitPriceMaximum;

    @Column(name = "unitPriceMedian")
    private String unitPriceMedian;

    @Column(name = "unitPriceAverage")
    private String unitPriceAverage;

    @Column(name = "unitPriceStandardDeviation")
    private String unitPriceStandardDeviation;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    @Column(name = "indx")
    private String indx;


    public Transaction(){};


    public Transaction(Integer id, String date, String county, String area, String number, String totalArea, String averageArea, String totalTransactionAmount, String minimumTransactionAmount, String maximumTransactionAmount, String unitPriceMinimum, String unitPriceMaximum, String unitPriceMedian, String unitPriceAverage, String unitPriceStandardDeviation, String month, String year, String indx) {
        this.id = id;
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
