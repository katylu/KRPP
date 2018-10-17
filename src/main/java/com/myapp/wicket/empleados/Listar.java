/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.empleados;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.entities.Empleado;
import com.parqueo.krpp.repository.EmpleadoRepository;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

public class Listar extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;

    public Listar() {
        super();

        //agregamos el enlace a la pagina de creacion
        add(new BookmarkablePageLink<Crear>("Empleado.Crear" , Crear.class));

        //obtenemos las marcas de la bd
        List<Empleado> empleados = EmpleadoRepository.getInstance().getAll();

        add(new ListView<Empleado>("empleados", empleados) {
            @Override
            protected void populateItem(ListItem<Empleado> item) {
                Empleado m = item.getModelObject();
                //columnas del listado
                item.add(new Label("idEmpleado", new PropertyModel(item.getModel(), "idEmpleado")));
                item.add(new Label("nroCedula", new PropertyModel(item.getModel(), "nroCedula")));
                item.add(new Label("nombreCompleto", new PropertyModel(item.getModel(), "nombreCompleto")));
                item.add(new Label("fechaNacimiento", new PropertyModel(item.getModel(), "fechaNacimiento")));
                item.add(new Label("estadoCivil", new PropertyModel(item.getModel(), "estadoCivil")));
                item.add(new Label("sexo", new PropertyModel(item.getModel(), "sexo")));

                //link para editar
                PageParameters pageParameters = new PageParameters();
                pageParameters.add("empleado", m.getIdEmpleado());
                item.add(new BookmarkablePageLink<Void>("editLink",
                        Editar.class, pageParameters));

                //link para eliminar
                Link<Integer> deleteLink = new Link<Integer>("deleteLink",
                        new Model<Integer>(m.getIdEmpleado())) {
                    @Override
                    public void onClick() {
                        EmpleadoRepository.getInstance().deleteById(getModelObject());
                    }
                };
                deleteLink.add(new AttributeModifier("onclick",
                        "return confirm('Esta seguro de eliminar el empleado "
                                + m.getNombreCompleto().replace("\"", "\\\"")+ "?');"));
                item.add(deleteLink);
            }

        });


    }
}
