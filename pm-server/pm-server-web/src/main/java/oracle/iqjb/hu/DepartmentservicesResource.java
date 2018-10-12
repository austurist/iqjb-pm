/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import java.net.URI;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import oracle.iqjb.hu.cdi.DepartmentSessionServiceCDIBean;
import oracle.iqjb.hu.cdi.IqjbDb1;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.intf.AddDepartmentResponseEnum;

/**
 * REST Web Service
 *
 * @author oracle
 */
@Path("departmentservices")
@RequestScoped
public class DepartmentservicesResource {
    
    @Inject
    @Named(value = "departmentSessionServiceCDIBean")
    private DepartmentSessionServiceCDIBean dssb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DepartmentservicesResource
     */
    public DepartmentservicesResource() {
    }

    /**
     * Retrieves representation of an instance of oracle.iqjb.hu.DepartmentservicesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        //TODO return proper representation object
        return "echo";
    }

    /**
     * PUT method for updating or creating an instance of DepartmentservicesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Path("/ls/{deptname}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> listDepartment(@PathParam("deptname") String deptname) {
        return dssb.getDepartmentCDI(deptname);
    }
    
    @PUT
    @Path("/mk/{deptname}")
    @Produces(MediaType.APPLICATION_JSON)
    public AddDepartmentResponseEnum addDept(@PathParam("deptname") String deptname) {
        return dssb.addDepartmentCDI(deptname);
    }
    
    @PUT
    @Path("/cr/{deptname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDept(@PathParam("deptname") String deptname) {
        Department dept = dssb.createDepartmentCDI(deptname);
        URI uri = context.getAbsolutePathBuilder().path(dept.getId().toString()).build();
        return  Response.created(uri).build();
    }

    @PUT
    @Path("/ud/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> updateDept(@PathParam("id") Long id, Department dept) {
        return dssb.updateByIdCDI(id, dept);
    }
    
    
    @DELETE
    @Path("/dl/{deptname}")
    public void deleteDept(@PathParam("deptname") String deptname) {
        dssb.delDepartmentCDI(deptname);
    }
}
