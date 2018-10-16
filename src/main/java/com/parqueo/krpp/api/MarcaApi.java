package com.parqueo.krpp.api;

import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.entities.Usuario;
import com.parqueo.krpp.util.KrppHibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import java.util.List;

public class MarcaApi {

    protected final SessionFactory sessionFactory = KrppHibernateUtil.getSessionFactory();
    final static Logger logger = Logger.getLogger(MarcaApi.class);
    private static MarcaApi instance;

    public static MarcaApi getInstance() {
        if (instance == null) {
            instance = new MarcaApi();
        }
        return instance;
    }

    //obtiene las marcas de la BD
    public List<Marca> getAll() {
        Session s = null;
        boolean wasRollback = false;
        try {

            s = beginTransaction();
            //verificamos si existe el usuario dado
            List<Marca> marcas = s.createNamedQuery("Marca.getAll")
                    .getResultList();

            return marcas;
        } catch (Throwable t) {
            wasRollback = true;
        } finally {
            try {
                endTransaction(s, wasRollback);
            } catch (Throwable t) {

            }
        }
        return null;
    }

    public boolean save(Marca marca) {
        Session s = null;
        boolean wasRollback = false;
        try {

            s = beginTransaction();
            //guardamos la marca
            s.persist(marca);
            return true;
        } catch (Throwable t) {
            wasRollback = true;
        } finally {
            try {
                endTransaction(s, wasRollback);
            } catch (Throwable t) {

            }
        }
        return false;
    }


    public Session openSession() {
        return sessionFactory.openSession();
    }

    public Session beginTransaction() {
        try {
            Session s = openSession();
            s.beginTransaction();
            return s;
        } catch (Exception e) {
            throw new HibernateException(e);
        }

    }

    public void endTransaction(Session s, boolean wasRollback) {
        try {
            if (!wasRollback) {
                s.getTransaction().commit();
            } else {
                logger.warn(" endTransaction | se hizo ROLLBACK");
                s.getTransaction().rollback();
            }
        } catch (Exception e) {
            throw new HibernateException(e);
        } finally {
            s.close();
        }
    }
}
