package com.nf.hibernate.assoc.many2one_oneway;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "aaa")//主键生成器
    @Column(name = "bookid")
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "authorid") // 它跟 Column 是一对兄弟，都是用来定义实体类属性对应的表的字段的名字。只不过 @Column 用来定义普通字段，但是 @JoinColumn 用来定义外键字段。
    private String Author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Book(String 呐喊, float price, com.nf.hibernate.assoc.many2one_oneway.Author luxun) {
    }

    public Book(String name, float price, String author) {
        this.name = name;
        this.price = price;
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", Author='" + Author + '\'' +
                '}';
    }
}
