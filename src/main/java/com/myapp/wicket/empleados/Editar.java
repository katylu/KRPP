/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.empleados;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.entities.Empleado;
import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.modelo.EmpleadosModel;
import com.parqueo.krpp.modelo.MarcasModel;
import com.parqueo.krpp.repository.EmpleadoRepository;
import com.parqueo.krpp.repository.MarcaRepository;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Editar extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;
    final static Logger logger = Logger.getLogger(com.myapp.wicket.LoginPage.class);
    public Editar(final PageParameters params){

        final Integer empleadoId = params.get("empleado").toInteger();
        Empleado empleado = EmpleadoRepository.getInstance().getById(empleadoId);

        final EmpleadosModel empleadosModel = empleado.toModel();

        Form<Object> form = new Form<Object>("form");

        form.add(new TextField<String>("nroCedula", new PropertyModel<String>(empleadosModel, "nroCedula")));
        form.add(new TextField<String>("nombreCompleto", new PropertyModel<String>(empleadosModel, "nombreCompleto")));
        form.add(new TextField<String>("estadoCivil", new PropertyModel<String>(empleadosModel, "estadoCivil")));
        form.add(new TextField<String>("sexo", new PropertyModel<String>(empleadosModel, "sexo")));

        form.add(new Button("submit") {
            private static final long serialVersionUID = -8676092495300239679L;

            @Override
            public void onSubmit() {
                //guardamos la marca
                Empleado empleado = new Empleado(empleadosModel.getIdEmpleado(), empleadosModel.getNroCedula(), empleadosModel.getNombreCompleto(), empleadosModel.getFechaNacimiento(),
                        empleadosModel.getEstadoCivil(), empleadosModel.getSexo());

                EmpleadoRepository.getInstance().update(empleado);
                setResponsePage(Listar.class);
            }
        });

        add(form);
    }

}
