package com.v1.consultorio.DAO;
import com.v1.consultorio.models.Rol;
import com.v1.consultorio.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository; // Para indicar que es un DAO
import javax.sql.DataSource; // Para inyectar el DataSource
import java.sql.Connection; // Para manejar la conexión a la base de datos
import java.sql.CallableStatement; // Para llamar a stored procedures
import java.sql.ResultSet; // Para manejar los resultados de la consulta
import java.sql.SQLException; // Para manejar excepciones de SQL
import java.util.ArrayList; // Para trabajar con listas
import java.util.List; // Para trabajar con list
@Repository
public class UsuarioDAO {
    private final Connection connection;

    @Autowired // Inyección de dependencias para Connection, puedes usar DataSource aquí
    public UsuarioDAO(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection(); // Establece la conexión desde DataSource
    }

    public List<Usuario> obtenerUsuariosPorRol(int rolId) {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "{call searchUsersByRol(?)}";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, rolId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUSUARIO"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setMail(rs.getString("mail"));
                usuario.setNombre(rs.getString("nombre"));
                // Aquí asumes que también obtienes el rol, que debería ser parte de tu consulta
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idROL")); // Asegúrate que el SP incluya idROL
                usuario.setRol(rol);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


//    public String LogIn(Usuario usuario){
//
//    }
}
