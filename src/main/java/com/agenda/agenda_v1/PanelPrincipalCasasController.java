/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.agenda.agenda_v1;

import static com.lowagie.text.xml.simpleparser.EntitiesToSymbol.map;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Nuria Calero Jiménez
 */
public class PanelPrincipalCasasController implements Initializable {

    @FXML
    private Pane panelAlumnos;
    @FXML
    private Pane panelMenuLateral;
    @FXML
    private ImageView _imagen_bandera;
    @FXML
    private ImageView _imgEScudo;
    @FXML
    private Pane panelSalaComun;
    @FXML
    private Pane panelAsignaturas;
    @FXML
    private Pane panelTareas;
    @FXML
    private Pane panelNotas;
    @FXML
    private Pane paneConfiguracion;
    @FXML
    private Pane paneAsignaturasIndividual;
    @FXML
    private Pane panelLog;
    @FXML
    private TextField labelUser;
    @FXML
    private PasswordField labelPass;
    @FXML
    private Pane panelRegistro;
    @FXML
    private ImageView imagenPulsaSombrero;
    @FXML
    private Label labelPulsaSombrero1;
    @FXML
    private Label labelPulsaSombrero2;
    @FXML
    private ImageView imagenNombreCasa;
    @FXML
    private Label label_casa_seleccion;
    @FXML
    private Pane panelProfesores;
    @FXML
    private Pane _panelMenuLateralProfe;
    @FXML
    private Pane _panelSalaComunProfes;
    @FXML
    private Pane _panelCursosProfes;
    @FXML
    private Pane _panelAsignaerTareasProfes;
    @FXML
    private Pane _panelCorreccionesProfes;
    @FXML
    private Label _tituloAsignatura;
    @FXML
    private Label _nombreProfesorAsignatura;
    @FXML
    private ImageView _imagenAsignatura;
    @FXML
    private ImageView _asignaturaPociones;
    @FXML
    private ImageView _asignaturaTransformaciones;
    @FXML
    private ImageView _asignaturaEncantamientos;
    @FXML
    private ImageView _asignaturaDefensa;
    @FXML
    private ImageView _asignaturaCriaturas;
    @FXML
    private ImageView _asignaturaHistoria;
    @FXML
    private ImageView _asignaturaVuelo;
    @FXML
    private ImageView _asignaturaRunas;
    @FXML
    private ImageView _asignaturaAdivinacion;
    @FXML
    private TextField _tfDocumentoSubir;
    @FXML
    private TextArea _tfComentario;
    @FXML
    private TextField _tfNombreEstudiante;
    @FXML
    private TextField _tfApellidosEstudiante;
    @FXML
    private TextField _tfEmailEstudiante;
    @FXML
    private TextField _tfDniEstudiante;
    @FXML
    private TextField _tfTelefonoEstudiante;
    @FXML
    private TextField _tfFechaNacEstudiante;
    @FXML
    private TextField _tfPassEstudiante;
    @FXML
    private Pane panelSelecionAsignatura;
    @FXML
    private ComboBox<String> _cbCursos;
    @FXML
    private CheckBox _checkPociones;
    @FXML
    private CheckBox _checkTransformaciones;
    @FXML
    private CheckBox _checkDefensa;
    @FXML
    private CheckBox _checkCriaturas;
    @FXML
    private CheckBox _checkEncantamientos;
    @FXML
    private CheckBox _checkRunas;
    @FXML
    private CheckBox _checkAdivinacion;
    @FXML
    private CheckBox _checkVuelo;
    @FXML
    private CheckBox _checkHistoria;
    @FXML
    private TableView<Alumnos_objeto> _tablaProfesor_cursos;
    @FXML
    private TableColumn<Alumnos_objeto, String> _columAlumno;
    @FXML
    private TableColumn<Alumnos_objeto, String> _columCasa;
    @FXML
    private TableColumn<Alumnos_objeto, String> _columCursos;
    @FXML
    private TableColumn<Alumnos_objeto, String> _columApellidos;
    private Label _labelSesionProfesor;
    @FXML
    private ComboBox<String> _cbTareas_cursos;
    @FXML
    private ComboBox<String> _cbTareas_alumnos;
    @FXML
    private TextArea _taTareas_descripcion;
    @FXML
    private TextField _tfNombreTarea;
    @FXML
    private TextArea _taTarea_destinatario;
    @FXML
    private ComboBox<String> _cbTareas_tipo;
    @FXML
    private ComboBox<String> _cbTarea_casa;
    @FXML
    private DatePicker _dpTareas_fechaIni;
    @FXML
    private DatePicker _dpTareas_fechaFin;
    @FXML
    private TableView<tareas_profesores_objeto> _tbTarea_correciones;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasCursos;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasTareas;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasFechaFin;
    @FXML
    private TextField _tfTareas_alumno;
    @FXML
    private TextField _tfTareasComentario;
    @FXML
    private TextField _tfTareasNota;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareaNombre;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasApellidos;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareaTipo;
    @FXML
    private TableView<tareas_alumnos_objeto> _tbA_tareas;
    @FXML
    private TableColumn<tareas_alumnos_objeto, String> _columA_tareaAsignatura;
    @FXML
    private TableColumn<tareas_alumnos_objeto, String> _columA_tareaTipo;
    @FXML
    private TableColumn<tareas_alumnos_objeto, String> _columA_tareaNombre;
    @FXML
    private TableColumn<tareas_alumnos_objeto, String> _columA_tareafecha_fin;
    @FXML
    private TableColumn<tareas_alumnos_objeto, String> _columA_tareaArchivo;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_tarea_nombre;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_tarea_apellidos;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_tarea_cursos;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_tarea_tareas;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_tarea_tipo;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_tarea_fecha;
    @FXML
    private TableView<tareas_profesores_objeto> _tbprofesores_semanal;
    @FXML
    private Pane _panelAsistencia;
    @FXML
    private Pane _panelAdministadorAlumnos;
    @FXML
    private Pane _panelAdministrador_profesor;
    @FXML
    private Pane _panelAdministradorConfiguracion;
    @FXML
    private TableColumn<Alumnos_objeto, String> _columP_nombre;
    @FXML
    private TableColumn<Alumnos_objeto, String> _columP_apellidos;
    @FXML
    private ComboBox<String> _comboP_AsistenciaCursos;
    @FXML
    private ComboBox<String> _comboP_AsistenciaCasa;
    @FXML
    private TableView<Alumnos_asistencia_objeto> _tablaP_asistencia;
    private static List<String> valoresLista = new ArrayList<>();
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columP_dni;
    @FXML
    private TableView<tareas_profesores_objeto> _tbTarea_correciones_pendientes;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareaNombrePendientes;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasApellidosPendientes;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasCursosPendientes;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasTareasPendientes;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareaTipoPendientes;
    @FXML
    private TableColumn<tareas_profesores_objeto, String> _columTareasFechaFinPendientes;
    @FXML
    private TableColumn<tareas_alumnoConProfesor_objeto, String> _columAluSema_asignatura;
    @FXML
    private TableColumn<tareas_alumnoConProfesor_objeto, String> _columAluSema_profesor;
    @FXML
    private TableColumn<tareas_alumnoConProfesor_objeto, String> _columAluSema_tareas;
    @FXML
    private TableColumn<tareas_alumnoConProfesor_objeto, String> _columAluSema_tipo;
    @FXML
    private TableColumn<tareas_alumnoConProfesor_objeto, String> _columAluSema_fecha;
    @FXML
    private TableView<tareas_alumnoConProfesor_objeto> _tablaAlum_salaComun;
    @FXML
    private TableView<notas_objeto> _tablaAlu_notas;
    @FXML
    private TableColumn<notas_objeto, String> _columAlu_notas_asignatura;
    @FXML
    private TableColumn<notas_objeto, String> _columAlu_notas_tipo;
    @FXML
    private TableColumn<notas_objeto, String> _columAlu_notas_nombre;
    @FXML
    private TableColumn<notas_objeto, String> _columAlu_notas_nota;
    @FXML
    private TableColumn<notas_objeto, String> _columAlu_notas;
    @FXML
    private ComboBox<?> _jcFilto_notas_alumno;
    @FXML
    private ImageView _imagNotas1;
    @FXML
    private Label _labelNotas1;
    @FXML
    private ImageView _imagNotas2;
    @FXML
    private Label _labelNotas5;
    @FXML
    private ImageView _imagNotas3;
    @FXML
    private Label _labelNotas2;
    @FXML
    private ImageView _imagNotas4;
    @FXML
    private Label _labelNotas4;
    @FXML
    private ImageView _imagNotas5;
    @FXML
    private Label _labelNotas3;
    @FXML
    private Label _labelNotas6;
    @FXML
    private ImageView _imagNotas6;

    @FXML
    private Pane _panelHistorialAsistencia;
    @FXML
    private TableView<Alumnos_asistencia_objeto> _tablaP_asistencia1;
    @FXML
    private TableColumn<Alumnos_asistencia_objeto, String> _columP_nombre1;
    @FXML
    private TableColumn<Alumnos_asistencia_objeto, String> _columP_apellidos1;
    @FXML
    private TableColumn<Alumnos_asistencia_objeto, String> _columP_dni1;
    @FXML
    private TableColumn<Alumnos_asistencia_objeto, String> columP_asistencia21;
    @FXML
    private ComboBox<String> _comboP_AsistenciaCursos1;
    @FXML
    private ComboBox<String> _comboP_AsistenciaCasa1;
    @FXML
    private ImageView _fenixProfesores;
    @FXML
    private Button _boton_sala_comun;
    @FXML
    private Button _boton_asignaturas;
    @FXML
    private Button _boton_tareas;
    @FXML
    private Button _boton_notas;
    @FXML
    private Button botonSalirAlumno;
    @FXML
    private Button botonSalirAlumno1;
    @FXML
    private Button _boton_sala_comun1;
    @FXML
    private ImageView _asignaturaPociones11;
    @FXML
    private ImageView _asignaturaTransformaciones11;
    @FXML
    private ImageView _asignaturaEncantamientos11;
    @FXML
    private ImageView _asignaturaDefensa11;
    @FXML
    private ImageView _asignaturaCriaturas11;
    @FXML
    private ImageView _asignaturaHistoria11;
    @FXML
    private ImageView _asignaturaVuelo11;
    @FXML
    private ImageView _asignaturaRunas11;
    @FXML
    private ImageView _asignaturaAdivinacion11;
    @FXML
    private ImageView jlabelEntrarLogin;
    @FXML
    private Label jlabelRegistro;
    @FXML
    private ImageView botonRegistro;
    @FXML
    private Label jlabelSalir;
    @FXML
    private ImageView botonSombrero;
    @FXML
    private ImageView botonIrHogwarts;
    @FXML
    private ImageView _imagen_banderaProfes;
    @FXML
    private ImageView _imgEScudoProfes;
    @FXML
    private Button _boton_sala_comun_Profes;
    @FXML
    private Button _boton_Cursos_Profes;
    @FXML
    private Button _boton_tareas_Profes;
    @FXML
    private Button _boton_Alumnos_Profes;
    @FXML
    private Button _botonSalirProfes;
    @FXML
    private Button botonSalirAlumno11;
    @FXML
    private ImageView _iconPergamino;
    @FXML
    private ImageView _iconTemario;
    @FXML
    private Pane _paneMensajeria;
    @FXML
    private Tab tab_pane_novedades;
    @FXML
    private ComboBox<?> combo_mensajeria_alumnos;
    @FXML
    private TextArea textArea_menaje_editar;
    @FXML
    private Tab tab_pane_historico;
    @FXML
    private TableView<mensajeria_objeto> tablaP_listar_mensajes;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_apellidos_mensajeria;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_curso_mensajeria;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_fecha_mensajeria;
    @FXML
    private TableColumn<mensajeria_objeto, Boolean> columP_leidos_mensajeria;
    @FXML
    private TextArea textarea_mensajeria;
    @FXML
    private Pane panelAdministrador;
    @FXML
    private Pane panelTareas11;
    @FXML
    private Label label_titulo11;
    @FXML
    private Pane panelMenuLateral1;
    @FXML
    private ImageView _imagen_bandera1;
    @FXML
    private Button _boton_alumnos_administrador;
    @FXML
    private Button _boton_profesores_administrador;
    @FXML
    private Button _boton_cerrar_sesion;
    @FXML
    private Button _boton_salir;
    @FXML
    private TextField _tfNombreEstudiante11;
    @FXML
    private TextField _tfApellidosEstudiante11;
    @FXML
    private TextField _tfEmailEstudiante11;
    @FXML
    private TextField _tfDniEstudiante11;
    @FXML
    private TextField _tfTelefonoEstudiante11;
    @FXML
    private TextField _tfFechaNacEstudiante11;
    @FXML
    private Button _boton_sala_comun111;
    @FXML
    private TextField _tfPassEstudiante11;

    @FXML
    private TextField _tfNombreEstudiante1;
    @FXML
    private TextField _tfApellidosEstudiante1;
    @FXML
    private TextField _tfEmailEstudiante1;
    @FXML
    private TextField _tfDniEstudiante1;
    @FXML
    private TextField _tfTelefonoEstudiante1;
    @FXML
    private TextField _tfFechaNacEstudiante1;
    @FXML
    private Button _boton_sala_comun11;
    @FXML
    private ComboBox<String> _cbCursos1;
    @FXML
    private ImageView imagen_texto_asignatura;
    @FXML
    private Text pruebaInicio;
    @FXML
    private ImageView _imagen_perfil;
    @FXML
    private Button _botonA_cambiar_Perfil;
    @FXML
    private ImageView abrir_mensajeria_alumnos;
    @FXML
    private Pane _panelMensajeria_alumnos;
    @FXML
    private Tab tab_pane_novedades1;
    @FXML
    private ComboBox<?> combo_mensajeria_alumnos1;
    @FXML
    private TextArea textArea_menaje_editar1;
    @FXML
    private Tab tab_pane_historico1;

    private TableColumn<mensajeria_objeto, String> columP_dni_mensajeria1;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_apellidos_mensajeria1;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_fecha_mensajeria1;
    @FXML
    private TableColumn<mensajeria_objeto, Boolean> columP_leidos_mensajeria1;
    @FXML
    private TextArea textarea_mensajeria1;
    @FXML
    private Label label_mensaje_alumnos;
    @FXML
    private Button boton_mostrarMensaje_alumnos;
    @FXML
    private Button boton_cerrar;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_nombre_mensajeria1;
    @FXML
    private TableView<mensajeria_objeto> tablaA_listar_mensajes1;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_Id_mensajeria1;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_id_mensajeria;
    @FXML
    private Button botonP_mostar_mensaje;
    @FXML
    private Button botonP_cerrar_mensaje;
    @FXML
    private Label label_mensajeP;
    @FXML
    private TableColumn<mensajeria_objeto, String> columP_nombre_mensajeria;
    @FXML
    private ImageView imagen_recordadoraA;
    @FXML
    private ImageView imagen_recordadora;
    @FXML
    private Button boton_guardarMensajeriaP;
    @FXML
    private TableColumn<tareas_alumnos_objeto, String> _columA_tareaId;
    @FXML
    private Button botonA_enviar_mensajeria;
    @FXML
    private Label labelA_mensajeria;
    @FXML
    private Label labelA_sala_comun;
    @FXML
    private Label labelA_asisgnaturas;
    @FXML
    private Label labelA_posiciones;
    @FXML
    private Label labelA_transformaciones;
    @FXML
    private Label labelA_encantamientos;
    @FXML
    private Label labelA_defensa1;
    @FXML
    private Label labelA_defensa2;
    @FXML
    private Label labelA_cuidado1;
    @FXML
    private Label labelA_cuidado2;
    @FXML
    private Label labelA_historia1;
    @FXML
    private Label labelA_historia2;
    @FXML
    private Label labelA_vuelo;
    @FXML
    private Label labelA_runas;
    @FXML
    private Label labelA_adivinacion;
    @FXML
    private Label labelA_tareas;
    @FXML
    private Label labelA_subirDocumento;
    @FXML
    private Label labelA_comentario;
    @FXML
    private Label labelA_notas;
    @FXML
    private Label labelA_seleccionaAsignatura;
    @FXML
    private Label labelA_configuracion;
    @FXML
    private Label labelA_nombre;
    @FXML
    private Label labelA_dni;
    @FXML
    private Label labelA_curso;
    @FXML
    private Label labelA_apellidos;
    @FXML
    private Label labelA_email;
    @FXML
    private Label labelA_telefono;
    @FXML
    private Label labelA_fecha;
    @FXML
    private Label labelA_pass;
    @FXML
    private Label labelA_profesor;
    @FXML
    private Label labelA_selecionAsignaturas;
    @FXML
    private Label labelA_seleccionPociones;
    @FXML
    private Label labelA_seleccionTransformaciones;
    @FXML
    private Label labelA_seleccionEncantamientos;
    @FXML
    private Label labelA_seleccionDefensa1;
    @FXML
    private Label labelA_seleccionDefensa2;
    @FXML
    private Label labelA_seleccionCuidado1;
    @FXML
    private Label labelA_seleccionCuidado2;
    @FXML
    private Label labelA_seleccionHistoria1;
    @FXML
    private Label labelA_seleccionHistoria2;
    @FXML
    private Label labelA_seleccionVuelo;
    @FXML
    private Label labelA_seleccionRunas;
    @FXML
    private Label labelA_seleccionAdivinacion;
    @FXML
    private Label labelP_planing;
    @FXML
    private Label labelP_asistencia;
    @FXML
    private Label labelP_mensajeria;
    @FXML
    private Label labelP_historial;
    @FXML
    private Label labelP_cursosAsisgnados;
    @FXML
    private Label labelP_tareas_nombre;
    @FXML
    private Label labelP_tareas_cursos;
    @FXML
    private Label labelP_tareas_alumnos;
    @FXML
    private Label labelP_tareas_descripcion;
    @FXML
    private Label labelP_tareas_fecha;
    @FXML
    private Label labelP_asignarTareas;
    @FXML
    private Label labelP_tareas_destinatarios;
    @FXML
    private Label labelP_tareas_tipo;
    @FXML
    private Label labelP_tareas_casa;
    @FXML
    private Label labelP_tareas_fecha_entrega;
    @FXML
    private Label labelP_correciones;
    @FXML
    private Label labelP_correciones_alumno;
    @FXML
    private Label labelP_correciones_comentario;
    @FXML
    private Label labelP_correciones_nota;
    @FXML
    private Label labelP_asistenciaAlumnos;
    @FXML
    private Label labelP_asistencia_curso;
    @FXML
    private Label labelP_asistencia_casa;
    @FXML
    private Label labelA_planing;
    @FXML
    private Label labelA_trimestre;
    @FXML
    private Label labelA_configura;
    @FXML
    private Label labelA_mensa;

