package com.nf.hibernate.assoc.many2one_oneway;


import com.nf.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MOTest {


    @Test
    public void initDate() {

        Author luxun = new Author();
        luxun.setName("鲁迅");
        luxun.setPhone("110");

        session.save(luxun);

        Book book1 = new Book("呐喊",12f, luxun);
        Book book2 = new Book("彷徨",11f, luxun);

        session.save(book1);
        session.save(book2);

    }
    //先写 Before 与 After 两部分
    private Session session;
    private Transaction transaction;

    @Before
    private void setup(){
        session = SessionUtil.getSession();
        transaction = session.beginTransaction();
    }

    @After
    private void last(){
        if (session.isOpen()){
            transaction.commit();
            session.close();
        }
    }
}
