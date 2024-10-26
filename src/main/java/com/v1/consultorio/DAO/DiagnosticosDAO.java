package com.v1.consultorio.DAO;

import com.v1.consultorio.models.Diagnostico;
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
public class DiagnosticosDAO {

    private final Connection connection;

    @Autowired
    public DiagnosticosDAO(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }
    public List<Diagnostico> getDiagnostico(int idHistoriaClinica){
        List<Diagnostico> diagnosticos = new ArrayList<>();
        String sql ="CALL get_Diagnosticos(?)";
        try(CallableStatement stmt = connection.prepareCall(sql)){
            stmt.setInt(1,idHistoriaClinica);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Diagnostico diagnostico = new Diagnostico();
                diagnostico.setNombre(rs.getString("nombre"));
                diagnostico.setIdDiagnostico(rs.getInt("idDiagnostico"));
                diagnosticos.add(diagnostico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosticos;
    }
}