    @FXML
    private Button boton_mas;
    @FXML
    private TableColumn<?, ?> _columTareaId;
    @FXML
    private TableColumn<?, ?> _columTareaIdPendientes;
    @FXML
    private ProgressBar _progressBar_Trimestre;
    @FXML
    private Button boton_guardarComentario;
    @FXML
    private Label _labelSesionEstudiante1;
    @FXML
    private Button boton_enviar_tareas;
    @FXML
    private Button botonP_presente;
    @FXML
    private Button botonP_ausente;
    @FXML
    private Button botonP_restrasado;
    @FXML
    private Label label_asistencia_botones;
    @FXML
    private TableColumn<Alumnos_asistencia_objeto, String> columP_asistencia_fecha;
    @FXML
    private ImageView _imagenFondoAdmin;
    @FXML
    private Label labelAd_nombre;
    @FXML
    private Label labelAd_dni;
    @FXML
    private Label labelAd_curso;
    @FXML
    private Label labelAd_apellidos;
    @FXML
    private Label labelAd_email;
    @FXML
    private Label labelAd_telefono;
    @FXML
    private Label labelAd_fechNac;

    @FXML
    private TableColumn<Alumnos_objeto, String> columAD_dni;
    @FXML
    private Button botonAD_modificar;
    @FXML
    private Button botonAD_eliminar;
    @FXML
    private TableView<Alumnos_objeto> tablaAd_alumnos;
    @FXML
    private TableColumn<Alumnos_objeto, String> columAD_nombre;
    @FXML
    private TableColumn<Alumnos_objeto, String> columAD_apellidos;
    @FXML
    private TableColumn<Alumnos_objeto, String> columAD_casa;
    @FXML
    private TableColumn<Alumnos_objeto, String> columAD_curso;
    @FXML
    private Label labelAdministadorTabla;
    @FXML
    private TableView<Profesores_objeto> tablaAd_alumnos1;
    @FXML
    private TableColumn<Profesores_objeto, String> columAD_dni1;
    @FXML
    private TableColumn<Profesores_objeto, String> columAD_nombre1;
    @FXML
    private TableColumn<Profesores_objeto, String> columAD_apellidos1;
    @FXML
    private TableColumn<Profesores_objeto, String> columAD_casa1;
    @FXML
    private TableColumn<Profesores_objeto, String> columAD_curso1;
    @FXML
    private Button botonAD_eliminarP;
    @FXML
    private Button botonAD_ModificarP;
    @FXML
    private Button botonP_correciones;
    @FXML
    private Tab tabProfesores_todas;
    @FXML
    private Tab tabProfesores_pendientes;
    @FXML
    private Label label_salaComun_profesores;
    @FXML
    private Button botonP_mas;
    @FXML
    private Label labelP_mensajeria_titulo;
    @FXML
    private Label labelAD_configuracionTitulo;
    @FXML
    private Label labelAD_configuracionTitulo2;
    @FXML
    private Button _boton_informe_asignatura;
    @FXML
    private Button _boton_menu_informes;
    @FXML
    private Pane _panelInformes;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        vaciarPanelTodo();
        panelLog.setVisible(true);
        connect();
        progressBar();
        controlcheck();

        _tbTarea_correciones.setOnMouseClicked((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se haga clic en el ratón
            comprobar();
        });

        _tbTarea_correciones_pendientes.setOnMouseClicked((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se haga clic en el ratón
            comprobar();
        });

        labelUser.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                abrirCasaLogin();
            }
        });
        labelPass.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                abrirCasaLogin();
            }

        });
        imagen_recordadora.setVisible(false);
        imagen_recordadoraA.setVisible(false);

//================================css menus laterales================================================
        _boton_sala_comun.getStyleClass().add("CssLateral");
        _boton_asignaturas.getStyleClass().add("CssLateral");
        _boton_tareas.getStyleClass().add("CssLateral");
        _boton_notas.getStyleClass().add("CssLateral");

        // BOTONES "CERRAR SESION" Y "CERRAR" MENU LATERAL
        botonSalirAlumno1.getStyleClass().add("CssSalir");
        botonSalirAlumno.getStyleClass().add("CssSalir");

//============================ALUMNOS=============================================================================================
        //================= TITULO label principal gradian =====================
        labelA_mensajeria.getStyleClass().add("CssLabelPrincipal");

        labelA_sala_comun.getStyleClass().add("CssLabelPrincipal");
        labelA_asisgnaturas.getStyleClass().add("CssLabelPrincipal");
        labelA_tareas.getStyleClass().add("CssLabelPrincipal");
        labelA_notas.getStyleClass().add("CssLabelPrincipal");
        labelA_configuracion.getStyleClass().add("CssLabelPrincipal");

        //================planin alunnos sala comun=============================
        labelA_planing.getStyleClass().add("CssLabelPlaning");
        //==================sala comun alumnos==================================
        labelA_trimestre.getStyleClass().add("CssSalacomun");
        labelA_mensa.getStyleClass().add("CssSalacomun");
        labelA_configura.getStyleClass().add("CssSalacomun");
//====================label asisgnaturas gradian======================
        labelA_posiciones.getStyleClass().add("CssAsignaturas");
        labelA_transformaciones.getStyleClass().add("CssAsignaturas");
        labelA_encantamientos.getStyleClass().add("CssAsignaturas");
        labelA_defensa1.getStyleClass().add("CssAsignaturas");
        labelA_defensa2.getStyleClass().add("CssAsignaturas");
        labelA_cuidado1.getStyleClass().add("CssAsignaturas");
        labelA_cuidado2.getStyleClass().add("CssAsignaturas");
        labelA_historia1.getStyleClass().add("CssAsignaturas");
        labelA_historia2.getStyleClass().add("CssAsignaturas");
        labelA_vuelo.getStyleClass().add("CssAsignaturas");
        labelA_runas.getStyleClass().add("CssAsignaturas");
        labelA_adivinacion.getStyleClass().add("CssAsignaturas");
        _tituloAsignatura.getStyleClass().add("CssLabelTransformaciones");

        //======================panel asignatura con imagen ====================
        labelA_profesor.getStyleClass().add("CssAsignaturasImagen");
        _nombreProfesorAsignatura.getStyleClass().add("CssAsignaturasImagen");
        //==============panel TAREAS========================================
        labelA_subirDocumento.getStyleClass().add("CsslabelPanelTareas");
        labelA_comentario.getStyleClass().add("CsslabelPanelTareas");
        //============guardar cambios Tareas=======================
        boton_guardarComentario.getStyleClass().add("CssguardarCambiosTareas");
        //========================panel NOTAS=======================
        labelA_seleccionaAsignatura.getStyleClass().add("CsslabelPanelNotas");
        _labelNotas1.getStyleClass().add("CsslabelPanelNotas");
        _labelNotas2.getStyleClass().add("CsslabelPanelNotas");
        _labelNotas3.getStyleClass().add("CsslabelPanelNotas");
        _labelNotas4.getStyleClass().add("CsslabelPanelNotas");
        _labelNotas5.getStyleClass().add("CsslabelPanelNotas");
        _labelNotas6.getStyleClass().add("CsslabelPanelNotas");
        //=========================Panel Configuracion========================0
        labelA_nombre.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_dni.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_curso.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_apellidos.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_telefono.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_email.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_fecha.getStyleClass().add("CsslabelPanelconfiguracion");
        labelA_pass.getStyleClass().add("CsslabelPanelconfiguracion");
        //=======================Panel seleccion asignaturas====================
        labelA_seleccionPociones.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionTransformaciones.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionEncantamientos.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionDefensa1.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionDefensa2.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionCuidado1.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionCuidado2.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionHistoria1.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionHistoria2.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionVuelo.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionRunas.getStyleClass().add("CsslabelSeleccionAsignaturas");
        labelA_seleccionAdivinacion.getStyleClass().add("CsslabelSeleccionAsignaturas");

        //================================boton ================================
        boton_mas.getStyleClass().add("cssmas");
