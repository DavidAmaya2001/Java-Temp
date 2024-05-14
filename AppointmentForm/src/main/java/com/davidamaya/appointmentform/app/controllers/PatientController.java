package com.davidamaya.appointmentform.app.controllers;

import com.davidamaya.appointmentform.app.models.entity.Patient;
import com.davidamaya.appointmentform.app.models.services.address.IAddressService;
import com.davidamaya.appointmentform.app.models.services.appointment.IAppointmentService;
import com.davidamaya.appointmentform.app.models.services.patient.IPatientService;
import com.davidamaya.appointmentform.app.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IAppointmentService appointmentService;

    //--------------------------- Precarga del formulario Listar------------------------------------//
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 4);

        Page<Patient> patient = patientService.findAll(pageRequest);

        PageRender<Patient> pageRender = new PageRender<>("/listar", patient);
        model.addAttribute("titulo", "Lista de Pacientes");
        model.addAttribute("patient", patient);
        model.addAttribute("page", pageRender);
        return "listar";
    }

    //------------------------- Precarga del formulario formRegister--------------------------------//
    @RequestMapping(value = "/form")
    public String crear(Model model) {

        Patient patient = new Patient();
        model.addAttribute("tituloNav", "Clinica Tilin");
        model.addAttribute("tituloCard", "Formulario de cita - Registro");
        model.addAttribute("tituloSubCard", "Si desea concretar una cita de consulta con el Dr.Tilin, complete este " +
                              "formulario de cita y nos pondremos en contacto con usted lo antes posible. Si no recibe ninguna " +
                              "notificación este seguro que le dimos de baja del sistema y la policia lo estará buscando en este instante.");
        model.addAttribute("patient", patient);

        return "formRegister";
    }

    //----------------------------- Listado de Paises para ListBox ---------------------------------//
    @ModelAttribute(value = "countryList")
    public List<String> countryList(){
        return Arrays.asList("El Salvador", "Guatemala", "Honduras", "Nicaragua", "Costa Rica", "Panama");
    }

    //------------- Envio de datos del form a MySQL y precarga del formulario Listar ---------------//
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Patient patient, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario de Cliente");
            model.addAttribute("tituloNav", "Clinica Tilin");
            model.addAttribute("tituloCard", "Formulario de cita");
            model.addAttribute("tituloSubCard", "Si desea concretar una cita de consulta con el Dr.Tilin, complete este " +
                                  "formulario de cita y nos pondremos en contacto con usted lo antes posible. Si no recibe ninguna " +
                                  "notificación este seguro que le dimos de baja del sistema y la policia lo estará buscando en este instante.");
            model.addAttribute("patient", patient);

            return "formRegister";
        }
        String mensajeFlash = (patient.getId() != null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";

        patientService.save(patient);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:listar";
    }

    //------------------- Precarga de formulario formRegister (Editar paciente) -------------------//
    @RequestMapping(value = "/form/{id}")
    public String editAppointment(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

        Patient patient = null;

        if (id > 0) {
            patient = patientService.findOne(id);
            if (patient == null) {
                flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
            return "redirect:/listar";
        }
        model.addAttribute("patient", patient);
        model.addAttribute("tituloNav", "Clinica Tilin");
        model.addAttribute("tituloCard", "Formulario de cita - Editar");
        model.addAttribute("tituloSubCard", "Si desea concretar una cita de consulta con el Dr.Tilin, complete este " +
                              "formulario de cita y nos pondremos en contacto con usted lo antes posible. Si no recibe ninguna " +
                              "notificación este seguro que le dimos de baja del sistema y la policia lo estará buscando en este instante.");
        model.addAttribute("patient", patient);
        model.addAttribute("titulo", "Editar Cliente");
        return "formRegister";
    }

    // -------------------- Eliminacion de paciente desde formulario Listar ---------------------//
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            patientService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
        }
        return "redirect:/listado";
    }
}
