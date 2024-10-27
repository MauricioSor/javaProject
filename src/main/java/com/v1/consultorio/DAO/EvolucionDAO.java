package com.v1.consultorio.DAO;

import com.v1.consultorio.models.Diagnostico;
import com.v1.consultorio.models.Evolucion;
import com.v1.consultorio.models.PedidoLaboratorio;
import com.v1.consultorio.models.Receta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                evolucion.setHora(rs.getTime("hora"));
                evolucion.setEstadoEvolucion(rs.getBoolean("estadoEvolucion"));
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
    public String createEvolucion(Evolucion evolucion, int idDiagnostico) {
        String sql = "CALL create_evolucion(?, ?, ?, ?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, evolucion.getTexto());
            Date fecha = evolucion.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = sdf.format(fecha);
            stmt.setString(2, fechaString);

            // Formatear la hora
            Date hora = evolucion.getHora();
            SimpleDateFormat horaFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String horaString = horaFormat.format(hora);
            stmt.setString(3, horaString);
            stmt.setBoolean(4, evolucion.getEstadoEvolucion());
            stmt.setInt(5, idDiagnostico);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return "Evolucion Creada";
    }
    public String createPedidoLaboratorio(PedidoLaboratorio pedido,int idEvolucion){
        String sql = "CALL create_pedido(?,?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, pedido.getTexto());
            stmt.setInt(2, idEvolucion);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return "Pedido Creado";
    }
//    public String createReceta(Receta receta, int idEvolucion){
//        String sql = "CALL create_pedido(?,?,?,?,?)";
//        try (CallableStatement stmt = connection.prepareCall(sql)) {
//            stmt.setString(1, receta.getMedicamentoGenerico());
//
//            stmt.setInt(2, idEvolucion);
//            stmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "Error: " + e.getMessage();
//        }
//        return "Receta Creada";
//    }
}
