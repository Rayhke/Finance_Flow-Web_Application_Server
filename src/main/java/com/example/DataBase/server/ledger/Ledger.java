package com.example.DataBase.server.ledger;

import com.example.DataBase.server.common.entity.commonEntityImpl;
import com.google.gson.JsonObject;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Entity
@Table(name = "ledgers")
public class Ledger extends commonEntityImpl {

    @Id
    @Column(name = "ledger_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ledger_id", length = 50)
    private String author;

    private String category;

    private String content;

    private Long unitPrice;

    private Long quantity;

    private Long totalPrice;

    @Column(name = "ledger_date")
    private Date date;

    public Ledger(JsonObject json) {
        this.author = json.get("author").getAsString();
        this.category = json.get("category").getAsString();
        this.content = json.get("content").getAsString();
        this.unitPrice = json.get("unitPrice").getAsLong();
        this.quantity = json.get("quantity").getAsLong();
        this.totalPrice = json.get("totalPrice").getAsLong();
        this.date = dateTranslate(json.get("date").getAsString());
    }



    public Date dateTranslate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = format.parse(date);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}