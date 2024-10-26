package com.v1.consultorio.DAO;
import com.v1.consultorio.models.HistoriaClinica;
import com.v1.consultorio.models.Paciente;
import com.v1.consultorio.models.Rol;
import com.v1.consultorio.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository; // Para indicar que es un DA
import javax.sql.DataSource; // Para inyectar el DataSource

@Repository
public class PacienteDAO {
    private final Connection connection;
    @Autowired // Inyección de dependencias para Connection, puedes usar DataSource aquí
    public PacienteDAO(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection(); // Establece la conexión desde DataSource
    }
    public Paciente getPaciente(String parametroPaciente){
    Paciente paciente =null;
    String sql = "CALL get_paciente(?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, parametroPaciente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setCuil(rs.getString("cuil"));
                paciente.setPasaporte(rs.getString("pasaporte"));
                paciente.setObraSocial(rs.getString("obra_social"));
                paciente.setFechaNacimiento(rs.getTimestamp("fechaNacimiento"));
                paciente.setEstado(rs.getBoolean("estado"));

                HistoriaClinica historia = new HistoriaClinica();
                historia.setIdHistoriaClinica(rs.getInt("idHistoriaClinica"));
                historia.setFechaCreacion(rs.getDate("fechaCreacion"));
                paciente.setHistoriaClinica(historia);


                return paciente;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String createPaciene(Paciente paciente){
        String sql = "{call create_paciente(?, ?, ?, ?, ?, ?)}";
        try(CallableStatement stmt = connection.prepareCall(sql)){
            stmt.setString(1,paciente.getNombre());
            stmt.setString(2,paciente.getCuil());
            stmt.setString(3,paciente.getPasaporte());
            stmt.setString(4,paciente.getObraSocial());
            stmt.setBoolean(5,paciente.getEstado());
            stmt.setDate(6, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return "Error desconocido al crear el paciente";
        }catch(SQLException e){
            e.printStackTrace();
            return null;

        }
    }
}
