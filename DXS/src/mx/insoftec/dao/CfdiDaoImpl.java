package mx.insoftec.dao;

import java.util.List;
import mx.insoftec.model.Cfdi;
import mx.insoftec.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CfdiDaoImpl implements CfdiDao {

    @Override
    public List<Cfdi> listaCfdiReceptor(String rfc, String f1, String f2) {
        List<Cfdi> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Cfdi where RfcReceptor='" + rfc + "' and Fecha >='" + f1 + "' and Fecha <='" + f2 + "' order by Fecha";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
        }
        return lista;
    }

    @Override
    public List<Cfdi> listaCfdiEmisor(String rfc, String f1, String f2) {
        List<Cfdi> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Cfdi where RfcEmisor='" + rfc + "' and Fecha >= '" + f1 + "' and Fecha <='" + f2 + "' order by Fecha";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void insertCfdi(Cfdi cfdi) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cfdi);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("null")
    public void updateCfdi(Cfdi cfdi) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cfdi);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("null")
    public void deleteCfdi(Cfdi cfdi) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cfdi);
            session.getTransaction().rollback();
        } catch (HibernateException e) {
            session.beginTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Cfdi> listarUUID(String uuid) {
        List<Cfdi> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select uuid From Cfdi where uuid='" + uuid + "'";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
        }
        return lista;
    }

    @Override
    public List<Cfdi> listarTodo(String d1, String d2) {
        List<Cfdi> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Cfdi where estatusCfdi='Vigente' and Fecha >= '" + d1 + "' and Fecha <='" + d2 + "' ";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
        }
        return lista;
    }

}
