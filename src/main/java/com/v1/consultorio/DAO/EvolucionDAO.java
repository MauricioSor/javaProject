package com.v1.consultorio.DAO;

import com.v1.consultorio.models.Diagnostico;
import com.v1.consultorio.models.Evolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EvolucionDAO {
    private final Connection connection;

    @Autowired
    public EvolucionDAO(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }
    public List<Evolucion> getEvoluciones(int idDiagnostico){
        List<Evolucion> evoluciones= new ArrayList<>();
        String sql = "CALL get_evoluciones (?)";
        try(CallableStatement stmt=connection.prepareCall(sql)){
            stmt.setInt(1,idDiagnostico);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Evolucion evolucion = new Evolucion();
                evolucion.setIdEvolucion(rs.getInt("idEvolucion"));
                evolucion.setTexto(rs.getString("texto"));
                evolucion.setFecha(rs.getDate("fecha"));
                evolucion.setHora(rs.getDate("hora"));
                // Creamos un nuevo objeto Diagnostico
                Diagnostico diagnostico = new Diagnostico();
                diagnostico.setNombre(rs.getString("nombreDiagnostico"));
                evolucion.setDiagnostico(diagnostico);
                evoluciones.add(evolucion);
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return evoluciones;
    }

}
