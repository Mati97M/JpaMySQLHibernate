package org.example;

import org.example.models.Actor;
import org.example.models.ActorID;

import javax.persistence.*;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("actor_pu");
        EntityManager em = emf.createEntityManager();

        /*reading specific records*/
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Actor chris = em.find(Actor.class,new ActorID(" Walken","1943-03-31"));
        System.out.println(chris);
        //ups: typo, space in the front, let us replace this record with the correct one

        if(chris != null) {
            /*removing bad record*/
            /*but carefull, when we change ID, we must detach the object first*/
            em.remove(chris);
            em.detach(chris);   //now object is detached
            chris.setLastName("Walken");
            em.persist(chris);

        }
        transaction.commit();




        /*inserting new records*/
//        Actor russell = new Actor("Russell","Crowe", "1964-04-07","m",50);
//
//        em.getTransaction().begin();
//        em.persist(russell);
//        em.getTransaction().commit();



        System.out.println();
        System.out.println("Queries " + "*".repeat(30));
        /*reading all table*/
        Query everyActorQuery = em.createQuery("from Actor");
        List<Actor> actors = everyActorQuery.getResultList();
        for(Actor a: actors) {
            System.out.println(a);
        }


        /*altering field (different than ID) in the object (beeing in the persistent state)*/
//        em.getTransaction().begin();
//        System.out.println();
//        Actor johnny = em.find(Actor.class,new ActorID("Depp","1963-06-09"));
//        johnny.setWealthInMln(johnny.getWealthInMln() + 15);    //You know for what
//        em.getTransaction().commit();


        /*get specific columns, from specific records*/
        Query under200Mln = em.createQuery(
                "select firstName," +
                " lastName, " +
                "wealthInMln" +
                " from Actor where wealthInMln<200");
        List<Object[]> actorsUnder200Mln = under200Mln.getResultList();
        System.out.println();
        System.out.println("Actors under 200 Mln $");
        for(Object[] a: actorsUnder200Mln) {
            System.out.println(a[0] + " " + a[1] + ":\t" + a[2]);
        }

    }
}