//        botonA_enviar_mensajeria.setEffect(null);
        botonA_enviar_mensajeria.getStyleClass().add("CssMensajeria");
        _boton_sala_comun1.getStyleClass().add("CssGuardarConfiguracion");
        _botonA_cambiar_Perfil.getStyleClass().add("CsscambiarImagenConfiguracion");

        //=============================PROFESORES===============================
        // menu lateral
        _boton_sala_comun_Profes.getStyleClass().add("CssLateral");
        _boton_Cursos_Profes.getStyleClass().add("CssLateral");
        _boton_tareas_Profes.getStyleClass().add("CssLateral");
        _boton_Alumnos_Profes.getStyleClass().add("CssLateral");
        //cerrar sesion y salir
        _botonSalirProfes.getStyleClass().add("CssSalir");
        botonSalirAlumno11.getStyleClass().add("CssSalir");

        // titulo principal gradian
        labelP_cursosAsisgnados.getStyleClass().add("CssLabelPrincipalProfesores");
        labelA_selecionAsignaturas.getStyleClass().add("CssLabelPrincipalProfesores");
        labelP_asignarTareas.getStyleClass().add("CssLabelPrincipalProfesores");
        labelP_correciones.getStyleClass().add("CssLabelPrincipalProfesores");
        labelP_asistenciaAlumnos.getStyleClass().add("CssLabelPrincipalProfesores");
        labelP_mensajeria_titulo.getStyleClass().add("CssLabelPrincipalProfesores");
        label_salaComun_profesores.getStyleClass().add("CssLabelPrincipalProfesores");

        //planing===================================================
        labelP_planing.getStyleClass().add("CssLabelPlaningProfesores");
        //==============sala comun profesores================
        labelP_asistencia.getStyleClass().add("CssSalacomunProfesores");
        labelP_mensajeria.getStyleClass().add("CssSalacomunProfesores");
        labelP_historial.getStyleClass().add("CssSalacomunProfesores");
        //==============panel tareas profesores==========================
        labelP_tareas_nombre.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_cursos.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_alumnos.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_descripcion.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_fecha.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_destinatarios.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_tipo.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_casa.getStyleClass().add("CssPanelTareasProfesores");
        labelP_tareas_fecha_entrega.getStyleClass().add("CssPanelTareasProfesores");
        //===============panel correciones profesores============
        labelP_correciones_comentario.getStyleClass().add("CsspanelCorrecionesProfesores");
        labelP_correciones_alumno.getStyleClass().add("CsspanelCorrecionesProfesores");
        labelP_correciones_nota.getStyleClass().add("CsspanelCorrecionesProfesores");
        //===============panel asistencia profesores==========================
        labelP_asistencia_curso.getStyleClass().add("CsspanelAsistenciaProfesores");
        labelP_asistencia_casa.getStyleClass().add("CsspanelAsistenciaProfesores");
        //========================progrees bar==========================================
        _progressBar_Trimestre.getStyleClass().add("Cssbar");
        _tbA_tareas.getStyleClass().add("CssTablaSalaComun");
        //botones asistencia
        botonP_presente.getStyleClass().add("CssBotonAsistencia");
        botonP_ausente.getStyleClass().add("CssBotonAsistencia");
        botonP_restrasado.getStyleClass().add("CssBotonAsistencia");
        //Botones guardar
        botonP_correciones.getStyleClass().add("CssBotonGuardar");
        boton_enviar_tareas.getStyleClass().add("CssBotonGuardar");
        boton_guardarMensajeriaP.getStyleClass().add("CssBotonGuardar");
        // botones mensajeria
        botonP_mostar_mensaje.getStyleClass().add("CssBotonesMensaje");
        botonP_cerrar_mensaje.getStyleClass().add("CssBotonesMensaje");
        // boton mas
        botonP_mas.getStyleClass().add("cssmas");
        // combos
        _comboP_AsistenciaCursos1.getStyleClass().add("csscombo");
        _comboP_AsistenciaCasa1.getStyleClass().add("csscombo");

        //=================ADMINISTRADOR=======================================
        labelAd_nombre.getStyleClass().add("CsslabelconfiguracionAD");
        labelAd_apellidos.getStyleClass().add("CsslabelconfiguracionAD");
        labelAd_dni.getStyleClass().add("CsslabelconfiguracionAD");
        labelAd_email.getStyleClass().add("CsslabelconfiguracionAD");
        labelAd_fechNac.getStyleClass().add("CsslabelconfiguracionAD");
        labelAd_curso.getStyleClass().add("CsslabelconfiguracionAD");
        labelAd_telefono.getStyleClass().add("CsslabelconfiguracionAD");
        //botones menu lateral
        _boton_alumnos_administrador.getStyleClass().add("CssMenuLateral");
        _boton_profesores_administrador.getStyleClass().add("CssMenuLateral");
        _boton_cerrar_sesion.getStyleClass().add("CssMenuLateral");
        _boton_salir.getStyleClass().add("CssMenuLateral");

        //label titulos
        labelAdministadorTabla.getStyleClass().add("Csslabeltitulo");
        //medianos
        labelAD_configuracionTitulo.getStyleClass().add("CsslabeltituloMediano");
        labelAD_configuracionTitulo2.getStyleClass().add("CsslabeltituloMediano");

        //===============botones================================================
        _boton_sala_comun11.getStyleClass().add("CssbotonGrande");
        _boton_sala_comun111.getStyleClass().add("CssbotonGrande");
        //botones medianos
        botonAD_eliminar.getStyleClass().add("Cssboton");
        botonAD_modificar.getStyleClass().add("Cssboton");
        botonAD_eliminarP.getStyleClass().add("Cssboton");
        botonAD_ModificarP.getStyleClass().add("Cssboton");
        botonP_correciones.getStyleClass().add("Cssboton");

    }//fin inicializate

    //==============================UTILIDADES==================================
    //==========================================================================
    /**
     * Intenta conectar con la base de datos.
     *
     * @return true si pudo conectarse, false en caso contrario
     */
    public static boolean connect() {
        try {
            //System.out.print("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    ////////////////CONEXION///////////////////
    /////////////////////////////////////////////////////////////////////////////////
    // Conexión a la base de datos
    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "servidor.choto.es";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "alu_nurismy_agenda";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + ""
            + "?serverTimezone=UTC";
    private static final String DB_USER = "unalumno";
    private static final String DB_PASS = "soyunalumno2022";

    ////////////////////////////CERRAR SESIÓN///////////////////////////////////
    @FXML
    private void cerrarSesion(MouseEvent event) {

        App.cerrarSesion();

    }

    public void borrarTodo() {
        _cbCursos.getItems().clear();
        _cbTarea_casa.getItems().clear();
        _cbTareas_alumnos.getItems().clear();
        _cbTareas_tipo.getItems().clear();
        _cbTareas_cursos.getItems().clear();
        _tfApellidosEstudiante.setText("");
        _tfComentario.setText("");
        _tfDniEstudiante.setText("");
        _tfDocumentoSubir.setText("");
        _tfEmailEstudiante.setText("");
        _tfFechaNacEstudiante.setText("");
        _tfNombreEstudiante.setText("");
        _tfNombreTarea.setText("");
        _tfPassEstudiante.setText("");
        _tfTelefonoEstudiante.setText("");
        _checkAdivinacion.setSelected(false);
        _checkCriaturas.setSelected(false);
        _checkDefensa.setSelected(false);
        _checkEncantamientos.setSelected(false);
        _checkHistoria.setSelected(false);
        _checkPociones.setSelected(false);
        _checkRunas.setSelected(false);
        _checkTransformaciones.setSelected(false);
        _checkVuelo.setSelected(false);
        _taTarea_destinatario.setText("");
        _taTareas_descripcion.setText("");
        pruebaInicio.setText("");
        _labelSesionProfesor.setText("");

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void salirProg() {
        System.exit(0);
    }

    @FXML
    private void cerrarTodo(ActionEvent event) {
        System.exit(0);
    }

    ////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    //MÉTODO PARA VACIAR PANELES//
    public void vaciarPanelTodo() {

        panelAsignaturas.setVisible(false);
        panelNotas.setVisible(false);
        panelTareas.setVisible(false);
        panelSalaComun.setVisible(false);
        paneAsignaturasIndividual.setVisible(false);
        panelAlumnos.setVisible(false);
        panelLog.setVisible(false);
        panelProfesores.setVisible(false);
        panelRegistro.setVisible(false);
        paneConfiguracion.setVisible(false);
        panelSelecionAsignatura.setVisible(false);
        paneConfiguracion.setVisible(false);
        _panelCorreccionesProfes.setVisible(false);
        _panelCursosProfes.setVisible(false);
        _panelSalaComunProfes.setVisible(false);
        _panelAsignaerTareasProfes.setVisible(false);
        _panelAsistencia.setVisible(false);
        _paneMensajeria.setVisible(false);
        _panelAdministadorAlumnos.setVisible(false);
        _panelAdministradorConfiguracion.setVisible(false);
        _panelAdministrador_profesor.setVisible(false);
        _panelHistorialAsistencia.setVisible(false);
        imagen_texto_asignatura.setVisible(false);
        _panelMensajeria_alumnos.setVisible(false);
        _paneMensajeria.setVisible(false);
        _imagenFondoAdmin.setVisible(false);
        panelAdministrador.setVisible(false);
        panelMenuLateral1.setVisible(false);
        panelAlumnos.setVisible(false);
        panelProfesores.setVisible(false);
        _panelAdministadorAlumnos.setVisible(false);
        panelTareas11.setVisible(false);
        panelMenuLateral1.setVisible(false);

    }

    public void vaciarPanelProfes() {

        _panelCorreccionesProfes.setVisible(false);
        _panelCursosProfes.setVisible(false);
        _panelSalaComunProfes.setVisible(false);
        _panelAsignaerTareasProfes.setVisible(false);
        _panelAsistencia.setVisible(false);
        _panelHistorialAsistencia.setVisible(false);
        _panelMensajeria_alumnos.setVisible(false);
        _paneMensajeria.setVisible(false);

    }

    public void panepressed(MouseEvent me) {
        Stage a = (Stage) ((Node) me.getSource()).getScene().getWindow();
        Delta.x = a.getX() - me.getScreenX();
        Delta.y = a.getY() - me.getScreenY();

    }

    public void panedraged(MouseEvent me) {
        Stage b = (Stage) ((Node) me.getSource()).getScene().getWindow();
        b.setX(Delta.x + me.getScreenX());
        b.setY(Delta.y + me.getScreenY());

    }

    //========Metodo para las alertas=============================
    /**
     *
     * @param mensaje el mensaje de Alert
     * @param titulo titulo del mensaje Alert
     */
    public void Jopane(String mensaje, String titulo) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.show();

    }

    public static void transaccion(String sql) {
        try {

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            conn.setAutoCommit(false); ////// ----->> Desactivamos auto commit

            Statement st = conn.createStatement();

            // Crear un registro de envíos si se cumple una determinada condición
            if (st.executeUpdate(sql) != 0) {
                //JOptionPane.showMessageDialog(null, "Transacción Correcta");
                conn.commit();  ///// ---->> reflejar las operaciones en la base de datos

            } else {
                //JOptionPane.showMessageDialog(null, "Error, desacemos los cambios");
                conn.rollback(); ///// -----> Deshacer operaciones
            }
        } catch (SQLException e) {  //Si se produce una Excepción deshacemos las operaciones

            if (conn != null) {
                try {
                    //JOptionPane.showMessageDialog(null, "Error, desacemos los cambios");
                    conn.rollback();///// -----> Deshacer operaciones
                } catch (SQLException ex) {
                    //JOptionPane.showMessageDialog(null, "Error, desacemos los cambios");
                }
            }

        }
    }

    //========================Métodos Inicio Sesión=============================
    //==========================================================================
    @FXML
    public void abrirCasaLogin() {
        try {
            String dni = labelUser.getText();
            String pass = labelPass.getText();
            String casa = comprobarInicioSesionEstudiantes(dni, pass);
            int id_estudiante = obtner_id_estudiante(dni);
            System.out.println(id_estudiante);
            System.out.println(casa);

            switch (casa) {

                case "GRYFFINDOR":
                    cambiarImagenGr();
                    paneConfiguracion.setVisible(false);
                    rellenar_tareas_alumnos_semanal(id_estudiante);
                    panelSalaComun.setVisible(true);
                    pruebaInicio.setText(dni);
                    Cambiar_recordadoraAlumnos(id_estudiante);
                    filtras_notas_asignatura(id_estudiante);
                    break;
                case "SLYTHERIN":
                    cambiarImagenSl();
                    paneConfiguracion.setVisible(false);
                    panelSalaComun.setVisible(true);
                    pruebaInicio.setText(dni);
                    Cambiar_recordadoraAlumnos(id_estudiante);
                    filtras_notas_asignatura(id_estudiante);
                    rellenar_tareas_alumnos_semanal(id_estudiante);
                    break;
                case "HAFFLEPUFF":
                    cambiarImagenHu();
                    paneConfiguracion.setVisible(false);
                    panelSalaComun.setVisible(true);
                    pruebaInicio.setText(dni);
                    Cambiar_recordadoraAlumnos(id_estudiante);
                    filtras_notas_asignatura(id_estudiante);
                    rellenar_tareas_alumnos_semanal(id_estudiante);
                    break;
                case "RAVENCLAW":
                    cambiarImagenRa();
                    paneConfiguracion.setVisible(false);
                    panelSalaComun.setVisible(true);
                    pruebaInicio.setText(dni);
                    Cambiar_recordadoraAlumnos(id_estudiante);
                    filtras_notas_asignatura(id_estudiante);
                    rellenar_tareas_alumnos_semanal(id_estudiante);
                    break;
                case "profesor":
                    int id_profesor = obtener_id_profesor(dni);
                    cambiarImagenProfe();
                    int id_asigprof = obtener_id_asigProf_por_idProfesor(id_profesor);
                    Cambiar_recordadoraAlumnos(id_profesor);
                    rellenar_tablaProfesor_semanal(id_profesor);
                    filtrar_alumnos_asistencia_curso(id_asigprof);
                    filtrar_alumnos_asistencia_casa(id_asigprof);
                    filtrar_alumnos_asistencia_curso_historial(id_asigprof);
                    filtrar_alumnos_asistencia_casa_historial(id_asigprof);
                    solo_combo_casa();
                    solo_combo_curos();
                    break;
                case "admin":
                    cambiarImagenAdmin();
                    _imagenFondoAdmin.setVisible(true);
                    panelMenuLateral1.setVisible(true);
                    panelAlumnos.setVisible(false);
                    panelProfesores.setVisible(false);
                    _panelAdministadorAlumnos.setVisible(false);
                    panelTareas11.setVisible(false);
                    panelMenuLateral1.setVisible(true);

            }
        } catch (NullPointerException e) {

        }

    }

    public String comprobarInicioSesionEstudiantes(String dni, String pass) {

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE dni =? AND pass =?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, dni);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.first()) {
                String casa = rs.getString("casa");
                return casa;

            } else {
                PreparedStatement pst2 = conn.prepareStatement("SELECT * FROM profesores WHERE dni =?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pst2.setString(1, dni);
                ResultSet rs2 = pst2.executeQuery();

                if (!rs2.first()) {
                    Jopane("No existe ningún usuario con los datos introducidos", "Error Login");
                    return null;
                } else {
                    dni = rs2.getString("dni");
                    if (dni.equals("admin")) {
                        return "admin";
                    } else {
                        pruebaInicio.setText(dni);
                        return "profesor";
                    }

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //============MÉTODOS PARA CAMBIAR APARIENCIA SEGÚN CASA====================
    //==========================================================================
    public void cambiarImagenAdmin() {
        Window win = App.getScene().getWindow();
        win.setWidth(1040);
        win.setHeight(690);
        vaciarPanelProfes();
        vaciarPanelTodo();
        panelAdministrador.setVisible(true);
        panelAdministrador.getStylesheets().add("/css/CssAdmin.css");

    }

    public void cambiarImagenSl() {
        Window win = App.getScene().getWindow();
        win.setWidth(1040);
        win.setHeight(690);
        Image image1 = new Image(getClass().getResourceAsStream("/img/escudos/verde.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/img/casas/banderaVerde.png"));
        //panelMenuLateral.getChildren().add(imageView1);//para coger nodo hijo y añadir nueva imagen
        _imgEScudo.setImage(image1);
        _imagen_bandera.setImage(image2);
        win.getScene().getStylesheets().clear();
        panelMenuLateral.getStylesheets().clear();
        panelMenuLateral.getStylesheets().add("/css/CssVerde.css");
        panelAlumnos.getStylesheets().clear();
        panelAlumnos.getStylesheets().add("/css/CssbotonYlabelVerde.css");

        //panelAlumnos.getStylesheets().add("/css/prueba.css");
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        paneConfiguracion.setVisible(true);

    }

    public void cambiarImagenGr() {
        Window win = App.getScene().getWindow();
        win.setWidth(1040);
        win.setHeight(690);
        Image image1 = new Image(getClass().getResourceAsStream("/img/escudos/rojo.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/img/casas/banderaRoja.png"));
        //panelMenuLateral.getChildren().add(imageView1);//para coger nodo hijo y añadir nueva imagen
        _imgEScudo.setImage(image1);
        _imagen_bandera.setImage(image2);
        //solo csss para menu lateral si se pone asi
        win.getScene().getStylesheets().clear();
        panelMenuLateral.getStylesheets().clear();
        panelMenuLateral.getStylesheets().add("/css/CssRojo1.css");
        panelAlumnos.getStylesheets().clear();
        panelAlumnos.getStylesheets().add("/css/CssbotonYlabelRojo.css");
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        paneConfiguracion.setVisible(true);
    }

    public void cambiarImagenRa() {
        Window win = App.getScene().getWindow();
        win.setWidth(1040);
        win.setHeight(690);
        Image image1 = new Image(getClass().getResourceAsStream("/img/escudos/azul.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/img/casas/banderaAzul.png"));
        _imgEScudo.setImage(image1);
        panelMenuLateral.getStylesheets().clear();
        panelMenuLateral.getStylesheets().add("/css/CssAzul.css");
        panelAlumnos.getStylesheets().clear();
        panelAlumnos.getStylesheets().add("/css/CssbotonYlabelAzul.css");
        _imagen_bandera.setImage(image2);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        paneConfiguracion.setVisible(true);
    }

    public void cambiarImagenHu() {
        Window win = App.getScene().getWindow();
        win.setWidth(1040);
        win.setHeight(690);
        Image image1 = new Image(getClass().getResourceAsStream("/img/escudos/amarillo.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/img/casas/banderaAmarilla.png"));

        //panelMenuLateral.getChildren().add(imageView1);//para coger nodo hijo y añadir nueva imagen
        _imgEScudo.setImage(image1);

        panelMenuLateral.getStylesheets().clear();
        panelMenuLateral.getStylesheets().add("/css/CssAmarillo1.css");
        panelAlumnos.getStylesheets().clear();
        panelAlumnos.getStylesheets().add("/css/CssbotonYlabelAmarillo.css");
        _imagen_bandera.setImage(image2);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        paneConfiguracion.setVisible(true);
    }

    public void cambiarImagenProfe() {
        Window win = App.getScene().getWindow();
        win.setWidth(1040);
        win.setHeight(690);
        _panelMenuLateralProfe.getStylesheets().clear();
        _panelMenuLateralProfe.getStylesheets().add("/css/CssProfesor.css");
        panelProfesores.getStylesheets().clear();
        panelProfesores.getStylesheets().add("/css/CssbotonYlabelProfesor.css");
        vaciarPanelTodo();
        panelProfesores.setVisible(true);
        _panelSalaComunProfes.setVisible(true);
    }

    //=======================Métodos Registro Estudiantes=======================
    //==========================================================================
    public int contarCheck() {

        int cont = 0;

        if (_checkAdivinacion.isSelected()) {
            cont++;
        }
        if (_checkCriaturas.isSelected()) {
            cont++;
        }

        if (_checkDefensa.isSelected()) {
            cont++;
        }

        if (_checkEncantamientos.isSelected()) {
            cont++;
        }

        if (_checkPociones.isSelected()) {
            cont++;
        }

        if (_checkRunas.isSelected()) {
            cont++;
        }
        if (_checkTransformaciones.isSelected()) {
            cont++;
        }

        if (_checkVuelo.isSelected()) {
            cont++;
        }

        if (_checkHistoria.isSelected()) {
            cont++;

        }

        if (cont > 5) {
            desactivarCheckAsignatura();
        } else {
            activarAsignaturas();
        }

        return cont;
    }

    public void desactivarCheckAsignatura() {

        _checkAdivinacion.setDisable(true);
        _checkCriaturas.setDisable(true);
        _checkDefensa.setDisable(true);
        _checkEncantamientos.setDisable(true);
        _checkPociones.setDisable(true);
        _checkRunas.setDisable(true);
        _checkTransformaciones.setDisable(true);
        _checkVuelo.setDisable(true);
        _checkHistoria.setDisable(true);

        ArrayList<CheckBox> a = new ArrayList(9);
        a.add(_checkTransformaciones);
        a.add(_checkRunas);
        a.add(_checkAdivinacion);
        a.add(_checkCriaturas);
        a.add(_checkDefensa);
        a.add(_checkEncantamientos);
        a.add(_checkHistoria);
        a.add(_checkPociones);
        a.add(_checkVuelo);
        //esto hace quer al desactivar todos porque has llegado al maximo de 6 seleccionadas
        //te deje seguir editando las que si has seleccionado, para poder desmarcarlas y elegir otra
        for (int i = 0; i < 9; i++) {
            if (a.get(i).isSelected()) {
                a.get(i).setDisable(false);
            }
        }

    }

    public void activarAsignaturas() {
        _checkAdivinacion.setDisable(false);
        _checkCriaturas.setDisable(false);
        _checkDefensa.setDisable(false);
        _checkEncantamientos.setDisable(false);
        _checkPociones.setDisable(false);
        _checkRunas.setDisable(false);
        _checkTransformaciones.setDisable(false);
        _checkVuelo.setDisable(false);
        _checkHistoria.setDisable(false);
    }

    /**
     * @param Método para controlar los click que se hacen al elegir asignaturas
     * para poder bloquearlas al elegir 6
     */
    public void controlcheck() {

        _checkAdivinacion.setOnMouseClicked((MouseEvent mouseEvent) -> {
            // Insertar aquí el código a ejecutar cuando se haga clic en el ratón
            contarCheck();
        });
        _checkCriaturas.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkDefensa.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkEncantamientos.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkPociones.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkRunas.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkTransformaciones.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkVuelo.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });
        _checkHistoria.setOnMouseClicked((MouseEvent mouseEvent) -> {
            contarCheck();
        });

    }

    @FXML
    private void registro() {
        Window win = App.getScene().getWindow();
        win.setWidth(927);
        win.setHeight(520);
        vaciarPanelTodo();
        panelRegistro.setVisible(true);
        _cbCursos.getItems().addAll("Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo");
        _cbCursos.setValue("Primero");
        label_casa_seleccion.setText("");
    }

    @FXML
    private String saberCasa(MouseEvent event) {
        imagenPulsaSombrero.setVisible(false);
        labelPulsaSombrero1.setVisible(false);
        labelPulsaSombrero2.setVisible(false);
        imagenNombreCasa.setVisible(true);
        label_casa_seleccion.setVisible(true);
        pulsarCasas();
        return label_casa_seleccion.getText();
    }

    public void pulsarCasas() {

        SecureRandom generador = new SecureRandom();
        int i = generador.nextInt(4);
        switch (i) {
            case 0:
                label_casa_seleccion.setText("GRYFFINDOR");
                break;

            case 1:
                label_casa_seleccion.setText("HAFFLEPUFF");
                break;

            case 2:
                label_casa_seleccion.setText("RAVENCLAW");
                break;

            case 3:
                label_casa_seleccion.setText("SLYTHERIN");
                break;
        }
    }

    @FXML
    private void anden934() {

        String casa = label_casa_seleccion.getText();
        if (casa.equals("")) {
            Jopane("No has selecionado ninguna casa", "Error de seleción");
        } else {
            switch (casa) {
                case "GRYFFINDOR":
                    cambiarImagenGr();
                    break;
                case "SLYTHERIN":
                    cambiarImagenSl();
                    break;
                case "HAFFLEPUFF":
                    cambiarImagenHu();
                    break;
                case "RAVENCLAW":
                    cambiarImagenRa();
                    break;
            }

        }

    }

    private void guardarPerfil(MouseEvent event) {

        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        panelSalaComun.setVisible(true);

    }

    public void borrar_datos_registro() {
        _tfApellidosEstudiante.setText("");
        _tfDniEstudiante.setText("");
        _tfEmailEstudiante.setText("");
        _tfFechaNacEstudiante.setText("");
        _tfNombreEstudiante.setText("");
        _tfTelefonoEstudiante.setText("");
        _tfPassEstudiante.setText("");
    }

    /////////////////////////////////////////////////////////////////////////////////
    ////////////////MÉTODO PARA DAR DE ALTA UN ESTUDIANTE////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void altaEstudiante() {

        if (_boton_sala_comun1.getText().equalsIgnoreCase("Actualizar")) {

            if (!_tfPassEstudiante.getText().equals("")) {
                try {
                    String dni = pruebaInicio.getText();
                    int id_estudiante = obtner_id_estudiante(dni);

                    PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.estudiantes\n"
                            + "SET nombre= ?, apellidos= ?, telefono= ?, fecha_nac= ?, correo= ?, pass= ?\n"
                            + "WHERE id_estudiante= ?;");

                    String nombre = _tfNombreEstudiante.getText();
                    String apellidos = _tfApellidosEstudiante.getText();
                    int telefono = Integer.parseInt(_tfTelefonoEstudiante.getText());
                    String fecha_nac = _tfFechaNacEstudiante.getText();
                    String correo = _tfEmailEstudiante.getText();
                    String pass = _tfPassEstudiante.getText();

                    if (nombre.equals("") || apellidos.equals("") || fecha_nac.equals("") || correo.equals("") || String.valueOf(telefono).equals("") || pass.endsWith("")) {
                        Jopane("No puede dejar campos vacíos", "Error actualizar datos");
                    } else {
                        pst.setString(1, nombre);
                        pst.setString(2, apellidos);
                        pst.setInt(3, telefono);
                        pst.setString(4, fecha_nac);
                        pst.setString(5, correo);
                        pst.setInt(6, id_estudiante);
                        pst.setString(7, pass);

                        int comprobar = pst.executeUpdate();
                        if (comprobar < 1) {
                            Jopane("Se ha ejecutado correctamente", "Alta alumno");
                        } else {
                            Jopane("Error al ejecutar", "Alta alumno");
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(PanelPrincipalCasasController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    String dni = pruebaInicio.getText();
                    int id_estudiante = obtner_id_estudiante(dni);

                    PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.estudiantes\n"
                            + "SET nombre= ?, apellidos= ?, telefono= ?, fecha_nac= ?, correo= ?\n"
                            + "WHERE id_estudiante= ?;");

                    String nombre = _tfNombreEstudiante.getText();
                    String apellidos = _tfApellidosEstudiante.getText();
                    int telefono = Integer.parseInt(_tfTelefonoEstudiante.getText());
                    String fecha_nac = _tfFechaNacEstudiante.getText();
                    String correo = _tfEmailEstudiante.getText();
                    if (nombre.equals("") || apellidos.equals("") || fecha_nac.equals("") || correo.equals("") || String.valueOf(telefono).equals("")) {
                        Jopane("No puede dejar campos vacíos", "Error actualizar datos");
                    } else {
                        pst.setString(1, nombre);
                        pst.setString(2, apellidos);
                        pst.setInt(3, telefono);
                        pst.setString(4, fecha_nac);
                        pst.setString(5, correo);
                        pst.setInt(6, id_estudiante);

                        int comprobar = pst.executeUpdate();
                        if (comprobar < 1) {
                            Jopane("No se ha podido ejecutar", "Alta estudiante");
                        } else {
                            Jopane("Se ha ejecutado correctamente", "Alta estudiante");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PanelPrincipalCasasController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (_boton_sala_comun1.getText().equalsIgnoreCase("Guardar Datos")) {
            try {

                PreparedStatement pst = conn.prepareStatement("INSERT INTO estudiantes (nombre, apellidos, dni, telefono, fecha_nac, correo, pass, casa, curso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

                String nombre = _tfNombreEstudiante.getText();
                String apellidos = _tfApellidosEstudiante.getText();
                String dni = _tfDniEstudiante.getText();
                int telefono = Integer.parseInt(_tfTelefonoEstudiante.getText());
                String fecha_nac = _tfFechaNacEstudiante.getText();
                String correo = _tfEmailEstudiante.getText();
                String pass = _tfPassEstudiante.getText();
                String casa = label_casa_seleccion.getText();
                String curso = _cbCursos.getValue();
                if (nombre.equals("") || apellidos.equals("") || fecha_nac.equals("") || correo.equals("") || String.valueOf(telefono).equals("") || pass.equals("") || curso.equals("")) {
                    Jopane("No puede dejar campos vacíos", "Error actualizar datos");
                } else {
                    //sql = "INSERT INTO estudiantes (nombre, apellidos, telefono, dni, fecha_nac, correo, pass, casa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    pst.setString(1, nombre);
                    pst.setString(2, apellidos);
                    pst.setString(3, dni);
                    pst.setInt(4, telefono);
                    pst.setString(5, fecha_nac);
                    pst.setString(6, correo);
                    pst.setString(7, pass);
                    pst.setString(8, casa);
                    pst.setString(9, curso);

                    boolean a = pst.execute();

                    if (!a) {

                        vaciarPanelTodo();
                        panelAlumnos.setVisible(true);
                        panelSelecionAsignatura.setVisible(true);
                        Jopane("Añadido correctamente, seleccione ahora 6 asignaturas", "Añadir estudiantes");
                        borrar_datos_registro();
                        pruebaInicio.setText(dni);
                    } else {
                        Jopane("Error", "error al insertar");

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void cargar_datos_configuracionA() {
        String dni = pruebaInicio.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        try {
            //   int id_estudiante = Integer.valueOf(pruebaInicio.getText());

            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE id_estudiante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //falta actualizar sin contraseña
            pst.setInt(1, id_estudiante);
            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                _tfNombreEstudiante.setText(rs.getString("nombre"));
                _tfApellidosEstudiante.setText(rs.getString("apellidos"));
                _tfDniEstudiante.setText(rs.getString("dni"));
                _tfTelefonoEstudiante.setText(rs.getString("telefono"));
                _tfEmailEstudiante.setText(rs.getString("correo"));
                _tfFechaNacEstudiante.setText(rs.getString("fecha_nac"));
                String curso = rs.getString("curso");
                _cbCursos.setValue(curso);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //=====================Métodos Cambiar menú Estudiantes=====================
    //========================================================================== 
    /**
     *
     * @param id_estudiante tipo entero recoge un dato autoincremental con el id
     * que identifica al estudiante
     */
    public void Cambiar_recordadoraAlumnos(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM mensajes where id_estudiante= ?");
            pst.setInt(1, id_estudiante);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                boolean leido = rs.getBoolean("leido");
                if (leido == false) {
                    imagen_recordadoraA.setVisible(true);
                } else {
                    imagen_recordadoraA.setVisible(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //==========================================================================
    //////////////MÉTODOS PARA CAMBIAR PANELES SEGÚN DONDE HAGAS CLICK//////////
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private void cambiarPanelSalaComun(ActionEvent event) {
        String dni = labelUser.getText();
        int id_estudiante = obtner_id_estudiante(dni);

        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        panelSalaComun.setVisible(true);
        _tablaAlum_salaComun.getItems().clear();
        rellenar_tareas_alumnos_semanal(id_estudiante);
        Cambiar_recordadoraAlumnos(id_estudiante);

    }

    @FXML
    private void cambiarPanelAsignaturas(ActionEvent event) {
        String dni = labelUser.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        panelAsignaturas.setVisible(true);
        iconosPanelAsignaturas(id_estudiante);
        Cambiar_recordadoraAlumnos(id_estudiante);
    }

    @FXML
    private void cambiarPanelNotas(ActionEvent event) {
        String dni = labelUser.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        panelNotas.setVisible(true);
        _jcFilto_notas_alumno.getItems().clear();
        notas_por_asignatura(id_estudiante);
        _tablaAlu_notas.getItems().clear();
        rellenar_notas_alumnos(id_estudiante);
        cambiarImagenAsignaturas_Notas(id_estudiante);
        Cambiar_recordadoraAlumnos(id_estudiante);
    }

    @FXML
    private void cambiarPanelTareas(ActionEvent event) {
        String dni = labelUser.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        panelTareas.setVisible(true);
        //totalAlumnos();
        _tbA_tareas.getItems().clear();
        rellenar_tareas_alumnos(id_estudiante);
        Cambiar_recordadoraAlumnos(id_estudiante);
    }

    /////////////////////////////////////////////////////////////////////////////////
    /////////MÉTODOS PARA ABRIR ASIGNATURAS AL HACER CLICK EN SU ICONO///////////////
    /////////////////////////////////////////////////////////////////////////////////
    public void cambiarPanelAsignaturasIndividual(String asignatura, String profesor, float notaMedia, String tipoAsignatura) {
        String dni = pruebaInicio.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        paneAsignaturasIndividual.setVisible(true);
        imagen_texto_asignatura.setVisible(true);

        //CAMBIAR FOTOS, LABEL Y TABLAS, SOLO ESTÁ EL CODE SIN CAMBIAR
        //HACERLO CON TODOS LOS CASES O CREAR UN MÉTODO(SE PODRIA HACER SOLO UNO....)
        //panelMenuLateral.getChildren().add(imageView1);//para coger nodo hijo y añadir nueva imagen
        Image image1 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignatura + ".png"));
        Image image2 = new Image(getClass().getResourceAsStream("/img/textos_asignaturas/" + asignatura + ".png"));
        _imagenAsignatura.setImage(image1);
        imagen_texto_asignatura.setImage(image2);

        _tituloAsignatura.setText(asignatura.toUpperCase());
        _nombreProfesorAsignatura.setText(profesor);

        Cambiar_recordadoraAlumnos(id_estudiante);
    }

    @FXML
    private void cambiarAsignaturaIndividual(MouseEvent event) {

        //intentando sacar el texto que hay en el label que haces click
        //RECORDAR ARREGLAR ESTO, SOLO COJO EL LABEL Y NO EL PANEL COMPLETO....ARREGLAR O FUNCIONA A TROZOS
        String a = event.getPickResult().getIntersectedNode().getId().toString();
        //chapuza que funciona, no me gusta pero es lo que hay, no se que más hacer, 18-24
        String asignatura = a.substring(11).toLowerCase();

        //System.out.println(a); //para comprobar los nodos y saber donde estoy entrando
        //SE PODRIA HACER UN RETURN Y NO EL SW, SE LE PASA EL SZTRING Y SE PONE DE NOMBRE A TODO....RARO...DAR VUELTA
        switch (asignatura) {
            case "pociones":
                cambiarPanelAsignaturasIndividual(asignatura, "Snape", 9.8f, "OPCIONAL");

                break;
            case "criaturas":
                cambiarPanelAsignaturasIndividual(asignatura, "Hagrid", 9.7f, "OBLIGATORIA");

                break;
            case "vuelo":
                cambiarPanelAsignaturasIndividual(asignatura, "Hook", 9.6f, "OPCIONAL");

                break;
            case "defensa":
                cambiarPanelAsignaturasIndividual(asignatura, "Lupin", 9.58f, "OBLIGATORIA");

                break;
            case "historia":
                cambiarPanelAsignaturasIndividual(asignatura, "Beans", 9.4f, "OPCIONAL");

                break;
            case "transformaciones":

                cambiarPanelAsignaturasIndividual(asignatura, "Mcgonagall", 9.3f, "OBLIGATORIA");

                break;
            case "encantamientos":
                cambiarPanelAsignaturasIndividual(asignatura, "Flitwich", 9.2f, "OPCIONAL");

                break;
            case "runas":
                cambiarPanelAsignaturasIndividual(asignatura, "Babbling", 9.1f, "OPCIONAL");

                break;
            case "adivinacion":
                cambiarPanelAsignaturasIndividual(asignatura, "Trelawney", 8.2f, "OPCIONAL");

                break;
        }
    }

    //=====================Métodos Cambiar menú Estudiantes=====================
    //========================================================================== 
    /**
     *
     * @param id_profesor tipo entero recoge un dato autoincremental con el id
     * que identifica al profesor
     */
    public void Cambiar_recordadoraProfesores(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM mensajes_profesor where id_profesor= ?");
            pst.setInt(1, id_profesor);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                boolean leido = rs.getBoolean("leido");
                if (leido == false) {
                    imagen_recordadora.setVisible(true);
                } else {
                    imagen_recordadora.setVisible(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cambiarSalaProfes() {
        String dni = labelUser.getText();
        int id_profesor = obtener_id_profesor(dni);
        vaciarPanelProfes();
        _panelSalaComunProfes.setVisible(true);
        _tbprofesores_semanal.getItems().clear();
        rellenar_tablaProfesor_semanal(id_profesor);
        Cambiar_recordadoraProfesores(id_profesor);

    }

    @FXML
    public void cambiarConfiguracion() {
        String dni = labelUser.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        vaciarPanelTodo();
        panelAlumnos.setVisible(true);
        paneConfiguracion.setVisible(true);
        _boton_sala_comun1.setText("Actualizar");
        cargar_datos_configuracionA();
        Cambiar_recordadoraAlumnos(id_estudiante);

    }

    @FXML
    private void cambiarTareasProfes() {
        String dni = pruebaInicio.getText();

        int id_profesor = obtener_id_profesor(dni);
        System.out.println(id_profesor);
        _cbTareas_cursos.getItems().clear();
        _cbTarea_casa.getItems().clear();
        vaciarPanelProfes();
        _panelAsignaerTareasProfes.setVisible(true);
        _cbTareas_cursos.getItems().addAll("Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo");
        //_cbTareas_cursos.setValue("Primero");
        _cbTarea_casa.getItems().addAll("Gryffindor", "Slytherin", "Hafflepuff", "Ravenclaw");
        //_cbTarea_casa.setValue("Gryffindor");
        _cbTareas_tipo.getItems().addAll("Examen", "Proyecto", "Recuperación", "Ejercicios");
        _cbTareas_tipo.setValue("Ejercicios");
        totalAlumnos();
        solo_combo_casa();
        solo_combo_curos();
        Cambiar_recordadoraProfesores(id_profesor);

    }

    @FXML
    private void cambiarCorreccionesProfes() {
        ocultarCorrecionesProfesores();
        labelP_correciones.setVisible(true);
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);
        vaciarPanelProfes();
        _tbTarea_correciones.getItems().clear();
        _tbTarea_correciones_pendientes.getItems().clear();
        _panelCorreccionesProfes.setVisible(true);
        rellenar_tabla_correcciones(id_profesor);
        rellenar_tabla_correccionesPendientes(id_profesor);
        Cambiar_recordadoraProfesores(id_profesor);

    }

    @FXML
    public void ocultarCorrecionesProfesores() {

        try {
            labelP_correciones_alumno.setVisible(false);
            labelP_correciones_comentario.setVisible(false);
            labelP_correciones_nota.setVisible(false);
            _tfTareas_alumno.setVisible(false);
            _tfTareasComentario.setVisible(false);
            _tfTareasNota.setVisible(false);
            botonP_correciones.setVisible(false);
        } catch (Exception e) {
            System.out.println("");
        }

    }

    @FXML
    public void mostrarCorrecionesProfesores() {

        try {
            labelP_correciones_alumno.setVisible(true);
            labelP_correciones_comentario.setVisible(true);
            labelP_correciones_nota.setVisible(true);
            _tfTareas_alumno.setVisible(true);
            _tfTareasComentario.setVisible(true);
            _tfTareasNota.setVisible(true);
            botonP_correciones.setVisible(true);
        } catch (Exception e) {
            System.out.println("");
        }

    }

    @FXML
    private void cambiarCursosProfes() {
        String dni = pruebaInicio.getText();
        _cbCursos.getItems().addAll("Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo");
        _cbCursos.setValue("Primero");
        vaciarPanelProfes();
        _panelCursosProfes.setVisible(true);
        int id_profesor = id_profesor_Con_dni(dni);
        _tablaProfesor_cursos.getItems().clear();
        int id_asigProf = id_profesor_obtener_asifprof(id_profesor);
        rellenar_tabla(id_asigProf);
        Cambiar_recordadoraProfesores(id_profesor);
    }

    //=========icono asistencia sala comun profesores=======================
    /**
     * metodo para cambiar el panel asistencia
     */
    @FXML
    public void cambiar_asistencia() {
        _comboP_AsistenciaCursos.getItems().clear();
        _comboP_AsistenciaCasa.getItems().clear();
        _comboP_AsistenciaCursos.getItems().addAll("Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo");
        _comboP_AsistenciaCasa.getItems().addAll("Gryffindor", "Slytherin", "Hafflepuff", "Ravenclaw");
        vaciarPanelTodo();
        _tablaP_asistencia.getItems().clear();
        panelProfesores.setVisible(true);
        _panelAsistencia.setVisible(true);

    }

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void atrasAsignatura(MouseEvent event) {
        String dni = pruebaInicio.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        paneAsignaturasIndividual.setVisible(false);
        panelAsignaturas.setVisible(true);
        imagen_texto_asignatura.setVisible(false);
        Cambiar_recordadoraAlumnos(id_estudiante);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //método para copiar un archivo elegido del sistema a una ruta específica (en este caso la carpeta archivos)
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void fileChooser(MouseEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivo");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll();

        // Obtener la imagen seleccionada
        File archivo = fileChooser.showOpenDialog(null);
        String archivoElegido = archivo.getAbsoluteFile().toString();

        _tfDocumentoSubir.setText(archivoElegido);

    }

    @FXML
    private void GuardarDocumentoComentario() {

        tareas_alumnos_objeto objetoSeleccionado = _tbA_tareas.getSelectionModel().getSelectedItem();
        int id_tarea = objetoSeleccionado.id_tarea;

        if (String.valueOf(id_tarea).equals("")) {
            Jopane("No se ha seleccionado ninguna fila", "Error al guardar datos");
        } else {

            String archivoElegido = _tfDocumentoSubir.getText();
            String comentario_alumno = _tfComentario.getText();

            Path path = Paths.get("");// inicializa una variable vacia de ruta
            String directoryName = path.toAbsolutePath().toString();// guarda la ruta

            String destinationPath = directoryName + "\\src\\main\\resources\\archivos\\";  // destination file path
            File sourceFile = new File(archivoElegido);        // Creating A Source File
            File destinationFile = new File(destinationPath + sourceFile.getName());   //Creating A Destination File. Name stays the same this way, referring to getName()

            try {
                Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
                dialogoAlerta.setTitle("Ventana de Confirmación");
                dialogoAlerta.setHeaderText(null);
                dialogoAlerta.initStyle(StageStyle.UTILITY);
                dialogoAlerta.setContentText("¿Seguro que quieres subir el archivo?");

                Optional<ButtonType> result = dialogoAlerta.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Files.copy(sourceFile.toPath(), destinationFile.toPath());
                    String nombreArchivo = destinationFile.toString().substring(destinationFile.toString().lastIndexOf("\\") + 1);
                    actualizarTareasAlumno_Ruta(id_tarea, nombreArchivo, comentario_alumno);//?????Arreglar tabla y poner id tarea?????
                    Jopane("Guardado correctamente", "Guartar tarea");

                }

                // Static Methods To Copy Copy source path to destination path
            } catch (Exception e) {
                Jopane("Error, al subir la tarea", "Error");
            }

        }

    }

    public void actualizarTareasAlumno_Ruta(int id_tarea, String ruta, String comentario_alumno) {
        int id_estudiante = obtner_id_estudiante(pruebaInicio.getText());
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.tareas\n"
                    + "SET entregado=1, archivo=?, comentario_alumno=?\n"
                    + "WHERE id_tarea=?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setString(1, ruta);
            pst.setString(2, comentario_alumno);
            pst.setInt(3, id_tarea);

            int comprobar = pst.executeUpdate();
            if (comprobar < 1) {
                Jopane("No se ha podido ejecutar", "Subir tarea");
            } else {
                Jopane("Se ha ejecutado correctamente", "Actualizar tarea");
            }
            rellenar_tareas_alumnos(id_estudiante);
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //============Metodo seleccion asignaturas==================
    @FXML
    public void Asignaturas_elegidas() {
        String dni = pruebaInicio.getText();
        int id_estudiante = obtner_id_estudiante(dni);

        if (contarCheck() < 6) {
            Jopane("Hay que añadir 6 asignaturas obligatoriamente", "error");
        } else {

            if (_checkAdivinacion.isSelected()) {
                insertar_asigEstu("Adivinacion");
            }
            if (_checkCriaturas.isSelected()) {
                insertar_asigEstu("Criaturas");
            }
            if (_checkDefensa.isSelected()) {
                insertar_asigEstu("Defensa");
            }
            if (_checkEncantamientos.isSelected()) {
                insertar_asigEstu("Encantamientos");
            }
            if (_checkPociones.isSelected()) {
                insertar_asigEstu("Pociones");
            }
            if (_checkRunas.isSelected()) {
                insertar_asigEstu("Runas");
            }
            if (_checkTransformaciones.isSelected()) {
                insertar_asigEstu("Transformaciones");
            }
            if (_checkVuelo.isSelected()) {
                insertar_asigEstu("Vuelo");
            }
            if (_checkHistoria.isSelected()) {
                insertar_asigEstu("Historia");
            }

            vaciarPanelTodo();

            panelAlumnos.setVisible(true);
            panelSalaComun.setVisible(true);
            Jopane("Asignaturas elegidas correctamente", "Elegir asignaturas");

        }
    }

    public void insertar_asigEstu(String asignatura) {
        String dni = pruebaInicio.getText();

        int id_asignatura = obtener_id_asignatura(asignatura);
        int id_asigProf = obtener_id_asigProf(id_asignatura);
        int id_estudiante = obtner_id_estudiante(dni);
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO asigEstu (id_estudiante, id_asigProf) VALUES (?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            pst.setInt(2, id_asigProf);

            int comprobar = pst.executeUpdate();
            if (comprobar > 0) {
                Jopane("Se ha ejecutado correctamente", "Insertar asignatura");
            } else {
                Jopane("Error al ejecutar", "Insertar asignatura");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    /////////////////MÉTDOS PARA OBTENER DATOS DE ESTUDIANTES///////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param dni tipo String identifica el dni del estudiante
     * @return devuelve el id que identifica al estudiante
     * @throws SQLException devuelve una excepcion si no se ha podido ejecutar
     * la consulta
     */
    public int obtner_id_estudiante(String dni) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE dni = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, dni);
            resultado = pst.executeQuery();

            if (!resultado.first()) {
                return -1;
            } else {
                int id = resultado.getInt("id_estudiante");
                return id;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     *
     * @param id_estudiante de tipo int recoge un valor autoencremental que
     * identifica al estudiante
     * @return devuelve el dni del estudiante
     */
    public String obtner_dni_estudiante(int id_estudiante) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE id_estudiante = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            resultado = pst.executeQuery();

            if (!resultado.first()) {
                return null;
            } else {
                String dni = resultado.getString("dni");
                return dni;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String casa_por_dni(String dni) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes where dni= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, dni);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener la casa por dni", "Error");
                return null;
            } else {
                String casa = resultado.getString("casa");
                return casa;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String cursos_por_dni(String dni) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes where dni= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, dni);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el curso por dni", "Error");
                return null;
            } else {
                String curso = resultado.getString("curso");
                return curso;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void totalAlumnos() {
        ResultSet rs;

        int id_asigprof = obtener_id_asigProf_por_idProfesor(obtener_id_profesor(pruebaInicio.getText()));
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT id_estudiante FROM asigEstu WHERE id_asigProf = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigprof);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();
            while (rs.next()) {
                int id_estudiante = rs.getInt("id_estudiante");
                String dni = obtner_dni_estudiante(id_estudiante);
                String nombre = obtenerNombreAlumno_porID(id_estudiante);
                String apellidos = obtenerApellidoAlumno_porID(id_estudiante);

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().clear();// limpia los combo box para no duplicar datos
                _cbTareas_alumnos.getItems().addAll(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param curso tipo string curso , pasandole este parametro realiza una
     * consulta para sacar el total de estudiantes pertenecientes a ese curso
     */
    public void totalAlumnos_por_curso(String curso) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE curso = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, curso);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void totalAlumnos_por_casa(String casa) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE casa = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, casa);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void totalAlumnos_por_casa_curso(String curso, String casa) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE curso = ? AND casa = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, curso);
            pst.setString(2, casa);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    //==========================HISTORIAL ASISTENCIA===============================
    public void filtrar_alumnos_asistencia_curso_historial(int id_asigProf) {
        int id_profesor = obtener_id_profesor(pruebaInicio.getText());

        _comboP_AsistenciaCursos1.valueProperty().addListener((ov, p1, p2) -> {

            if (_comboP_AsistenciaCasa1.getValue() == null) {
                _tablaP_asistencia1.getItems().clear();
                rellenar_tabla_asistencia_historial(id_profesor);

            } else {
                _tablaP_asistencia1.getItems().clear();
                String casa = _comboP_AsistenciaCasa1.getValue().toString();
                rellenar_tabla_asistencia_casaCurso_historial(id_asigProf, p2, casa);
            }

        });

    }

    public void filtrar_alumnos_asistencia_casa_historial(int id_asigProf) {
        _comboP_AsistenciaCasa1.valueProperty().addListener((ov, p1, p2) -> {
            if (_comboP_AsistenciaCursos1.getValue() == null) {
                _tablaP_asistencia1.getItems().clear();
                rellenar_tabla_asistencia_historial(id_asigProf);

            } else {
                _tablaP_asistencia1.getItems().clear();
                String curso = _comboP_AsistenciaCursos1.getValue().toString();
                rellenar_tabla_asistencia_casaCurso_historial(id_asigProf, curso, p2);
            }

        });

    }

    //== metodo para filtar los alumnos por casa=================
    /**
     *
     * @param id_asigProf tipo int autoincremental que identifican al profesor
     * con su asignatura este metodo filta los alumnos segun su casa, lo usamos
     * para rellanar los combo box realizando cursos
     */
    public void filtar_alumnos_por_casa(int id_asigProf) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.casa \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?));", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
//== metodo para filtar los alumnos por curso=================

    /**
     *
     * @param id_asigProf tipo int autoincremental que identifican al profesor
     * con su asignatura este metodo filta los alumnos segun su curso, los
     * usamos para rellanar los combos haciendo filtros
     */
    public void filtar_alumnos_por_curso(int id_asigProf) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.curso \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?));", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();
            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //== metodo para filtar los alumnos dependiendo de la casa y el curso=================
    /**
     *
     * @param id_asigProf tipo int autoincremental que identifican al profesor
     * con su asignatura este metodo filta los alumnos segun su curso y la casa,
     * los usamos para rellanar los combos haciendo filtros
     */
    public void alumnos_segun_casaYcurso(int id_asigProf) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.* \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?))AND estudiantes.casa=? AND estudiantes.curso=?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            pst.setString(2, _cbTarea_casa.getValue());
            pst.setString(3, _cbTareas_cursos.getValue());
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();
            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String casa_por_id(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes where id_estudiante= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener la casa por el id estudiante", "Error");
                return null;
            } else {
                String casa = resultado.getString("casa");
                return casa;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //== metodo para filtar los alumnos dependiendo de la casa sin selecionar otro combobox=================
    /**
     *
     * @param id_asigProf tipo int autoincremental que identifican al profesor
     * con su asignatura
     *
     * @param p2 de tipo String identifica la casa del estudiante
     */
    public void alumnos_segun_casa(int id_asigProf, String p2) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.* \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?))AND estudiantes.casa=?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            pst.setString(2, p2);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    //== metodo para filtar los alumnos dependiendo del curso sin seleccionar otro combox=================

    public void alumnos_segun_curso(int id_asigProf, String p2) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.* \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?))AND  estudiantes.curso=?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            pst.setString(2, p2);
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();
            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    ////////////////////metodos para datos de profesores////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public int id_profesor_Con_dni(String dni) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM profesores where dni= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, dni);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos obtener el id profesor por el dni", "Error");
                return -1;
            } else {
                int id_profesor = resultado.getInt("id_profesor");
                return id_profesor;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public int id_asignatura_Con_id_profesor(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM asigProf where id_profesor = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el id asinatura por el id profesor", "Error");
                return -1;
            } else {
                int id_asignatura = resultado.getInt("id_asignatura");
                return id_asignatura;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public int id_profesor_obtener_asifprof(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM asigProf where id_profesor= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el id asigprof por el id profesor", "Error");
                return -1;
            } else {
                int id_asigProf = resultado.getInt("id_asigProf");
                return id_asigProf;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     *
     * @param id_asigProf de tipo int autoincremental identifica a un profesor
     * que imparte una asignatura
     * @return devuelve un conjunto de resultados del
     * estudiante;nombre,apellidos,casa, curso para poder rellenar la tabla
     */
    public ResultSet datos_tabla_profesor(int id_asigProf) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.nombre, estudiantes.apellidos, estudiantes.casa, estudiantes.curso \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?));", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param id_asignatura de tipo int recoge un valor autoencremental que
     * identifica la asignatura
     * @return devuelve el id de la tabla asigProf (identifica al profesor con
     * la asignatura que imparte)
     */
    public int obtener_id_asigProf(int id_asignatura) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM asigProf WHERE id_asignatura = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asignatura);
            resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos obtener id asigprof por el id asignatura", "Error");
                return -1;
            } else {
                int id = resultado.getInt("id_asigProf");
                return id;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     *
     * @param id_profesor de tipo int recoge un valor autoencremental que
     * identifica al profesor
     * @return devuelve el id de la tabla asigProf (identifica al profesor con
     * la asignatura que imparte)
     */
    public int obtener_id_asigProf_por_idProfesor(int id_profesor) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM asigProf WHERE id_profesor = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            resultado = pst.executeQuery();

            if (!resultado.first()) {
                return -1;
            } else {
                int id = resultado.getInt("id_asigProf");
                return id;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public int obtener_id_profesor(String dni) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM profesores WHERE dni = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, dni);
            resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el id profesor por dni", "Error");
                return -1;
            } else {
                int id = resultado.getInt("id_profesor");
                return id;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /////////////////////////METODOS DE OTRAS TABLAS////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param asignatura tipo String identifica la asignatura
     * @return devuelve el id autoincremental que identifica la asignatura
     */
    public int obtener_id_asignatura(String asignatura) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM asignaturas WHERE nombre = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, asignatura);
            resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos obtener el id asignatura por el nombre asignatura", "Error");
                return -1;
            } else {
                int id = resultado.getInt("id_asignatura");
                return id;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public int totalAsignaturas(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(id_estudiante) AS total FROM asigEstu WHERE id_estudiante = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos obtener el total asignaturas por el id estudiante", "Error");
                return -1;
            } else {
                int num = resultado.getInt("total");
                return num;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    /**
     *
     * metodo devuelve la casa del alumno por el id ===================
     *
     * @param id_estudiante tipo int incremental identifica al estudiante
     * @return devuelve la casa a la que pertenece el estudiante
     *
     */
    ////////////////////////////////////////////////////////////////////////////
    //============================rellena tablaS================================
    /**
     *
     * @param id_asigProf identifica al profesor que imparte una asignatura,
     * este metodo rellana la tabla profesores
     * @return devuelve los datos para llenar la tabla profesorees
     * @link  com.agenda.agenda_v1.class#Alumnos_objeto(nombre, apellidos, curso, casa);
     */
    public ObservableList<Alumnos_objeto> rellenar_tabla(int id_asigProf) {
        ObservableList<Alumnos_objeto> obs = FXCollections.observableArrayList();
        _columAlumno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        _columCursos.setCellValueFactory(new PropertyValueFactory<>("curso"));
        _columCasa.setCellValueFactory(new PropertyValueFactory<>("casa"));
        try {
            ResultSet rs = datos_tabla_profesor(id_asigProf);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String curso = rs.getString("curso");
                String casa = rs.getString("casa");

                Alumnos_objeto a = new Alumnos_objeto(nombre, apellidos, curso, casa);
                obs.add(a);
                _tablaProfesor_cursos.getItems().addAll(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<tareas_profesores_objeto> rellenar_tabla_correcciones(int id_profesor) {

        ObservableList<tareas_profesores_objeto> obs = FXCollections.observableArrayList();
        _columTareaId.setCellValueFactory(new PropertyValueFactory<>("id_tarea"));
        _columTareaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columTareasApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        _columTareasCursos.setCellValueFactory(new PropertyValueFactory<>("curso"));
        _columTareasTareas.setCellValueFactory(new PropertyValueFactory<>("nombre_tarea"));
        _columTareaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo_tarea"));
        _columTareasFechaFin.setCellValueFactory(new PropertyValueFactory<>("fecha_fin"));
        try {
            ResultSet rs = datos_para_correcciones(id_profesor);

            while (rs.next()) {
                String id_tarea = rs.getString("id_tarea");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String cursos = rs.getString("curso");
                String nombre_tarea = rs.getString("nombre_tarea");
                String tipo_tarea = rs.getString("tipo_tarea");
                String fecha_fin = rs.getString("fecha_fin");

                tareas_profesores_objeto c = new tareas_profesores_objeto(id_tarea, nombre, apellidos, cursos, nombre_tarea, tipo_tarea, fecha_fin);
                obs.add(c);
                _tbTarea_correciones.getItems().addAll(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    /**
     *
     * @param id_profesor tipo int autoincremental que identifica al profesor
     * @return devuelve un conjunto de resultados para rellenar la tabla
     * correciones pendientes (id_tarea,nombre, apellidos,
     * curso,nombre_tarea,tipo_tarea,fecha_fin)
     * @link com.agenda.agenda_v1.class#tareas_profesores_objeto
     */
    public ObservableList<tareas_profesores_objeto> rellenar_tabla_correccionesPendientes(int id_profesor) {

        ObservableList<tareas_profesores_objeto> obs = FXCollections.observableArrayList();
        _columTareaIdPendientes.setCellValueFactory(new PropertyValueFactory<>("id_tarea"));
        _columTareaNombrePendientes.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columTareasApellidosPendientes.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        _columTareasCursosPendientes.setCellValueFactory(new PropertyValueFactory<>("curso"));
        _columTareasTareasPendientes.setCellValueFactory(new PropertyValueFactory<>("nombre_tarea"));
        _columTareaTipoPendientes.setCellValueFactory(new PropertyValueFactory<>("tipo_tarea"));
        _columTareasFechaFinPendientes.setCellValueFactory(new PropertyValueFactory<>("fecha_fin"));
        try {
            ResultSet rs = datos_para_correccionesPendientes(id_profesor);

            while (rs.next()) {
                String id_tarea = rs.getString("id_tarea");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String cursos = rs.getString("curso");
                String nombre_tarea = rs.getString("nombre_tarea");
                String tipo_tarea = rs.getString("tipo_tarea");
                String fecha_fin = rs.getString("fecha_fin");

                tareas_profesores_objeto c = new tareas_profesores_objeto(id_tarea, nombre, apellidos, cursos, nombre_tarea, tipo_tarea, fecha_fin);
                obs.add(c);
                _tbTarea_correciones_pendientes.getItems().addAll(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<tareas_alumnos_objeto> rellenar_tareas_alumnos(int id_estudiante) {

        ObservableList<tareas_alumnos_objeto> obs = FXCollections.observableArrayList();
        _columA_tareaId.setCellValueFactory(new PropertyValueFactory<>("id_tarea"));
        _columA_tareaAsignatura.setCellValueFactory(new PropertyValueFactory<>("asignatura"));
        _columA_tareaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo_tarea"));
        _columA_tareaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre_tarea"));
        _columA_tareafecha_fin.setCellValueFactory(new PropertyValueFactory<>("fecha_fin"));
        _columA_tareaArchivo.setCellValueFactory(new PropertyValueFactory<>("archivo"));

        try {
            ResultSet rs = datos_para_tareas_alumnos(id_estudiante);

            while (rs.next()) {
                int id_tarea = rs.getInt("id_tarea");
                String asignatura = rs.getString("nombre_asignatura");
                String tipo_tarea = rs.getString("tipo_tarea");
                String nombre_tarea = rs.getString("nombre_tarea");
                String fecha_fin = rs.getString("fecha_fin");
                String archivo = rs.getString("archivo");

                tareas_alumnos_objeto e = new tareas_alumnos_objeto(id_tarea, asignatura, tipo_tarea, nombre_tarea, fecha_fin, archivo);
                obs.add(e);
                _tbA_tareas.getItems().addAll(e);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<tareas_profesores_objeto> rellenar_tablaProfesor_semanal(int id_profesor) {

        ObservableList<tareas_profesores_objeto> obs = FXCollections.observableArrayList();
        _columP_tarea_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columP_tarea_apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        _columP_tarea_cursos.setCellValueFactory(new PropertyValueFactory<>("curso"));
        _columP_tarea_tareas.setCellValueFactory(new PropertyValueFactory<>("nombre_tarea"));
        _columP_tarea_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo_tarea"));
        _columP_tarea_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha_fin"));
        try {
            ResultSet rs = datos_tablaProfesores_semanal(id_profesor);

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String cursos = rs.getString("curso");
                String nombre_tarea = rs.getString("nombre_tarea");
                String tipo_tarea = rs.getString("tipo_tarea");
                String fecha_fin = rs.getString("fecha_fin");

                tareas_profesores_objeto f = new tareas_profesores_objeto(nombre, apellidos, cursos, nombre_tarea, tipo_tarea, fecha_fin);
                obs.add(f);
                _tbprofesores_semanal.getItems().addAll(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    //metodo para  rellenar tabla asistencia alumnos
    /**
     *
     * @param id_profesor
     * @return este metodo rellena la tabla asistencia usamos un combo box
     * dentro de una tabla omboBoxTableCell<>("Presente", "Ausente", "Retraso")
     * @link com.agenda.agenda_v1.class#Alumnos_asistencia_objeto
     */
    public ObservableList<Alumnos_asistencia_objeto> rellenar_tabla_asistencia(int id_profesor) {
        int id_asigProf = obtener_id_asigProf_por_idProfesor(id_profesor);
        _tablaP_asistencia.getItems().clear();
        ObservableList<Alumnos_asistencia_objeto> obs = FXCollections.observableArrayList();
        _columP_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columP_apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        _columP_dni.setCellValueFactory(new PropertyValueFactory<>("dni"));

        columP_asistencia21.setCellValueFactory(new PropertyValueFactory<>("asistencia"));

        String nombre = null;
        Alumnos_asistencia_objeto p = null;
        try {
            ResultSet rs = datos_asistencia(id_asigProf);
            while (rs.next()) {
                int id = rs.getInt("id_estudiante");
                ResultSet rst = datosAlumnos_porId(id);
                while (rst.next()) {
                    nombre = rst.getString("nombre");
                    String apellidos = rst.getString("apellidos");
                    String dni = rst.getString("dni");

                    p = new Alumnos_asistencia_objeto(nombre, apellidos, dni, "presente");
                    obs.add(p);
                }

                _tablaP_asistencia.getItems().addAll(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Jopane("Error", "Error al rellenar la tabla asistencias");
        }
        return obs;
    }

    /**
     *
     * @param id_asigProf tipo int identifica al profesor con la asignatura
     * @param curso tipo String identifica el curso del alumno
     * @param casa tipo String identifica la casa del alumno
     */
    public void rellenar_tabla_asistencia_casaCurso(int id_asigProf, String curso, String casa) {
        Alumnos_asistencia_objeto p = null;
        _tablaP_asistencia.getItems().clear();
        try {
            ObservableList<Alumnos_asistencia_objeto> obs = FXCollections.observableArrayList();
            _columP_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            _columP_apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            _columP_dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
//            columP_asistencia2.setCellFactory(c -> new ComboBoxTableCell<>("Presente", "Ausente", "Retraso"));
//
//            columP_asistencia2.getColumns().add(columP_asistencia2);

            curso = _comboP_AsistenciaCursos.getValue().toString();
            casa = _comboP_AsistenciaCasa.getValue().toString();

            ResultSet rs = alumnos_segun_curso_asistencia(id_asigProf, curso, casa);

            while (rs.next()) {
                int id = rs.getInt("id_estudiante");
                ResultSet rst = datosAlumnos_porId(id);
                while (rst.next()) {
                    String nombre = rst.getString("nombre");
                    String apellidos = rst.getString("apellidos");
                    String dni = rst.getString("dni");
                    p = new Alumnos_asistencia_objeto(nombre, apellidos, dni);
                    obs.add(p);
                }

                _tablaP_asistencia.getItems().addAll(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////mETODOS XOMBOS//////////////////////////////////
    public void solo_combo_curos() {
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);
        // ejecutar cuando se haga clic en el ratón??
        int id_asigProf = id_profesor_obtener_asifprof(id_profesor);

        _cbTareas_cursos.valueProperty().addListener((ov, p1, p2) -> {
            if (_cbTarea_casa.getValue() == null) {
                alumnos_segun_curso(id_asigProf, p2);
            } else {
                alumnos_segun_casaYcurso(id_asigProf);
            }
        });
    }

    public void solo_combo_casa() {
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);

        int id_asigProf = id_profesor_obtener_asifprof(id_profesor);

        _cbTarea_casa.valueProperty().addListener((ov, p1, p2) -> {
            if (_cbTareas_cursos.getValue() == null) {
                alumnos_segun_casa(id_asigProf, p2);
            } else {
                alumnos_segun_casaYcurso(id_asigProf);
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////MÉTODOS PARA TAREAS//////////////////////////////
    @FXML
    public void alta_tareas() {
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);

        int id_alumno;
        int id_asignatura = id_asignatura_Con_id_profesor(id_profesor);

        for (int i = 0; i < valoresLista.size(); i++) {
            try {
                PreparedStatement pst = conn.prepareStatement("INSERT INTO tareas (id_profesor,id_asignatura,id_estudiante,nombre_tarea,tipo_tarea,fecha_inicio,fecha_fin,descripcion_tarea) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                String correo = valoresLista.get(i);
                String dniEstudiante = obtener_correo_dniEStudiante(correo);
                String nombre_tarea = _tfNombreTarea.getText();
                String tareas_cursos = cursos_por_dni(dniEstudiante);
                String casa = casa_por_dni(dniEstudiante);
                //String alumno = _cbTareas_alumnos.getValue();

                id_alumno = obtner_id_estudiante(dniEstudiante);
                String Tipo = _cbTareas_tipo.getValue();
                String fec_ini = _dpTareas_fechaIni.getValue().toString();
                String fec_fin = _dpTareas_fechaFin.getValue().toString();
                String descripcion = _taTareas_descripcion.getText();
                String destinatarios = _taTarea_destinatario.getText();

                //sql = "INSERT INTO estudiantes (nombre, apellidos, telefono, dni, fecha_nac, correo, pass, casa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                pst.setInt(1, id_profesor);
                pst.setInt(2, id_asignatura);
                pst.setInt(3, id_alumno);
                pst.setString(4, nombre_tarea);
                pst.setString(5, Tipo);
                pst.setString(6, fec_ini);
                pst.setString(7, fec_fin);
                pst.setString(8, descripcion);

                boolean a = pst.execute();

                if (!a) {

                    vaciarPanelTodo();
                    panelProfesores.setVisible(true);
                    _panelSalaComunProfes.setVisible(true);
                    Jopane("Añadido correctamente", "Añadir Tareas");
                    borrar_datos_registro();
                    _tbprofesores_semanal.getItems().clear();
                    rellenar_tablaProfesor_semanal(id_profesor);
                    _tfNombreTarea.setText("");
                    _taTarea_destinatario.setText("");
                    _taTareas_descripcion.setText("");
                    _cbTareas_cursos.getItems().set(0, "");
                    _cbTareas_alumnos.getItems().set(0, "");
                    _cbTareas_tipo.getItems().clear();
                    _cbTarea_casa.getItems().set(0, "");
                    _dpTareas_fechaFin.setValue(LocalDate.now());
                    _dpTareas_fechaIni.setValue(LocalDate.now());

                } else {
                    Jopane("Error", "Error al insertar");

                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////métodos Datos Tablas///////////////////////////////
    public ResultSet datos_para_correcciones(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT tareas.id_tarea, estudiantes.nombre, estudiantes.apellidos, estudiantes.curso, tareas.nombre_tarea, tareas.tipo_tarea, tareas.fecha_fin\n"
                    + "FROM alu_nurismy_agenda.estudiantes estudiantes, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE \n"
                    + "	tareas.id_estudiante = estudiantes.id_estudiante AND tareas.id_profesor = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param id_profesor tipo int autoencremental identifica al profesor
     * @return devuelve un conjunto de resultado para poder obtener las tareas
     * pendientes
     */
    public ResultSet datos_para_correccionesPendientes(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT tareas.id_tarea, estudiantes.nombre, estudiantes.apellidos, estudiantes.curso, tareas.nombre_tarea, tareas.tipo_tarea, tareas.fecha_fin\n"
                    + "FROM alu_nurismy_agenda.estudiantes estudiantes, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE \n"
                    + "	tareas.id_estudiante = estudiantes.id_estudiante AND tareas.id_profesor = ? AND tareas.corregido=0 ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet datos_para_tareas_alumnos(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT asignaturas.nombre AS nombre_asignatura, tareas.id_tarea, tareas.nombre_tarea, tareas.tipo_tarea, tareas.fecha_fin, tareas.archivo\n"
                    + "FROM alu_nurismy_agenda.asignaturas asignaturas, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE \n"
                    + "	tareas.id_asignatura = asignaturas.id_asignatura AND tareas.id_estudiante=? AND tareas.entregado=0", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet datos_tablaProfesores_semanal(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.nombre, estudiantes.apellidos, estudiantes.curso, tareas.nombre_tarea, tareas.tipo_tarea, tareas.fecha_fin, tareas.corregido\n"
                    + "FROM alu_nurismy_agenda.estudiantes estudiantes, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE \n"
                    + "	tareas.id_estudiante = estudiantes.id_estudiante AND tareas.id_profesor = ? AND fecha_fin BETWEEN CURRENT_DATE() AND DATE_ADD(CURRENT_DATE(), INTERVAL 7 DAY) AND tareas.corregido=0;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void comprobar() {

        if (_tbTarea_correciones.getSelectionModel().getSelectedItem() != null) {
            tareas_profesores_objeto p = _tbTarea_correciones.getSelectionModel().getSelectedItem();
            String id_tarea = p.getId_tarea();
            String nombre_alumno = p.getNombre();
            String apellidos_alumno = p.getApellidos();
            String nombreCompleto = nombre_alumno + " " + apellidos_alumno;
            _tfTareas_alumno.setText("");
            _tfTareas_alumno.setText(nombreCompleto);

        } else if (_tbTarea_correciones_pendientes.getSelectionModel().getSelectedItem() != null) {
            tareas_profesores_objeto x = _tbTarea_correciones_pendientes.getSelectionModel().getSelectedItem();
            String id_tareap = x.getId_tarea();
            String nombre_alumnop = x.getNombre();
            String apellidos_alumnop = x.getApellidos();
            String nombreCompletop = nombre_alumnop + " " + apellidos_alumnop;
            _tfTareas_alumno.setText("");
            _tfTareas_alumno.setText(nombreCompletop);

        } else {
            Jopane("Error", "No ha selecionado nada");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    //============================= FILTRAR DATOS ============================//
    ////////////////////////////////////////////////////////////////////////////
    public void filtrar_alumnos_asistencia_curso(int id_asigProf) {

        _comboP_AsistenciaCursos.valueProperty().addListener((ov, p1, p2) -> {
            if (_comboP_AsistenciaCasa.getValue() == null) {

                rellenar_tabla_asistencia(id_asigProf);

            } else {
                String casa = _comboP_AsistenciaCasa.getValue().toString();
                rellenar_tabla_asistencia_casaCurso(id_asigProf, p2, casa);
            }

        });

    }

    public void filtrar_alumnos_asistencia_casa(int id_asigProf) {

        _comboP_AsistenciaCasa.valueProperty().addListener((ov, p1, p2) -> {
            if (_comboP_AsistenciaCursos.getValue() == null) {

                rellenar_tabla_asistencia(id_asigProf);

            } else {
                String curso = _comboP_AsistenciaCursos.getValue().toString();
                rellenar_tabla_asistencia_casaCurso(id_asigProf, curso, p2);
            }

        });

    }

    //==========================metodo rellenar tabla asistencia combo cursos===============================
    public ResultSet alumnos_segun_curso_asistencia(int id_asigProf, String curso, String casa) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT asigEstu.*, estudiantes.*\n"
                    + "FROM alu_nurismy_agenda.asigEstu asigEstu, alu_nurismy_agenda.estudiantes estudiantes\n"
                    + "WHERE \n"
                    + "	asigEstu.id_estudiante = estudiantes.id_estudiante AND estudiantes.casa = ? AND estudiantes.curso = ? AND asigEstu.id_asigProf = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, casa);
            pst.setString(2, curso);
            pst.setInt(3, id_asigProf);
            rs = pst.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    //==========================metodo historial===============================

    public ResultSet alumnos_segun_curso_asistencia_historial(int asigProf, String casa, String curso) {
        ResultSet rs;
        System.out.println(asigProf);
        System.out.println(casa);
        System.out.println(curso);
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT asistencia.*, estudiantes.*\n"
                    + "FROM alu_nurismy_agenda.asistencia asistencia, alu_nurismy_agenda.estudiantes estudiantes\n"
                    + "WHERE \n"
                    + "	asistencia.id_estudiante = estudiantes.id_estudiante AND estudiantes.curso = ? AND estudiantes.casa = ? AND asistencia.id_asigProf = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, curso);
            pst.setString(2, casa);
            pst.setInt(3, asigProf);

            rs = pst.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //==========================metodo rellenar datos asistencia===============================
    public ResultSet datos_asistencia(int id_asigProf) {

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from asigEstu WHERE id_asigProf= ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet datos_asistencia1(int id_asigProf) {

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from asistencia WHERE id_asigProf=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet datosAlumnos_porId(int id_estudiante) {
        try {
            ResultSet rs;
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE id_estudiante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet datosAlumnos_porId_historial(int id_estudiante, int id_asigProg) {
        try {
            ResultSet rs;
            PreparedStatement pst = conn.prepareStatement("SELECT * from asistencia where id_estudiante=? AND id_asigProf=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            pst.setInt(2, id_asigProg);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //=============para rellenar asistencia================
    public void alumnosAsistencia_segun_casaYcurso(int id_asigProf) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT estudiantes.* \n"
                    + "FROM alu_nurismy_agenda.estudiantes\n"
                    + "WHERE id_estudiante IN (SELECT id_estudiante\n"
                    + "FROM alu_nurismy_agenda.asigEstu\n"
                    + "WHERE (id_asigProf) IN (?))AND estudiantes.casa=? AND estudiantes.curso=?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asigProf);
            pst.setString(2, _cbTarea_casa.getValue());
            pst.setString(3, _cbTareas_cursos.getValue());
            rs = pst.executeQuery();
            _cbTareas_alumnos.getItems().clear();
            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);
                _cbTareas_alumnos.getItems().addAll(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //===========enviar destinatarios tareas===========
    @FXML
    public List<String> insertar_destinatarios() {
        try {
            String alumno = _cbTareas_alumnos.getValue();
            String dni = alumno.substring(0, 9);
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE dni=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            if (!rs.first()) {
                Jopane("No se han encontrado datos al insertar destinatarios", "Error");
                return null;
            } else {

                String correo = rs.getString("correo");

                String email = correo;
                if (!valoresLista.contains(email)) {
                    valoresLista.add(email);
                }
                if (!_taTarea_destinatario.getText().contains(email)) {
                    _taTarea_destinatario.appendText(email + ", ");
                }
////          
                return valoresLista;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param correo tipo string con el correo del estudiante
     * @return devuelve el dni del estudiante
     */
    public String obtener_correo_dniEStudiante(String correo) {
        try {
            ResultSet rs = null;
            String sql = "SELECT * FROM estudiantes WHERE correo='" + correo + "'";
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
            if (!rs.first()) {
                Jopane("No se han encontrado datos al obtner el dni del estudiante por el correo", "Error");
                return null;
            } else {
                //rs = pst.executeQuery();
                String dni = rs.getString("dni");
                return dni;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //======================================================================================
    public String obtenerNombreProfesor_porID(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM profesores where id_profesor= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el nombre del profesor por id", "Error");
                return null;
            } else {
                String nombre = resultado.getString("nombre");
                return nombre;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String obtenerApellidoProfesor_porID(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM profesores where id_profesor= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el apellido del profesor por el id", "Error");
                return null;
            } else {
                String apellidos = resultado.getString("apellidos");
                return apellidos;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //======================================================================================
    public String obtenerNombreAlumno_porID(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes where id_estudiante= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos obtner el nombre del alumno por id", "Error");
                return null;
            } else {
                String nombre = resultado.getString("nombre");

                return nombre;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    //======================================================================================

    public String obtenerApellidoAlumno_porID(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes where id_estudiante= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el apellido del alumno por id", "Error");
                return null;
            } else {
                String apellido = resultado.getString("apellidos");

                return apellido;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //==========================================================================================
    /**
     *
     * @param id_asignatura tipo int incremental identifica a la asignatura
     * @return devuelve el nombre de la asignatura en un String
     */
    public String obtener_nombre_asignatura(int id_asignatura) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM asignaturas WHERE id_asignatura = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_asignatura);
            resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos obtener el nombre de la asignatura por su id", "Error");
                return null;
            } else {
                String nombre = resultado.getString("nombre");
                return nombre;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //========================Notas===========================================================
    public ObservableList<notas_objeto> rellenar_notas_alumnos(int id_estudiante) {

        ObservableList<notas_objeto> obs = FXCollections.observableArrayList();
        _columAlu_notas_asignatura.setCellValueFactory(new PropertyValueFactory<>("asignatura"));
        _columAlu_notas_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        _columAlu_notas_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columAlu_notas_nota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        _columAlu_notas.setCellValueFactory(new PropertyValueFactory<>("comentario"));

        try {
            ResultSet rs = rellenar_tabla_notas_alumno(id_estudiante);

            while (rs.next()) {

                int id_asignatura = rs.getInt("id_asignatura");
                String asignatura = obtener_nombre_asignatura(id_asignatura);
                String nombre_tarea = rs.getString("nombre_tarea");
                String tipo_tarea = rs.getString("tipo_tarea");
                String nota = rs.getString("nota");
                String comentario = rs.getString("comentario_profesor");
                notas_objeto t = new notas_objeto(asignatura, tipo_tarea, nombre_tarea, nota, comentario);
                obs.add(t);
                _tablaAlu_notas.getItems().addAll(t);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }
    //============================rellanar tabla sala comun alumnos con profesor==================================================================

    public ResultSet rellenar_tabla_notas_alumno(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT tareas.id_asignatura, tareas.tipo_tarea, tareas.nombre_tarea, notas.nota,  notas.comentario_profesor \n"
                    + "FROM alu_nurismy_agenda.notas notas, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE \n"
                    + "notas.id_tarea = tareas.id_tarea AND tareas.id_estudiante =?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //==========================================================================================
    public String obtener_nombre_tarea(int id_tarea) {
        ResultSet resultado;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM tareas WHERE id_tarea=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_tarea);
            resultado = pst.executeQuery();

            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el nombre de la tarea por su id", "Error");
                return null;
            } else {
                String nombre = resultado.getString("nombre");
                return nombre;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void notas_por_asignatura(int id_estudiante) {
        ResultSet rs;
        ArrayList a = new ArrayList();
        _jcFilto_notas_alumno.getItems().clear();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT asignaturas.nombre \n"
                    + "FROM alu_nurismy_agenda.asigEstu asigEstu, alu_nurismy_agenda.asigProf asigProf, alu_nurismy_agenda.asignaturas asignaturas\n"
                    + "WHERE \n"
                    + "	asigEstu.id_asigProf = asigProf.id_asigProf\n"
                    + "	AND asigProf.id_asignatura = asignaturas.id_asignatura AND id_estudiante = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            rs = pst.executeQuery();

            while (rs.next()) {
                String asignatura = rs.getString("nombre");
                String c = asignatura;

                a.add(c);
            }
            a.add(0, "Todas");

            _jcFilto_notas_alumno.getItems().addAll(a);
            _jcFilto_notas_alumno.getSelectionModel().select(0);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void filtras_notas_asignatura(int id_estudiante) {

        _jcFilto_notas_alumno.valueProperty().addListener((ov, p1, p2) -> {
            _tablaAlu_notas.getItems().clear();
            String asignatura;
            if (p2 == null) {
                asignatura = "Todas";
            } else {
                asignatura = p2.toString();
            }

            if (asignatura.equals("Todas") || asignatura == (null)) {
                rellenar_notas_alumnos(id_estudiante);
            } else {
                rellenar_notas_alumnos_por_asignaturas(id_estudiante, asignatura);

            }

        });
    }

    public ResultSet rellenar_tabla_notas_alumno_por_asignatura(int id_estudiante, String p2) {

        int id_asignatura = obtener_id_asignatura(p2);
        if (_jcFilto_notas_alumno.getItems().toString().equals(null)) {
            rellenar_notas_alumnos(id_estudiante);
        }

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT tareas.id_asignatura, tareas.tipo_tarea, "
                    + "tareas.nombre_tarea, notas.nota,  notas.comentario_profesor FROM alu_nurismy_agenda.asignaturas asignaturas, "
                    + "alu_nurismy_agenda.notas notas, alu_nurismy_agenda.tareas tareas WHERE notas.id_tarea = tareas.id_tarea "
                    + "AND tareas.id_estudiante =? AND tareas.id_asignatura = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            pst.setInt(2, id_asignatura);
            ResultSet rs = pst.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ObservableList<notas_objeto> rellenar_notas_alumnos_por_asignaturas(int id_estudiante, String p2) {

        ObservableList<notas_objeto> obs = FXCollections.observableArrayList();
        _columAlu_notas_asignatura.setCellValueFactory(new PropertyValueFactory<>("asignatura"));
        _columAlu_notas_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        _columAlu_notas_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columAlu_notas_nota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        _columAlu_notas.setCellValueFactory(new PropertyValueFactory<>("comentario"));

        try {
            ResultSet rs = rellenar_tabla_notas_alumno_por_asignatura(id_estudiante, p2);

            while (rs.next()) {

                int id_asignatura = rs.getInt("id_asignatura");
                String asignatura = obtener_nombre_asignatura(id_asignatura);

                String nombre_tarea = rs.getString("nombre_tarea");
                String tipo_tarea = rs.getString("tipo_tarea");
                String nota = rs.getString("nota");
                String comentario = rs.getString("comentario_profesor");
                notas_objeto t = new notas_objeto(asignatura, tipo_tarea, nombre_tarea, nota, comentario);
                obs.add(t);
                _tablaAlu_notas.getItems().addAll(t);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;

    }

    //========================rellenar sala comun alumno===========================================
    public ObservableList<tareas_alumnoConProfesor_objeto> rellenar_tareas_alumnos_semanal(int id_estudiante) {

        ObservableList<tareas_alumnoConProfesor_objeto> obs = FXCollections.observableArrayList();
        _columAluSema_asignatura.setCellValueFactory(new PropertyValueFactory<>("asignatura"));
        _columAluSema_profesor.setCellValueFactory(new PropertyValueFactory<>("profesor"));
        _columAluSema_tareas.setCellValueFactory(new PropertyValueFactory<>("nombre_tarea"));
        _columAluSema_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo_tarea"));
        _columAluSema_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha_fin"));
        tareas_alumnoConProfesor_objeto v = null;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM tareas WHERE id_estudiante = ? AND fecha_fin BETWEEN CURRENT_DATE() AND DATE_ADD(CURRENT_DATE(), INTERVAL 7 DAY);", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                int id_asignatura = rs.getInt("id_asignatura");
                String asignatura = obtener_nombre_asignatura(id_asignatura);
                String nombre_tarea = rs.getString("nombre_tarea");
                String tipo_tarea = rs.getString("tipo_tarea");
                String fecha_fin = rs.getString("fecha_fin");
                int id_profe = rs.getInt("id_profesor");
                String profesor = obtenerNombreProfesor_porID(id_profe);

                v = new tareas_alumnoConProfesor_objeto(asignatura, profesor, nombre_tarea, tipo_tarea, fecha_fin);
                obs.add(v);

            }
            _tablaAlum_salaComun.getItems().addAll(obs);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

//    //===============rellanar tabla sala comun alumnos con profesor=============
//    public ResultSet rellenar_tabla_salaComum_alu(int id_estudiante) {
//        try {
//            PreparedStatement pst = conn.prepareStatement("SELECT * FROM tareas WHERE id_estudiante = ? AND fecha_fin BETWEEN CURRENT_DATE() AND DATE_ADD(CURRENT_DATE(), INTERVAL 7 DAY);", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            pst.setInt(1, id_estudiante);
//            ResultSet resultado = pst.executeQuery();
//            if (!resultado.first()) {.....
//                return null;
//            } else {
//                return resultado;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PanelPrincipalCasasController.class
//                    .getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//
//    }
    public ResultSet rellenar_tabla_mensajeriaAlumnos(int id_estudiante) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM mensajes WHERE id_estudiante =? ORDER BY leido DESC ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet rellenar_tabla_mensajeriaProfesor(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM mensajes_profesor WHERE id_profesor =? ORDER BY leido DESC ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);
            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void rellenar_tabla_asistencia_casaCurso_historial(int id_asigProf, String curso, String casa) {
        Alumnos_asistencia_objeto p = null;
        ArrayList<Integer> ids = new ArrayList();

        try {
            ObservableList<Alumnos_asistencia_objeto> obs = FXCollections.observableArrayList();
            _columP_nombre1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            _columP_apellidos1.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            _columP_dni1.setCellValueFactory(new PropertyValueFactory<>("dni"));
            columP_asistencia21.setCellValueFactory(new PropertyValueFactory<>("estado"));
            columP_asistencia_fecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));

            curso = _comboP_AsistenciaCursos1.getValue().toString();
            casa = _comboP_AsistenciaCasa1.getValue().toString();

            ResultSet rs = alumnos_segun_curso_asistencia_historial(id_asigProf, casa, curso);

            while (rs.next()) {
                int id_estudiante = rs.getInt("id_estudiante");
                ids.add(id_estudiante);
            }
            for (int i = 0; i < ids.size(); i++) {
                ResultSet rst = datosAlumnos_porId_historial(ids.get(i), id_asigProf);
                if (rst.first()) {
                    int id_estudiante = ids.get(i);
                    String nombre = obtenerNombreAlumno_porID(id_estudiante);
                    String apellidos = obtenerApellidoAlumno_porID(id_estudiante);
                    String dni = obtner_dni_estudiante(id_estudiante);
                    String estado = rst.getString("estado");

                    String fecha = rst.getString("Fecha");

                    p = new Alumnos_asistencia_objeto(nombre, apellidos, dni, estado, fecha);
                    obs.add(p);
                }
                _tablaP_asistencia1.getItems().clear();
                _tablaP_asistencia1.getItems().addAll(obs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //metodo para  rellenar tabla asistencia alumnos historial (FENIX)

    public ObservableList<Alumnos_asistencia_objeto> rellenar_tabla_asistencia_historial(int id_profesor) {
        int id_asigProf = obtener_id_asigProf_por_idProfesor(id_profesor);

        ObservableList<Alumnos_asistencia_objeto> obs = FXCollections.observableArrayList();
        _columP_nombre1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        _columP_apellidos1.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        _columP_dni1.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columP_asistencia21.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columP_asistencia_fecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));

        String nombre = null;
        Alumnos_asistencia_objeto x = null;
        try {
            ResultSet rs = datos_asistencia1(id_asigProf);
            while (rs.next()) {
                int id = rs.getInt("id_estudiante");
                ResultSet rst = datosAlumnos_porId_historial(id, id_asigProf);
                while (rst.next()) {
                    int id_estudiante = rst.getInt("id_estudiante");
                    nombre = obtenerNombreAlumno_porID(id_estudiante);
                    String apellidos = obtenerApellidoAlumno_porID(id_estudiante);
                    String dni = obtner_dni_estudiante(id_estudiante);
                    id_asigProf = rst.getInt("id_asigProf");

                    String estado = rst.getString("estado");
                    String fecha = rst.getString("Fecha");

                    x = new Alumnos_asistencia_objeto(nombre, apellidos, dni, estado, fecha);
                    obs.add(x);
                }
                _tablaP_asistencia1.getItems().clear();
                _tablaP_asistencia1.getItems().addAll(obs);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            Jopane("Error", "Error al rellenar la tabla asistencias");
        }
        return obs;
    }

    public void cambiarImagenAsignaturas_Notas(int id_estudiante) {

        ArrayList asignaturas = new ArrayList();

        asignaturas = array_asignaturas_del_alumno(id_estudiante);

        Image image1 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignaturas.get(0).toString().toLowerCase() + ".png"));
        ImageView imageView1 = new ImageView(image1);
        Image image2 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignaturas.get(1).toString().toLowerCase() + ".png"));
        ImageView imageView2 = new ImageView(image2);

        Image image3 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignaturas.get(2).toString().toLowerCase() + ".png"));
        ImageView imageView3 = new ImageView(image3);

        Image image4 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignaturas.get(3).toString().toLowerCase() + ".png"));
        ImageView imageView4 = new ImageView(image4);

        Image image5 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignaturas.get(4).toString().toLowerCase() + ".png"));
        ImageView imageView5 = new ImageView(image5);

        Image image6 = new Image(getClass().getResourceAsStream("/img/asignaturas/" + asignaturas.get(5).toString().toLowerCase() + ".png"));
        ImageView imageView6 = new ImageView(image6);

        _imagNotas1.setImage(image1);
        int id_asignatura1 = obtener_id_asignatura(asignaturas.get(0).toString());
        float nota = devolver_media_notas(id_asignatura1, id_estudiante);
        _labelNotas1.setText(String.valueOf(nota));
        _imagNotas2.setImage(image2);
        int id_asignatura2 = obtener_id_asignatura(asignaturas.get(1).toString());
        _labelNotas2.setText(String.valueOf(devolver_media_notas(id_asignatura2, id_estudiante)));
        _imagNotas3.setImage(image3);
        int id_asignatura3 = obtener_id_asignatura(asignaturas.get(2).toString());
        _labelNotas3.setText(String.valueOf(devolver_media_notas(id_asignatura3, id_estudiante)));
        _imagNotas4.setImage(image4);
        int id_asignatura4 = obtener_id_asignatura(asignaturas.get(3).toString());
        _labelNotas4.setText(String.valueOf(devolver_media_notas(id_asignatura4, id_estudiante)));
        _imagNotas5.setImage(image5);
        int id_asignatura5 = obtener_id_asignatura(asignaturas.get(4).toString());
        _labelNotas5.setText(String.valueOf(devolver_media_notas(id_asignatura5, id_estudiante)));
        _imagNotas6.setImage(image6);
        int id_asignatura6 = obtener_id_asignatura(asignaturas.get(5).toString());
        _labelNotas6.setText(String.valueOf(devolver_media_notas(id_asignatura6, id_estudiante)));

    }

    public float devolver_media_notas(int id_asignatura, int id_estudiante) {
        float notas_total;

        ResultSet rs;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT notas.*, tareas.*,SUM(nota) as suma_notas\n"
                    + "FROM alu_nurismy_agenda.notas notas, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE notas.id_tarea = tareas.id_tarea AND tareas.id_estudiante =? AND tareas.id_asignatura =?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            pst.setInt(2, id_asignatura);
            rs = pst.executeQuery();
            if (!rs.first()) {
                return 0;
            } else {
                notas_total = rs.getFloat("suma_notas");
                float numero_notas = devolver_numero_notas(id_asignatura, id_estudiante);
                if (numero_notas == 0) {
                    return 0;
                } else {
                    float media = notas_total / numero_notas;
                    return media;

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public float devolver_numero_notas(int id_asignatura, int id_estudiante) {
        float notas_total;

        ResultSet rs;
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT notas.*, tareas.*,COUNT(nota) as numero_notas \n"
                    + "FROM alu_nurismy_agenda.notas notas, alu_nurismy_agenda.tareas tareas\n"
                    + "WHERE notas.id_tarea = tareas.id_tarea AND tareas.id_estudiante =? AND tareas.id_asignatura =?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            pst.setInt(2, id_asignatura);
            rs = pst.executeQuery();
            if (!rs.first()) {
                return 0;
            } else {
                notas_total = rs.getFloat("numero_notas");
                return notas_total;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public ArrayList array_asignaturas_del_alumno(int id_estudiante) {
        ResultSet rs;
        ArrayList a = new ArrayList();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT asignaturas.nombre \n"
                    + "FROM alu_nurismy_agenda.asigEstu asigEstu, alu_nurismy_agenda.asigProf asigProf, alu_nurismy_agenda.asignaturas asignaturas\n"
                    + "WHERE \n"
                    + "	asigEstu.id_asigProf = asigProf.id_asigProf\n"
                    + "	AND asigProf.id_asignatura = asignaturas.id_asignatura AND id_estudiante = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_estudiante);
            rs = pst.executeQuery();

            while (rs.next()) {
                String asignatura = rs.getString("nombre");
                String c = asignatura;

                a.add(c);
            }
            return a;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void iconosPanelAsignaturas(int id_estudiante) {

        ArrayList asignaturas = new ArrayList();
        asignaturas = array_asignaturas_del_alumno(id_estudiante);

        ArrayList asignaturas2 = new ArrayList();
        for (int i = 0; i > asignaturas.size(); i++) {
            String primeraLetra = asignaturas.get(i).toString().substring(0, 1);
            String primeraLetraMayuscula = primeraLetra.toUpperCase();
            String strModificado = primeraLetraMayuscula + asignaturas.get(i).toString().substring(1);
            asignaturas2.add("_asignatura" + strModificado);
        }

        ArrayList<ImageView> a = new ArrayList();

        a.add(_asignaturaAdivinacion);
        a.add(_asignaturaPociones);
        a.add(_asignaturaRunas);
        a.add(_asignaturaVuelo);
        a.add(_asignaturaTransformaciones);
        a.add(_asignaturaHistoria);
        a.add(_asignaturaDefensa);
        a.add(_asignaturaCriaturas);
        a.add(_asignaturaEncantamientos);

        for (int z = 0; z < asignaturas2.size(); z++) {
            String aaaa = a.get(z).getId().toString();
            String bbb = asignaturas2.get(z).toString();
            if (aaaa.equals(bbb)) {

                a.get(z).setVisible(true);
            } else {
                a.get(z).setVisible(false);
            }
        }

    }

    //==========================Guardar datos de asistencia de la tabla asistencia===============================
    public void guardar_botones_asistencia(String estado) {
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);

        Alumnos_asistencia_objeto a = _tablaP_asistencia.getSelectionModel().getSelectedItem();
        String dni_alumno = a.getDni();
        int id_estudiante = obtner_id_estudiante(dni_alumno);
        int id_asigProf = obtener_id_asigProf_por_idProfesor(id_profesor);

        String fecha = LocalDate.now().toString();

        {
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO alu_nurismy_agenda.asistencia\n"
                        + "(id_estudiante, id_asigProf, estado, Fecha)\n"
                        + "VALUES(?, ?, ?, ?);");
                ps.setInt(1, id_estudiante);
                ps.setInt(2, id_asigProf);
                ps.setString(3, estado);
                ps.setString(4, fecha);
                int s = ps.executeUpdate();
                if (s < 1) {
                    Jopane("No se ha podido actualizar la asistencia", "Error Guardar Asistencia");
                } else {
                    Jopane("Asistencia actualizada correctamente", "Guardar Asistencia");
                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     *
     * @param event evento en el boton guardar asistencia alumnos
     */
    @FXML
    private void guardar_Asistencias_Alumnos(MouseEvent event) {
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);
        String botonElegido = ((Button) event.getSource()).getText();
        System.out.println(botonElegido);

        switch (botonElegido) {
            case "Presente":
                guardar_botones_asistencia("Presente");

                break;

            case "Ausente":
                guardar_botones_asistencia("Ausente");
                break;
            case "Retraso":
                guardar_botones_asistencia("Retraso");
                break;

        }

    }

    /**
     *
     * @param event evento el el boton historal asistencia para cambiar panel
     */
    @FXML
    private void cambiarPanel_historial_asistencia(MouseEvent event) {
        vaciarPanelTodo();
        panelProfesores.setVisible(true);
        _comboP_AsistenciaCursos1.getItems().addAll("Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo");
        _comboP_AsistenciaCasa1.getItems().addAll("Gryffindor", "Slytherin", "Hafflepuff", "Ravenclaw");
        _panelHistorialAsistencia.setVisible(true);
    }

/////////////////////////////////////MENSAJERIA////////////////////////////////////////////////////////////////
    @FXML
    public void cambiarMensajeria() {// PROFESORES
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);
        vaciarPanelTodo();
        tablaP_listar_mensajes.getItems().clear();
        rellenar_tabla_mensajesP(id_profesor);
        combo_mensajeria_alumnos.getItems().clear();
        filtar_combo_mensajeria_profesores();
        panelProfesores.setVisible(true);
        _paneMensajeria.setVisible(true);
        textarea_mensajeria.setVisible(false);
        label_mensajeP.setVisible(false);
        botonP_cerrar_mensaje.setVisible(false);

//        TableColumn<mensajeria_objeto,String> columna=(TableColumn<mensajeria_objeto,String>) tablaA_listar_mensajes1.getColumns().get(0);
//        columna.setVisible(false); ->INTENTO DE ELIMINAR LA COLUMNA ID DE LA COLUMNA MENSAJES ALUMNOS.
    }

    @FXML
    public void cambiarMensajeria_alumnos() {
        String dni = pruebaInicio.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        vaciarPanelTodo();
        tablaA_listar_mensajes1.getItems().clear();
        rellenar_tabla_mensajesA(id_estudiante);
        combo_mensajeria_alumnos1.getItems().clear();
        filtar_combo_mensajeria_alumnos();
        panelAlumnos.setVisible(true);
        _panelMensajeria_alumnos.setVisible(true);
        textarea_mensajeria1.setVisible(false);
        label_mensaje_alumnos.setVisible(false);
        boton_cerrar.setVisible(false);

    }

    @FXML
    public void botonGuardarMensajeria_profesores() {
        String dniP = pruebaInicio.getText();
        try {
            String datos_completos = combo_mensajeria_alumnos.getValue().toString();
            String dni = datos_completos.substring(0, 9);
            String texto = textArea_menaje_editar.getText();
            int id_profesor = obtener_id_profesor(dni);
            int id_estudiante = obtner_id_estudiante(dni);
            String fecha = LocalDate.now().toString();

            PreparedStatement pst = conn.prepareStatement("INSERT INTO alu_nurismy_agenda.mensajes (id_profesor, id_estudiante, mensaje, fecha) VALUES (?, ?, ?, ?)");
            pst.setInt(1, id_profesor);
            pst.setInt(2, id_estudiante);
            pst.setString(3, texto);
            pst.setString(4, fecha);

            int comprobar = pst.executeUpdate();
            textArea_menaje_editar.clear();

            if (comprobar > 0) {
                Jopane("Mensaje enviado", "Enviar mensaje");
            } else {
                Jopane("Error al enviar mensaje", "Enviar mensaje");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void botonGuardarMensajeria_Alumnos() {
        try {
            String datos_completos = combo_mensajeria_alumnos1.getValue().toString();

            String texto = textArea_menaje_editar1.getText();
            int id_profesor = obtener_id_profesor(datos_completos.substring(0, datos_completos.indexOf("-")).trim());
            int id_estudiante = obtner_id_estudiante(pruebaInicio.getText());
            String fecha = LocalDate.now().toString();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO alu_nurismy_agenda.mensajes_profesor (id_estudiante, id_profesor, mensaje, fecha) VALUES (?, ?, ?, ?)");
            pst.setInt(1, id_estudiante);
            pst.setInt(2, id_profesor);
            pst.setString(3, texto);
            pst.setString(4, fecha);

            int comprobar = pst.executeUpdate();
            textArea_menaje_editar1.clear();
            if (comprobar > 0) {
                Jopane("Mensaje enviado", "Enviar mensaje");
            } else {
                Jopane("Error al enviar mensaje", "Enviar mensaje");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void filtar_combo_mensajeria_profesores() {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT nombre, apellidos, dni  FROM estudiantes", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = pst.executeQuery();
            combo_mensajeria_alumnos.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);

            }
            combo_mensajeria_alumnos.getItems().addAll(a);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void filtar_combo_mensajeria_alumnos() {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT nombre, apellidos, dni  FROM profesores", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = pst.executeQuery();
            combo_mensajeria_alumnos1.getItems().clear();

            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String c = dni + " - " + nombre + " " + apellidos;
                a.add(c);

            }
            combo_mensajeria_alumnos1.getItems().addAll(a);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void mostrar_mensajesAlumnos() {
        String dni = pruebaInicio.getText();
        int id_estudiante = obtner_id_estudiante(dni);
        try {
            boton_mostrarMensaje_alumnos.setVisible(false);
            textarea_mensajeria1.setVisible(true);
            label_mensaje_alumnos.setVisible(true);
            boton_cerrar.setVisible(true);

            // Obtener los datos de la fila seleccionada
            mensajeria_objeto objetoSeleccionado = tablaA_listar_mensajes1.getSelectionModel().getSelectedItem();
            int id_mensaje = objetoSeleccionado.id;

            try {
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM mensajes where id_mensaje= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst.setInt(1, id_mensaje);

                ResultSet rs = pst.executeQuery();
                if (rs.first()) {
                    String mensaje = rs.getString("mensaje");
                    // Rellenar el TextArea con el texto a mostrar
                    textarea_mensajeria1.setText(mensaje);

                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            // cambiar el menasaje a leido en alumnos y refescar la tabla de alumnos
            PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.mensajes SET leido=1 WHERE id_mensaje= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_mensaje);
            int comprobar = pst.executeUpdate();
            if (comprobar > 0) {
                Jopane("Mensaje enviado", "Enviar mensaje");
            } else {
                Jopane("Error al enviar mensaje", "Enviar mensaje");
            }
            tablaA_listar_mensajes1.getItems().clear();
            rellenar_tabla_mensajesA(id_estudiante);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void mostrar_mensajesProfesor() {
        String dni = pruebaInicio.getText();
        int id_profesor = obtener_id_profesor(dni);
        try {
            botonP_mostar_mensaje.setVisible(false);
            textarea_mensajeria.setVisible(true);
            label_mensajeP.setVisible(true);
            botonP_cerrar_mensaje.setVisible(true);

            // Obtener los datos de la fila seleccionada
            mensajeria_objeto objetoSeleccionado = tablaP_listar_mensajes.getSelectionModel().getSelectedItem();
            int id_mensaje = objetoSeleccionado.id;

            try {
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM mensajes_profesor where id_mensaje_profesor= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst.setInt(1, id_mensaje);

                ResultSet rs = pst.executeQuery();
                if (rs.first()) {
                    String mensaje = rs.getString("mensaje");
                    // Rellenar el TextArea con el texto a mostrar
                    textarea_mensajeria.setText(mensaje);

                }

            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            // cambiar el menasaje a leido en profesor y refescar la tabla de profesor
            PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.mensajes_profesor SET leido=1 WHERE id_mensaje_profesor= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_mensaje);
            pst.executeUpdate();

            tablaP_listar_mensajes.getItems().clear();
            rellenar_tabla_mensajesP(id_profesor);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void boton_cerrar_mensajeA() {
        boton_mostrarMensaje_alumnos.setVisible(true);
        textarea_mensajeria1.setVisible(false);
        label_mensaje_alumnos.setVisible(false);
        boton_cerrar.setVisible(false);
        textarea_mensajeria1.setText("");

    }

    @FXML
    public void boton_cerrar_mensajeP() {
        botonP_mostar_mensaje.setVisible(true);
        textarea_mensajeria.setVisible(false);
        label_mensajeP.setVisible(false);
        botonP_cerrar_mensaje.setVisible(false);
        textarea_mensajeria.setText("");

    }

    public String obtener_dniProfesor_porID(int id_profesor) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM profesores where id_profesor= ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_profesor);

            ResultSet rs = pst.executeQuery();
            if (rs.first()) {
                String dni = rs.getString("dni");
                return dni;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ObservableList<mensajeria_objeto> rellenar_tabla_mensajesA(int id_estudiante) {

        String estado_leido = "";
        ObservableList<mensajeria_objeto> obs = FXCollections.observableArrayList();
        columP_Id_mensajeria1.setCellValueFactory(new PropertyValueFactory<>("id"));
        columP_nombre_mensajeria1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columP_apellidos_mensajeria1.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columP_fecha_mensajeria1.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columP_leidos_mensajeria1.setCellValueFactory(new PropertyValueFactory<>("leidos"));

        try {
            ResultSet rs = rellenar_tabla_mensajeriaAlumnos(id_estudiante);

            while (rs.next()) {
                int id_profesor = rs.getInt("id_profesor");
                int id_mensaje = rs.getInt("id_mensaje");
                String nombre = obtenerNombreProfesor_porID(id_profesor);
                String apellidos = obtenerApellidoProfesor_porID(id_profesor);

                String fecha = rs.getString("fecha");
                boolean leido = rs.getBoolean("leido");
                if (leido == false) {
                    estado_leido = "No leído";
                } else {
                    estado_leido = "Leído";
                }

                mensajeria_objeto v = new mensajeria_objeto(id_mensaje, nombre, apellidos, fecha, estado_leido);
                obs.add(v);
                tablaA_listar_mensajes1.getItems().addAll(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public ObservableList<mensajeria_objeto> rellenar_tabla_mensajesP(int id_profesor) {
        String estado_leido = "";
        ObservableList<mensajeria_objeto> obs = FXCollections.observableArrayList();
        columP_id_mensajeria.setCellValueFactory(new PropertyValueFactory<>("id"));
        columP_nombre_mensajeria.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columP_apellidos_mensajeria.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columP_curso_mensajeria.setCellValueFactory(new PropertyValueFactory<>("curso"));
        columP_fecha_mensajeria.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columP_leidos_mensajeria.setCellValueFactory(new PropertyValueFactory<>("leidos"));

        try {
            ResultSet rs = rellenar_tabla_mensajeriaProfesor(id_profesor);

            while (rs.next()) {

                int id_mensaje = rs.getInt("id_mensaje_profesor");
                int id_estudiante = rs.getInt("id_estudiante");
                String nombre = obtenerNombreAlumno_porID(id_estudiante);
                String apellidos = obtenerApellidoAlumno_porID(id_estudiante);
                String dni = obtner_dni_estudiante(id_estudiante);
                String curso = cursos_por_dni(dni);
                String fecha = rs.getString("fecha");
                boolean leido = rs.getBoolean("leido");
                if (leido == false) {
                    estado_leido = "No leído";
                } else {
                    estado_leido = "Leído";
                }

                mensajeria_objeto v = new mensajeria_objeto(id_mensaje, nombre, apellidos, curso, fecha, estado_leido);
                obs.add(v);
                tablaP_listar_mensajes.getItems().addAll(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    //////////////////////////////////////IMAGEN PERFIL ALUMNO////////////////////////////////////////////////////////
    @FXML
    private void cambiarImagenPerfil() {
        // Abre el cuadro de diálogo de selección de archivo
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                // Actualiza la imagen en la ImageView con la imagen seleccionada
                _imagen_perfil.setImage(new Image(selectedFile.toURI().toURL().toExternalForm()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void guardarCorrecciones() {

        try {
            tareas_profesores_objeto p = _tbTarea_correciones.getSelectionModel().getSelectedItem();
            int id_tarea = Integer.valueOf(p.getId_tarea());

            int id = Integer.valueOf(p.getId_tarea());
            String comentario = _tfTareasComentario.getText();
            double nota = Double.valueOf(_tfTareasNota.getText());
            int id_estudiante = obtener_id_estudiante_por_id_tarea(id_tarea);

            PreparedStatement pst = conn.prepareStatement("UPDATE tareas SET corregido=1 WHERE id_tarea=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_tarea);

            int comprobar = pst.executeUpdate();
            if (comprobar > 0) {
                Jopane("Se ha ejecutado correctamente", "Gurdar Correcion");
            } else {
                Jopane("Error al ejecutar", "Guardar Correcion");
            }

            PreparedStatement pst2 = conn.prepareStatement("INSERT INTO alu_nurismy_agenda.notas\n"
                    + "(id_tarea, id_estudiante, nota, comentario_profesor)\n"
                    + "VALUES(?, ?, ?, ?);", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst2.setInt(1, id_tarea);
            pst2.setInt(2, id_estudiante);
            pst2.setDouble(3, nota);
            pst2.setString(4, comentario);

            pst2.executeUpdate();

            _tfTareasComentario.setText("");
            _tfTareasNota.setText("");
            _tfTareas_alumno.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void progressBar() {
        LocalDate START_DATE = LocalDate.of(2022, 9, 15);
        LocalDate END_DATE = LocalDate.of(2023, 6, 22);
        DoubleProperty progressProperty = new SimpleDoubleProperty();

        // Calculate the duration of the date range
        long totalDays = ChronoUnit.DAYS.between(START_DATE, END_DATE);

        // Update the progress property based on the current date
        long daysElapsed = ChronoUnit.DAYS.between(START_DATE, LocalDate.now());
        progressProperty.set((double) daysElapsed / totalDays);

        _progressBar_Trimestre.progressProperty().bind(progressProperty);
    }

    /**
     *
     * @param id_tarea int autoincremental que identifica la tarea
     * @return devuelve el id del estudiante
     */
    public int obtener_id_estudiante_por_id_tarea(int id_tarea) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM tareas where id_tarea=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id_tarea);
            ResultSet resultado = pst.executeQuery();
            if (!resultado.first()) {

                Jopane("No se han encontrado datos al obtener el id estudiante por el id tarea", "Error");
                return -1;
            } else {
                int id_estudiante = resultado.getInt("id_estudiante");
                System.out.println(id_estudiante);
                return id_estudiante;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    // abrir administrador
    @FXML
    public void abrir_administrador_alumnos() {
        vaciarPanelTodo();
        botonAD_modificar.setVisible(true);
        botonAD_eliminar.setVisible(true);
        tablaAd_alumnos.setVisible(true);
        botonAD_eliminarP.setVisible(false);
        botonAD_ModificarP.setVisible(false);
        tablaAd_alumnos1.setVisible(false);
        labelAdministadorTabla.setText("Administar Alumnos");
        panelMenuLateral1.setVisible(true);
        panelAdministrador.setVisible(true);
        _panelAdministadorAlumnos.setVisible(true);
        rellenar_tabla_aluAdministrador();

    }

    @FXML
    public void abrir_administrador_profesorTabla() {
        vaciarPanelTodo();
        rellenar_tabla_ProfAdministrador();
        botonAD_eliminarP.setVisible(true);
        botonAD_ModificarP.setVisible(true);
        botonAD_modificar.setVisible(false);
        botonAD_eliminar.setVisible(false);
        labelAdministadorTabla.setText("Administar Profesor");
        tablaAd_alumnos.setVisible(false);
        tablaAd_alumnos1.setVisible(true);
        panelMenuLateral1.setVisible(true);
        panelAdministrador.setVisible(true);
        _panelAdministadorAlumnos.setVisible(true);
        rellenar_tabla_aluAdministrador();

    }

    public void abrir_administrador_profesores() {
        vaciarPanelTodo();
        panelMenuLateral1.setVisible(true);
        panelAdministrador.setVisible(true);
        _panelAdministrador_profesor.setVisible(true);

    }

    @FXML
    public void abrir_modificar_estudiante() {
        vaciarPanelTodo();
        modificarAlumnos_administrador();
        panelMenuLateral1.setVisible(true);
        panelAdministrador.setVisible(true);
        _panelAdministradorConfiguracion.setVisible(true);

    }
//=======================panel administrador==========================================================

    public ResultSet datos_adminAlumnos() {

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from estudiantes",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    // rellenar tabla alumnos
    public ObservableList<Alumnos_objeto> rellenar_tabla_aluAdministrador() {

        tablaAd_alumnos.getItems().clear();
        ObservableList<Alumnos_objeto> obs = FXCollections.observableArrayList();
        columAD_dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columAD_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columAD_apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columAD_casa.setCellValueFactory(new PropertyValueFactory<>("casa"));
        columAD_curso.setCellValueFactory(new PropertyValueFactory<>("curso"));

        Alumnos_objeto b = null;
        try {
            ResultSet rs = datos_adminAlumnos();
            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String casa = rs.getString("casa");
                String curso = rs.getString("curso");

                b = new Alumnos_objeto(nombre, apellidos, curso, casa, dni);
                obs.add(b);

                tablaAd_alumnos.getItems().addAll(b);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Jopane("Error", "Error al rellenar la tabla asistencias");
        }
        return obs;
    }
// ================boton modificar===============================================

    public void modificarAlumnos_administrador() {
        Alumnos_objeto objetoSeleccionado = tablaAd_alumnos.getSelectionModel().getSelectedItem();
        String dni = objetoSeleccionado.dni;

        if (String.valueOf(dni).equals("")) {
            Jopane("No se ha seleccionado ninguna fila", "Error al obtener datos");
        } else {
            try {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM estudiantes WHERE dni=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //falta actualizar sin contraseña
                pst.setString(1, dni);
                ResultSet rs = pst.executeQuery();
                if (rs.first()) {
                    _tfNombreEstudiante1.setText(rs.getString("nombre"));
                    _tfApellidosEstudiante1.setText(rs.getString("apellidos"));
                    _tfDniEstudiante1.setText(rs.getString("dni"));
                    _tfTelefonoEstudiante1.setText(rs.getString("telefono"));
                    _tfEmailEstudiante1.setText(rs.getString("correo"));
                    _tfFechaNacEstudiante1.setText(rs.getString("fecha_nac"));
                    String curso = rs.getString("curso");
                    _cbCursos1.setValue(curso);

                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    // modificar configuracion
    @FXML
    public void guardarModificacion_alumAD() {

        try {

            String nombre = _tfNombreEstudiante1.getText();
            String apellidos = _tfApellidosEstudiante1.getText();
            String dni = _tfDniEstudiante1.getText();
            int id_estudiante = obtner_id_estudiante(dni);
            String telefono = _tfTelefonoEstudiante1.getText();
            String email = _tfEmailEstudiante1.getText();
            String fechanac = _tfFechaNacEstudiante1.getText();
            String curso = _cbCursos1.getValue();

            PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.estudiantes\n"
                    + "SET nombre=?, apellidos=?, telefono=?, dni=?, fecha_nac=?, correo=?, curso=?\n"
                    + "WHERE id_estudiante=?;");
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, telefono);
            pst.setString(4, dni);
            pst.setString(5, fechanac);
            pst.setString(6, email);
            pst.setString(7, curso);
            pst.setInt(8, id_estudiante);

            int comprobar = pst.executeUpdate();
            if (comprobar < 1) {
                Jopane("Se ha ejecutado correctamente", "Modificar alumno");
            } else {
                Jopane("Error al ejecutar", "Modificar alumno");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //=================boton eliminar========
    @FXML
    public void eliminarEstudiante() {
        Alumnos_objeto objetoSeleccionado = tablaAd_alumnos.getSelectionModel().getSelectedItem();
        String dni = objetoSeleccionado.dni;

        if (String.valueOf(dni).equals("")) {
            Jopane("No se ha seleccionado ninguna fila", "Error al obtener datos");
        } else {
            try {

                PreparedStatement pst = conn.prepareStatement("DELETE FROM estudiantes WHERE dni=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //falta actualizar sin contraseña
                pst.setString(1, dni);

                int comprobar = pst.executeUpdate();
                if (comprobar < 1) {
                    Jopane("Se ha ejecutado correctamente", "Eliminar alumno");
                } else {
                    Jopane("Error al ejecutar", "Wliminar alumno");
                }

                tablaAd_alumnos.getItems().clear();
                rellenar_tabla_aluAdministrador();

            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    // rellenar tabla Profesor======================================================================

    public ResultSet datos_adminProfesor() {

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from profesores",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultado = pst.executeQuery();
            return resultado;

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ObservableList<Profesores_objeto> rellenar_tabla_ProfAdministrador() {

        tablaAd_alumnos1.getItems().clear();
        ObservableList<Profesores_objeto> obs = FXCollections.observableArrayList();
        columAD_dni1.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columAD_nombre1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columAD_apellidos1.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columAD_casa1.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        columAD_curso1.setCellValueFactory(new PropertyValueFactory<>("Correo"));

        Profesores_objeto v = null;
        try {
            ResultSet rs = datos_adminProfesor();
            while (rs.next()) {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String email = rs.getString("correo");

                v = new Profesores_objeto(dni, nombre, apellidos, telefono, email);
                obs.add(v);

            }
            tablaAd_alumnos1.getItems().addAll(obs);

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Jopane("Error", "Error al rellenar la tabla asistencias");
        }
        return obs;
    }

    // ================boton modificar Profesores===============================================
    @FXML
    public void modificarProfesores_administrador() {
        _panelAdministadorAlumnos.setVisible(false);
        _panelAdministrador_profesor.setVisible(true);
        Profesores_objeto objetoSeleccionado = tablaAd_alumnos1.getSelectionModel().getSelectedItem();
        String dni = objetoSeleccionado.dni;

        if (String.valueOf(dni).equals("")) {
            Jopane("No se ha seleccionado ninguna fila", "Error al obtener datos");
        } else {
            try {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM profesores WHERE dni=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //falta actualizar sin contraseña
                pst.setString(1, dni);
                ResultSet rs = pst.executeQuery();
                if (rs.first()) {
                    _tfNombreEstudiante11.setText(rs.getString("nombre"));
                    _tfApellidosEstudiante11.setText(rs.getString("apellidos"));
                    _tfDniEstudiante11.setText(rs.getString("dni"));
                    _tfTelefonoEstudiante11.setText(rs.getString("telefono"));
                    _tfEmailEstudiante11.setText(rs.getString("correo"));
                    _tfFechaNacEstudiante11.setText(rs.getString("fecha_nac"));
                    _tfPassEstudiante11.setText(rs.getString("pass"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    // modificar configuracion profesor
    @FXML
    public void guardarModificacion_ProfesorAD() {

        try {

            String nombre = _tfNombreEstudiante11.getText();
            String apellidos = _tfApellidosEstudiante11.getText();
            String dni = _tfDniEstudiante11.getText();
            int id_profesor = obtener_id_profesor(dni);
            String telefono = _tfTelefonoEstudiante11.getText();
            String email = _tfEmailEstudiante11.getText();
            String fechanac = _tfFechaNacEstudiante11.getText();
            String pass = _tfPassEstudiante11.getText();

            PreparedStatement pst = conn.prepareStatement("UPDATE alu_nurismy_agenda.profesores\n"
                    + "SET nombre=?, apellidos=?, telefono=?, dni=?, fecha_nac=?, correo=?, pass=?\n"
                    + "WHERE id_profesor=?;");
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, telefono);
            pst.setString(4, dni);
            pst.setString(5, fechanac);
            pst.setString(6, email);
            pst.setString(7, pass);
            pst.setInt(8, id_profesor);

            int comprobar = pst.executeUpdate();
            if (comprobar < 1) {
                Jopane("No se ha podido modificar", "Modificar profesor");
            } else {
                Jopane("Se ha modificado correctamente", "Modificar profesor");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelPrincipalCasasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //=================boton eliminar profesor========
    @FXML
    public void eliminarProfesor() {
        Profesores_objeto objetoSeleccionado = tablaAd_alumnos1.getSelectionModel().getSelectedItem();
        String dni = objetoSeleccionado.dni;

        if (String.valueOf(dni).equals("")) {
            Jopane("No se ha seleccionado ninguna fila", "Error al obtener datos");
        } else {

            String sql = "DELETE FROM profesores WHERE dni=" + dni;

            transaccion(sql);
            tablaAd_alumnos1.getItems().clear();
            rellenar_tabla_ProfAdministrador();

        }

    }

    public void cambiarInformes() {
        vaciarPanelTodo();
        panelMenuLateral1.setVisible(true);
        panelAdministrador.setVisible(true);
        _panelInformes.setVisible(true);
    }

    @FXML
    public void generar_informe_asignatura() {
        GenerarInforme c = new GenerarInforme("asignaturas.pdf", "asignaturas.jasper");
        c.generar(conn);
    }

}
