import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoFinal extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final int TIPO_DOCUMENTO_IDENTIFICACION = 0;
    private static final int DOCUMENTO_IDENTIFICACION = 1;
    private static final int NOMBRES = 2;
    private static final int APELLIDOS = 3;
    private static final int CORREO_ELECTRONICO = 4;
    private static final int DIRECCION_RESIDENCIA = 5;
    private static final int CIUDAD_RESIDENCIA = 6;
    private static final int TELEFONO_CONTACTO = 7;
    private static final int CONTRASENA = 8;
    private static final int CONFIRMAR_CONTRASENA = 9;

    private List<String[]> usuarios = new ArrayList<>();
    private JTextField campoTipoID;
    private JTextField campoID;
    private JTextField campoNombres;
    private JTextField campoApellidos;
    private JTextField campoCorreo;
    private JTextField campoDireccion;
    private JTextField campoCiudad;
    private JTextField campoTelefono;
    private JPasswordField campoContrasena;
    private JPasswordField campoConfirmarContrasena;
    private JTextField campoUsuario;
    private JPasswordField campoContrasenaLogin;

    public ProyectoFinal() {
        super("MyHotel");

        JTabbedPane panelPestanas = new JTabbedPane();

        JPanel panelLogin = new JPanel(new GridLayout(3, 2));
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        campoUsuario = new JTextField();
        campoContrasenaLogin = new JPasswordField();
        JButton botonIniciarSesion = new JButton("Iniciar Sesión");

        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasenaLogin.getPassword());
                boolean acceso = iniciarParametros(usuario, contrasena);
                if (acceso) {
                    JOptionPane.showMessageDialog(ProyectoFinal.this, "Bienvenido a MyHotel", "Inicio de Sesión Exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ProyectoFinal.this, "Usuario o contraseña incorrectos", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelLogin.add(etiquetaUsuario);
        panelLogin.add(campoUsuario);
        panelLogin.add(etiquetaContrasena);
        panelLogin.add(campoContrasenaLogin);
        panelLogin.add(new JLabel());
        panelLogin.add(botonIniciarSesion);

        JPanel panelRegistro = new JPanel(new GridLayout(11, 2));
        JLabel etiquetaTipoID = new JLabel("Tipo de Identificación:");
        JLabel etiquetaID = new JLabel("Número de Identificación:");
        JLabel etiquetaNombres = new JLabel("Nombres:");
        JLabel etiquetaApellidos = new JLabel("Apellidos:");
        JLabel etiquetaCorreo = new JLabel("Correo Electrónico:");
        JLabel etiquetaDireccion = new JLabel("Dirección de Residencia:");
        JLabel etiquetaCiudad = new JLabel("Ciudad de Residencia:");
        JLabel etiquetaTelefono = new JLabel("Teléfono de Contacto:");
        JLabel etiquetaContrasenaRegistro = new JLabel("Contraseña:");
        JLabel etiquetaConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        campoTipoID = new JTextField();
        campoID = new JTextField();
        campoNombres = new JTextField();
        campoApellidos = new JTextField();
        campoCorreo = new JTextField();
        campoDireccion = new JTextField();
        campoCiudad = new JTextField();
        campoTelefono = new JTextField();
        campoContrasena = new JPasswordField();
        campoConfirmarContrasena = new JPasswordField();
        JButton botonRegistrar = new JButton("Registrar");

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoID = campoTipoID.getText();
                String ID = campoID.getText();
                String nombres = campoNombres.getText();
                String apellidos = campoApellidos.getText();
                String correo = campoCorreo.getText();
                String direccion = campoDireccion.getText();
                String ciudad = campoCiudad.getText();
                String telefono = campoTelefono.getText();
                String contrasena = new String(campoContrasena.getPassword());
                String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());
                
                if (!contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(ProyectoFinal.this, "La confirmación de la contraseña es incorrecta", "Error de Registro", JOptionPane.ERROR_MESSAGE);
                } else {
                    registrarUsuario(tipoID, ID, nombres, apellidos, correo, direccion, ciudad, telefono, contrasena, confirmarContrasena);
                    JOptionPane.showMessageDialog(ProyectoFinal.this, "Usuario registrado satisfactoriamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panelRegistro.add(etiquetaTipoID);
        panelRegistro.add(campoTipoID);
        panelRegistro.add(etiquetaID);
        panelRegistro.add(campoID);
        panelRegistro.add(etiquetaNombres);
        panelRegistro.add(campoNombres);
        panelRegistro.add(etiquetaApellidos);
        panelRegistro.add(campoApellidos);
        panelRegistro.add(etiquetaCorreo);
        panelRegistro.add(campoCorreo);
        panelRegistro.add(etiquetaDireccion);
        panelRegistro.add(campoDireccion);
        panelRegistro.add(etiquetaCiudad);
        panelRegistro.add(campoCiudad);
        panelRegistro.add(etiquetaTelefono);
        panelRegistro.add(campoTelefono);
        panelRegistro.add(etiquetaContrasenaRegistro);
        panelRegistro.add(campoContrasena);
        panelRegistro.add(etiquetaConfirmarContrasena);
        panelRegistro.add(campoConfirmarContrasena);
        panelRegistro.add(new JLabel());
        panelRegistro.add(botonRegistrar);

        panelPestanas.addTab("Inicio de Sesión", panelLogin);
        panelPestanas.addTab("Registro", panelRegistro);

        add(panelPestanas);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProyectoFinal();
            }
        });
    }

    public void registrarUsuario(String tipoID, String ID, String nombres, String apellidos, String correo, String direccion, String ciudad, String telefono, String contrasena, String confirmarContrasena) {
        String[] usuario = new String[10];
        usuario[TIPO_DOCUMENTO_IDENTIFICACION] = tipoID;
        usuario[DOCUMENTO_IDENTIFICACION] = ID;
        usuario[NOMBRES] = nombres;
        usuario[APELLIDOS] = apellidos;
        usuario[CORREO_ELECTRONICO] = correo;
        usuario[DIRECCION_RESIDENCIA] = direccion;
        usuario[CIUDAD_RESIDENCIA] = ciudad;
        usuario[TELEFONO_CONTACTO] = telefono;
        usuario[CONTRASENA] = contrasena;
        usuario[CONFIRMAR_CONTRASENA] = confirmarContrasena;

        usuarios.add(usuario);
    }

    public boolean iniciarParametros(String correoElectronico, String contrasena) {
        for (String[] usuario : usuarios) {
            if (usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}