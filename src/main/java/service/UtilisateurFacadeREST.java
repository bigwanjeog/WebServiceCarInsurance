/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author RENAUD
 */
@Stateless
@Path("entity.utilisateur")
public class UtilisateurFacadeREST extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "CarInsurancePU")
    private EntityManager em;

    public UtilisateurFacadeREST() {
        super(Utilisateur.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Utilisateur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Utilisateur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Utilisateur find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("email/{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByEmail(@PathParam("email") String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("email"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, email);
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }
    
    @GET
    @Path("surname/{surname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findBySurname(@PathParam("surname") String surname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.like(c.<String>get("nom"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, "%" + surname + "%");
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByName(@PathParam("name") String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.like(c.<String>get("prenom"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, "%" + name + "%");
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

    @GET
    @Path("adress/{adress}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByAdress(@PathParam("adress") String adress) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.like(c.<String>get("adresse"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, "%" + adress + "%");
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

    @GET
    @Path("city/{city}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByCity(@PathParam("city") String city) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.like(c.<String>get("ville"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, "%" + city + "%");
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

    @GET
    @Path("cp/{cp}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByCP(@PathParam("cp") String cp) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.like(c.<String>get("cp"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, "%" + cp + "%");
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

    @GET
    @Path("birthday/{birthday}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByBirthday(@PathParam("birthday") String dateNaissance) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.like(c.<String>get("dateNaissance"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, "%" + dateNaissance + "%");
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

    @GET
    @Path("function/{function}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findByFunction(@PathParam("function") String function) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> q = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> c = q.from(Utilisateur.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("fonction"), p));
        TypedQuery<Utilisateur> query = em.createQuery(q);
        query.setParameter(p, function);
        List<Utilisateur> utilisateurs = query.getResultList();
        return utilisateurs;
    }

}
